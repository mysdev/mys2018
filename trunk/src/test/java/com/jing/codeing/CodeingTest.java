package com.jing.codeing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jing.codeing.service.CodeingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeingTest {
	@Autowired
	private CodeingService codeingService;

	//@Test
	public void generate() throws Exception {
		codeingService.generate("158");
	}
	
	@Test
	public void readDbTable() throws Exception {
		codeingService.readDbTable("tb_employee");
	}
}
