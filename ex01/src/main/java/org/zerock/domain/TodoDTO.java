package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")  //날짜 데이터 변환, @InitBinder 대신 사용
	private Date dueDate;
}
