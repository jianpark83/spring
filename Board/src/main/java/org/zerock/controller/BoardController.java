package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.dto.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
 /board/boardList -> 전체 데이터 반환
 /board/view -> 상세 페이지 
 */

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")  //테스트용, 무시
	public List<BoardVO> List(Model model) {
		log.info("-----------------list------------------");
		return boardService.selectListBoards();
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> list = boardService.selectListBoards();  //DB에서 전체데이터 가져옴
		
		model.addAttribute("boardList", list);  //전체데이터 boardList에 담는다
		
		return "boardList";  //값을 가지고 boardList.jsp로 이동
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	//JSP에서는 get로 입력받고 set로 DB에 저장하는 코딩을 직접 했었음. 하지만 스프링에서는
	//게시글 등록에서 데이터 입력 후 등록을 하면 자동으로 맵핑을 해준다
	//단, 자동으로 맵핑이 되려면 BoardVO에 있는 이름과 register.jsp에 있는 이름이 같아야 한다(setter로 등록)
	//또한 setter, getter가 준비되어 있어야 한다(@Data => getter, setter, ToString을 포함하고 있음)
	@PostMapping("/register")   
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:/board/boardList";  //DB 저장 후 boardList화면으로 전환
	}
	
	@GetMapping("/view") 
	public String viewBoard(@RequestParam("num") int num, Model model) {
		//log.info("num: " + num);  찍히는지 확인
		BoardVO vo = boardService.selectOneByNum(num);
		model.addAttribute("board", vo);
		return "boardView";
	}
	
}
