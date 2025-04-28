package org.zerock.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dto.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test  //0. DB 연동 테스트
	public void test() {
		log.info("boardRepository >> " + boardRepository);
	}
	
	@Test  //1. 전체 데이터 조회 테스트
	public void selectAlltest() {
		
		List<BoardVO> list = boardRepository.selectAllBoards();
		for(BoardVO vo : list)
			log.info(vo);
		
      //log.info("------------------");
		
	  //boardRepository.selectAllBoards().forEach(board -> log.info(board));
	}
	
	@Test  //2. 단건 데이터 조회 테스트
	public void selectOneByNumTest() {
		
		BoardVO vo = boardRepository.selectOneByNum(1);
		log.info("vo >> " + vo);
	}
	
	@Test  //3. 데이터 추가 테스트
	public void insertBoardTest() {
		
		BoardVO vo = new BoardVO();
		
		vo.setName("안나");
		vo.setPass("1234");
		vo.setEmail("test@test.com");
		vo.setTitle("말 안듣는 딸");
		vo.setContent("시크한 딸 안나");
		
		boardRepository.insertBoard(vo);
	}
	
	@Test  //4. 데이터 변경 테스트
	public void updateBoardTest() {
		
		BoardVO vo = new BoardVO();
		
		vo.setName("자바");
		vo.setPass("1234");
		vo.setEmail("java@java.com");
		vo.setTitle("자바 코딩");
		vo.setContent("너무 어려운 자바");
		vo.setNum(61);
		
		boardRepository.updateBoard(vo);
	}

	@Test  //5. 데이터 삭제 테스트
	public void deleteBoardTest() {
		boardRepository.deleteBoard(62);
	}
	
	@Test  //6. 조회수 증가 테스트
	public void updateReadCountTest() {
		boardRepository.updateReadCount(1);
	}
}
