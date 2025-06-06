package org.zerock.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
@WebAppConfiguration   
public class ReviewControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/review/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
		);
	}

	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/review/register")
				.param("review_title", "테스트 새글 제목")
				.param("review_content", "테스트 새글 내용")
				.param("writer_name", "테스트 새글 작성자")
				.param("restaurant_name", "테스트 식당")
				.param("region", "서울")
				.param("rating", "5")
		).andReturn()
		.getModelAndView()
		.getViewName();

		log.info("=============> " + resultPage);
	}

	@Test
	public void testGet() throws Exception {
		log.info(
			mockMvc.perform(MockMvcRequestBuilders
				.get("/review/get")
				.param("review_id", "3"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
		);
	}

	@Test
	public void testDelete() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/review/remove")
				.param("review_id", "16")
		).andReturn()
		.getModelAndView()
		.getViewName();

		log.info("=============> " + resultPage);
	}

	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/review/modify")
				.param("review_id", "15")
				.param("review_title", "수정된 제목")
				.param("review_content", "수정된 내용")
				.param("writer_name", "수정된 작성자")
				.param("restaurant_name", "수정된 식당")
				.param("region", "부산")
				.param("rating", "4")
		).andReturn()
		.getModelAndView()
		.getViewName();

		log.info("=============> " + resultPage);
	}
}
