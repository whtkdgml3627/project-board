package org.zerock.board;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class BoardApplicationTests {

	@Autowired(required = false)
	DataSource dataSource;

	@Test
	public void connectionTest(){
		try(Connection conn = dataSource.getConnection()) {

			log.info("========================");
			log.info("========================");
			log.info(conn);
			log.info("========================");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void contextLoads() {
	}

}
