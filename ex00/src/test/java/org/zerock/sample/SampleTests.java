package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	@Autowired   //컨테이너에 가서 restaurant 타입이 있으면 찍어줘(주소값 참조) -> 제어의 역전|(IoC)
	private Restaurant restaurant;
	
	@Test
	public void testRest() {
		log.info("--------------------------");
		log.info("restaurant : " + restaurant);
		restaurant.sample();
	}
}
