package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j
public class ReviewController {
	private final ReviewService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list.........." + cri);
		
		List<ReviewVO> list = service.getList(cri);
		model.addAttribute("list", list);
	  //model.addAttribute("pageMaker", new PageDTO(cri, 272));
		
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	@PostMapping("/register")
	public String register(ReviewVO board, RedirectAttributes rttr) {
		log.info("resister..........");
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getReview_id());
		
		return "redirect:/board/list";
	  //DB의 변경이 일어나면 redirect방식으로 반드시 화면전환을 시켜야 한다(도배방지)
	  //PRG 패턴 : Post -> Redirect -> Get 
	  //PRG 패턴을 사용하는 이유는 멱등성 때문에
	  //게시글 작성을 Post로 전송 후 응답을 redirect가 아닌 forward로 처리할 경우
	  //새로고침 시 게시글 작성이 중복해서 처리될 수 있다
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get...modify.......");
		
		model.addAttribute("board",service.get(bno));  
	  //model.addAttribute("cri", cri);
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..........");
		
		service.remove(bno);  //삭제
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다.");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(ReviewVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify..........");
		
		service.modify(board);  //수정
		rttr.addFlashAttribute("result", "수정이 완료되었습니다.");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}	
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload.........");
	}
}
