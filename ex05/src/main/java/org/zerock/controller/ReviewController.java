package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.Criterial;
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

    // ✅ 리스트 + 검색 + 페이징
    @GetMapping("/list")
    public String list(Criterial cri, Model model) {
        log.info("리스트 요청: " + cri);

        if (cri.getPageNum() <= 0) {
            cri.setPageNum(1);
        }

        if (cri.getType() == null) cri.setType("");
        if (cri.getKeyword() == null) cri.setKeyword("");
        if (cri.getAmount() == 0) cri.setAmount(10);

        List<ReviewVO> list = service.getList(cri);
        model.addAttribute("list", list);

        int total = service.getTotal(cri);
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        
      
        return "review/list";
    }

    // ✅ 등록 폼
    @GetMapping("/register")
    public void register() { }

    @PostMapping("/register")
    public String register(@ModelAttribute ReviewVO review,
                           @RequestParam(value = "upload", required = false) MultipartFile file,
                           RedirectAttributes rttr) {

        log.info("register.......");

        String uploadDir = "C:/upload/";
        File uploadPath = new File(uploadDir);

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            review.setFileName(fileName);
            try {
                file.transferTo(new File(uploadPath, fileName));
            } catch (IOException e) {
                log.error("파일 저장 실패", e);
            }
        } else {
            review.setFileName(""); // null 방지
        }

        service.register(review);
        rttr.addFlashAttribute("result", review.getReview_id());

        rttr.addAttribute("pageNum", 1);
        rttr.addAttribute("amount", 10);

        return "redirect:/review/list";
    }

  
    // ✅ 조회수 증가 X
    @GetMapping("/modify")
    public void modify(@RequestParam Long review_id, Criterial cri, Model model) {
        log.info("modify........");
        model.addAttribute("review", service.get(review_id));
        model.addAttribute("cri", cri);
    }
    
    // ✅ 삭제
    @PostMapping("/remove")
    public String remove(Long review_id,
                         @ModelAttribute("cri") Criterial cri,
                         RedirectAttributes rttr) {
        log.info("remove......");

        if (service.remove(review_id)) {
            rttr.addFlashAttribute("result", "삭제 성공했습니다.");
        }

        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/review/list";
    }

    // ✅ 수정
    @PostMapping("/modify")
    public String modify(ReviewVO review,
                         @RequestParam(value = "upload", required = false) MultipartFile file,
                         @ModelAttribute("cri") Criterial cri,
                         RedirectAttributes rttr) {
        log.info("modify.........");

        // 파일 업로드 처리
        String uploadDir = "C:/upload/";
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        if (file != null && !file.isEmpty()) {
            review.setFileName(file.getOriginalFilename());
            try {
                file.transferTo(new File(uploadPath, file.getOriginalFilename()));
            } catch (IOException e) {
                log.error("파일 저장 실패", e);
            }
        }

        if (review.getFileName() == null) {
            review.setFileName("");
        }

        if (service.modify(review)) {
            rttr.addFlashAttribute("result", "수정 성공했습니다.");
        }

        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/review/list";
    }
    
    @GetMapping("/get")
    public String getReview(@RequestParam("review_id") Long reviewId, Criterial cri, Model model) {
        service.increaseViewCount(reviewId);
        model.addAttribute("review", service.get(reviewId));
        model.addAttribute("cri", cri); // ← 검색 조건 같이 넘기기
        return "review/get";
    }
    
    
}
