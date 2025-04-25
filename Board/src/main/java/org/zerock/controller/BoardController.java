package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board") //이클립스 BoardServlet.java 구현
public class BoardController {

	@Autowired
	private BoardService service; //BoardService 호출(BoardService.java)
	  
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> list = service.boardList();
		
		model.addAttribute("boardList", list);
		
		return "boardList";
	}
}
