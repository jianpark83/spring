package org.zerock.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  //스프링 테스트 하겠다
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")  //이 파일을 이용하겠다
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	//DB연동 테스트
	@Test
	public void testConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			log.info("conn >> " + conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testConnection2() {
		try(Connection conn = dataSource.getConnection()) {  //try 구문안에 작성할 경우 자동으로 close 해준다. 위 연동테스트와 같은 코드임
			log.info("conn => " + conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
