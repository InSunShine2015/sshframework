package com.jesus.sshframework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

public class HibernateTest {
	
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		
		User user = new User();

		user.setUsername("测试乱码");
		user.setPassword("我是要加密的");
		userService.save(user);
	}
}
