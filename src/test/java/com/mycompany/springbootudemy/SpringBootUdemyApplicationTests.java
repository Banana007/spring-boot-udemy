package com.mycompany.springbootudemy;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.mycompany.springbootudemy.web.i18n.I18Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringBootUdemyApplicationTests {

	@Autowired
	private I18Service i18service;

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void testMessageByLocaleService() throws Exception{
		String excpectedResult  = "Bootstrap starter template";
		String messageId = "index.main.callout";
		String actual = i18service.getMessage(messageId);
		Assert.assertEquals("The actual and expected String don't match", excpectedResult,actual);
	}

}
