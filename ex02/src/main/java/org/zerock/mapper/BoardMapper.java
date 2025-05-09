package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	public BoardVO read(Long bno);
	
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);  //DB에 데이터 저장
	
	public void insertSelectKey(BoardVO board);  //DB에 저장할 때 등록번호 확인
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);  
	
	public int getTotalCount(Criteria cri);
	
	public List<BoardVO> searchTest(Map<String, Map<String,String>> map);
}
