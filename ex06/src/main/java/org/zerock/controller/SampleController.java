package org.zerock.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample")
public class SampleController {

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")  //'ROLE_ADMIN' 또는 'ROLE_MEMBER' 권한 있는 자만 접근 가능!!
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdimin2() {
		log.info("admin annotation only");
	}
	
	@GetMapping("/all")   //로그인 or 로그인 안한 자도 접근 가능
	public void doAll() {
		log.info("do all can access everybody");
	}
	
	@GetMapping("/member")   //로그인한 자만 호출 가능
	public void doMember() {
		log.info("logined member");
	}
	
	@GetMapping("/admin")   //관리자만 호출 가능
	public void doAdmin() {
		log.info("admin only");
	}	
}
