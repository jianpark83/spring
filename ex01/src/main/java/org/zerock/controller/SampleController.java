package org.zerock.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
//localhost:8080/sample/* 까지의 요청을 받겠다(경로)
@RequestMapping("/sample")
@Log4j
public class SampleController {

	/*
	 * 반환타입 => void, "" => 파일명
	 * "/"             => /view/sample.jsp
	 * "/basic"        => /view/sample/basic.jsp
	 * "/basicOnlyGet" => /view/sample/basicOnlyGet.jsp
	 */
	
	//return타입이 void일 경우 view화면은 경로명으로 찾는다!!
	//return "aaa";  => 반환타입이 void가 아닌 String일 경우 => /view/aaa.jsp
	@RequestMapping("/")    
	public void basic() {
		log.info("basic.............");
	}
	
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public void basicGet() {
		log.info("basic get.............");
	}
	
	@GetMapping("/basicOnlyGet")  
	public void basicGet2() {
		log.info("basic get Only get..............");
	}
	
	//localhost:8080/sample/ex01?name=kim&age=20 자동으로 맵핑
	//view/ex01.jsp
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam String name, 
			@RequestParam int age, Model model) {   //값을 넘겨줄 경우 Model로
		log.info(name);
		log.info(age);
		model.addAttribute("name", name);  //ex02에 name값을 보내겠다
		model.addAttribute("age", age);  //ex02에 age값을 보내겠다
		return "ex02";
	}
	
//	@InitBinder  => 날짜 데이터 변환
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	//localhost:8080/sample/ex03?title=spring&dueDate=2025-05-01 
	@GetMapping("/ex03")
	public String ex03(TodoDTO todoDTO) {
		log.info(todoDTO);
		return "ex03";
	}
	//p.142 @ModelAttribute
	
	//localhost:8080/sample/ex04?name=kim&age=20&page=5
	//view/sample/ex04.jsp + page, sample
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info(dto);
		log.info(page);
		model.addAttribute("page", page);
		model.addAttribute("sample", dto);
		return "sample/ex04";
	}
	/*
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info(dto);
		log.info(page);
		return "sample/ex04";
	} 
	
	//view/sample/ex04.jsp + page, sampleDTO
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @RequestParam int page, Model model) {
		log.info(dto);
		log.info(page);
		model.addAttribute("sampleDTO", dto);  ""안 이름은 변경 가능
		model.addAttribute("page", page);
		return "sample/ex04";
	} */
	
	
	//p.143 RedirectAttributes
	//localhost:8080/sample/rttr?name=kim&age=20
	//sample/ex04.jsp
	@GetMapping("/rttr")
	public String rttr(SampleDTO dto, RedirectAttributes rttr) {
		rttr.addFlashAttribute("sampleDTO", dto);  //메모리 저장공간에 있는 값을 최초 한번만 전달한다
		return "redirect:/sample/ex04";  //sample/ex04로 다시 요청해!!
	}
	
	/*
	@GetMapping("/ex06")  
	//@ResponseBody => java객체를 json으로 변환(요청한 브라우저에 JSON데이터로 전달해라!!) 
	public @ResponseBody SampleDTO ex06() {  //pom.xml에 Jackson Databind 추가 필요 
		log.info("/ex06............"); 
		SampleDTO dto = new SampleDTO();
	    dto.setAge(10); 
	    dto.setName("홍길동"); 
	    return dto; 
	}
	*/
	//객체를 생성 후 반환할 때 lombok을 사용할 수도 있다
	//@Builder, @AllArgsConstructor, @NoArgsConstructor 세트 사용
	//@Builder 사용 시 객체를 좀 더 직관적으로 쓸 수 있다
	@GetMapping("/ex06")  
	public @ResponseBody SampleDTO ex06() { 
		log.info("/ex06............");
		return SampleDTO.builder()
				.name("park")
				.age(29)
				.build();		
	}
	
	//localhost:8080/sample/ex06_1 + json 데이터 전달(postman등..)
	@GetMapping("/ex06_1")
	//@RequestBody => json을 java 객체로 변환(값만 전달)
	public String ex06_1(@RequestBody SampleDTO dto) {  
		log.info("/ex06_1............");
		log.info(dto);
		return "ex06_1";
	}
	
	@GetMapping("/ex07")  //상태 코드까지 전달
	public ResponseEntity<String> ex07(){
		// {"name" : "홍길도"}
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders headers =  new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<String>(msg, headers, HttpStatus.ACCEPTED);
	}
}
