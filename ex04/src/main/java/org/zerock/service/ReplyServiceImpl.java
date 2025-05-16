package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper mapper;
	private final BoardMapper boardMapper;
	
	@Transactional //둘중 하나라도 처리가 안될경우(error) 취소(원상복구)
	@Override  //댓글 추가
	public int register(ReplyVO vo) {		
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);  //등록 전 댓글수 증가(+1)
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1); //삭제하기 전에 댓글수 감소(-1)
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criterial cri, Long bno) {
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criterial cri, Long bno) {
		return new ReplyPageDTO(
				mapper.getCountByBno(bno), 
				mapper.getListWithPaging(cri, bno));
	}

}