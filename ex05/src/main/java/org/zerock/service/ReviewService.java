package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criterial;

public interface ReviewService {

	public void register(ReviewVO review); //등록
	
	public ReviewVO get(Long review_id); //1건 조회
	
	public boolean modify(ReviewVO review); //수정
	
	public boolean remove(Long review_id); //삭제
	
	public List<ReviewVO> getList(Criterial cri); //전제 데이타 조회
	
	public int getTotal(Criterial cri); //전체 레코드 조회 or 조건 맞는 데이타 조회
	
	public void increaseViewCount(Long review_id); //조회수
}
