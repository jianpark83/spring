package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder  
//@Builder 사용 시 꼭 필요!!(@AllArgsConstructor, @NoArgsConstructor) 3개 세트!!
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {
	
	private String name;
	private int age;
	
	
	/* @NoArgsConstructor
	public SampleDTO{
	
	}
	*/
	/* @AllArgsConstructor
	public SampleDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	*/
}
