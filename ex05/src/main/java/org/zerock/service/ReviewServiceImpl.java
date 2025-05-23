package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criterial;
import org.zerock.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor  //생성자 주입
public class ReviewServiceImpl implements ReviewService{

	//@RequiredArgsConstructor + final
	private final ReviewMapper mapper;
	
	@Override
	public void register(ReviewVO review) {
		log.info("register..........." + review);
		mapper.insertSelectKey(review);
	}

	@Override
	public ReviewVO get(Long review_id) {
		log.info("get............." + review_id);
		return mapper.read(review_id);
	}

	@Override
	public boolean modify(ReviewVO review) {
		log.info("modify.......");
		
		return  mapper.update(review) == 1;
	}

	@Override
	public boolean remove(Long review_id) {
		log.info("remove.......");
		
		return  mapper.delete(review_id) == 1;
	}

	@Override
	public List<ReviewVO> getList(Criterial cri) {
		log.info("getList............");		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criterial cri) {
		log.info("getTotal...........");
		return mapper.getTotalCount(cri);
	}

	@Override
	public void increaseViewCount(Long review_id) {
		mapper.increaseViewCount(review_id);
	}

}
