package com.wjk.spring.test.beans.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansTest {

	@Test
	@SuppressWarnings("resource")
	public void SpringBeansTestFactory() {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("spring_context_test.xml");  
		
		Person person = (Person) beans.getBean("person");
		
		person.sys();
		
		Person staticPersonFactory = (Person) beans.getBean("staticPersonFactory");
		
		staticPersonFactory.sys();
		
		Person person1 = (Person) beans.getBean("person1");
		
		person1.sys();
		
	}
}
