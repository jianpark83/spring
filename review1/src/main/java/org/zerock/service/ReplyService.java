package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno); //조회
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criterial cri, Long bno);
	
	public ReplyPageDTO getListPage(Criterial cri, Long bno);
}
