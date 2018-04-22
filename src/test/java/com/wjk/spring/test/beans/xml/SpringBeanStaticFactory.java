package com.wjk.spring.test.beans.xml;

public class SpringBeanStaticFactory {

	public static Person getPerson() {
		return new Person();
	}
}
