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
@RequestMapping("/review")
@RequiredArgsConstructor
@Log4j
public class ReviewController {
	private final ReviewService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list.........." + cri);
		
		List<ReviewVO> list = service.getList(cri);
		model.addAttribute("list", list);		
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	@PostMapping("/register")
	public String register(ReviewVO review, RedirectAttributes rttr) {
		log.info("resister..........");
		service.register(review);
		
		rttr.addFlashAttribute("result", review.getReview_id());
	    log.info("result ID: " + review.getReview_id());
	    
		return "redirect:/review/list";

	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam Long review_id, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get...modify.......");
		
		service.updateCount(review_id);  //조회수 증가
		
	    model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	    model.addAttribute("review",service.get(review_id));  

	}
	
	@PostMapping("/remove")
	public String remove(Long review_id, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..........");
		
		service.remove(review_id);  //삭제
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다.");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/review/list";
	}
	
	@PostMapping("/modify")
	public String modify(ReviewVO review, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify..........");
		
		service.modify(review);  //수정
		rttr.addFlashAttribute("result", "수정이 완료되었습니다.");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/review/list";
	}	

	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload.........");
	}
}
