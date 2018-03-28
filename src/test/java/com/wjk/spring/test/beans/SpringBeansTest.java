package com.wjk.spring.test.beans;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringBeansTest {

	@Test
	public void SpringBeansTestFactory() {
		
		BeanFactory beans1 = new XmlBeanFactory(new ClassPathResource("spring_context_test.xml"));
		
		@SuppressWarnings("resource")
		ApplicationContext beans = new ClassPathXmlApplicationContext("spring_context_test.xml");  
		
		MyTestBean my = (MyTestBean) beans.getBean("myTestBean");
		
		System.out.println(my.getMsg());
		
	}
}
