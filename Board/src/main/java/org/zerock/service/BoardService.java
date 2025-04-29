package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dto.BoardVO;
import org.zerock.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

//	@Autowired  //필드 주입
//	private BoardRepository boardRepository;
	
	//위에 있는 필드 주입보다 생성자 주입을 더 많이 사용한다
	//생성자 주입 @RequiredArgsConstructor 와 final 사용
	private final BoardRepository boardRepository; 
	
	public List<BoardVO> selectListBoards() {
		return boardRepository.selectAllBoards();
	}
	
	public BoardVO selectOneByNum(int num) {
		return boardRepository.selectOneByNum(num);
	}
	
	public void insertBoard(BoardVO vo) {
		boardRepository.insertBoard(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		boardRepository.updateBoard(vo);
	}
	
	public void deleteBoard(int num) {
		boardRepository.deleteBoard(num);
	}
	
	public void updateReadCount(int num) {
		boardRepository.updateReadCount(num);
	}
	
	public boolean checkPassword(int num, String pass) {
		BoardVO vo = boardRepository.selectOneByNum(num);
		
	  //입력받은 비밀번호와 DB저장된 비밀번호가 같은지 비교
		if(vo.getPass().equals(pass)) {
			return true;  
		}else {
			return false;
		}
	}
}
