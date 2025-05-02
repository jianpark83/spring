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
	
	//localhost:8080/board/boardList => 전체 리스트 목록
	//localhost:8080/board/ => 전체 리스트 목록
	@GetMapping({"/", "/boardList"})
	public String boardList(Model model) {
		
		List<BoardVO> list = boardService.selectListBoards();  //DB에서 전체데이터 가져옴
		
		model.addAttribute("boardList", list);  //전체데이터 boardList에 담는다
		
		return "boardList";  //값을 가지고 boardList.jsp로 이동
	}
	
	//localhost:8080/board/register(get) => 멤버 등록 화면 출력
	@GetMapping("/register")
	public String register() {
		return "boardregister";
	}

	//JSP에서는 get로 입력받고 set로 DB에 저장하는 코딩을 직접 했었음. 하지만 스프링에서는
	//게시글 등록에서 데이터 입력 후 등록을 하면 자동으로 맵핑을 해준다
	//단, 자동으로 맵핑이 되려면 BoardVO에 있는 이름과 register.jsp에 있는 이름이 같아야 한다(setter로 등록)
	//또한 setter, getter가 준비되어 있어야 한다(@Data => getter, setter, ToString을 포함하고 있음)
	
	//localhost:8080/board/register(post) => 등록화면에서 입력한 데이터를 기반으로 DB등록
	@PostMapping("/register")   
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);  //저장
		return "redirect:/board/boardList";  //DB 저장 후 boardList화면으로 전환
	}
	/*
	@GetMapping("/view") 
	public String viewBoard(@RequestParam("num") int num, Model model) {
	  //log.info("num : " + num);  찍히는지 확인
		BoardVO vo = boardService.selectOneByNum(num);
		model.addAttribute("board", vo);
		return "boardView";
	}
	*/
	//localhost:8080/board/view => num(기본키) 해당하는 상세 페이지
	@GetMapping("/view") 
	public String viewBoard(@RequestParam int num, Model model) {
		boardService.updateReadCount(num);  //조회수 증가
	  //DB에서 num(기본키) n번 전체 데이터 가져와서 vo에 저장(n번은 DB에 존재하는 기본키)
		BoardVO vo = boardService.selectOneByNum(num);
		
	  //vo에 저장된 num()번 데이터를 board 변수에 담아서 boardview.jsp로 전달
		model.addAttribute("board", vo);  
		return "boardView";
	}
	
	//localhost:8080/board/check(get) => 삭제, 수정시 입력화면 출력
	@GetMapping("/check")
	public String checkGet(@RequestParam int num, Model model) {
	  //log.info("check >> " + num);  num값 잘 들어오는지 찍어보기(Console창 확인)
		model.addAttribute("num", num);  //model에 num값 담아서 checkBoard.jsp로 전달
		return "checkBoard";
	}
	
	//localhost:8080/board/check(post) => 삭제, 수정시 DB조회해서 비밀번호 체크
	@PostMapping("/check")  //checkBoard.jsp에서 전달받기
	public String checkPost(@RequestParam int num, @RequestParam String pass, Model model) {
      //log.info("check Post >> " + num + " : " + pass);  num값과 pass값이 제대로 들어오는지 확인
	  //서비스 호출해서 true면(비밀번호 맞음), false면(비밀번호 틀림) 받환 받는다
		boolean check = boardService.checkPassword(num, pass);
		
		if(check) {
	      //비밀번호 맞음
			model.addAttribute("num", num);
			return "checkSuccess";
		}else {
		  //비밀번호 틀림
			model.addAttribute("message", "비밀번호가 틀립니다.");
			model.addAttribute("num", num);  //1번 이상 틀릴때도 계속 체크할 수 있게 하기 위해 num값 전달
			return "checkBoard";
		}
	}
	
	//localhost:8080/board/delete => num 해당하는 데이터(DB) 삭제
	@GetMapping("/delete")
	public String deleteGet(@RequestParam int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/boardList";
	}
	
	//localhost:8080/board/update(get) => 수정화면 출력
	@GetMapping("/update")
	public String updateGet(@RequestParam int num, Model model) {
		//log.info("update >> " + num);
		BoardVO vo = boardService.selectOneByNum(num);  //전체 데이터 불러오기
		model.addAttribute("board", vo);
		return "boardupdate"; 
	}
	
	//localhost:8080/board/update(post) => 수정화면에서 입력한 내용을 DB에 반영
	@PostMapping("/update")
	public String updatePost(BoardVO vo) {
	    boardService.updateBoard(vo);   //여기서 실제로 DB에 수정
	    return "redirect:/board/view?num=" + vo.getNum();   //DB 저장 후 상세페이지 화면으로 전환
	}
}
