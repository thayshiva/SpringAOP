package org.thayz.javabrains.service;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeServiceTest {

	private ShapeService shapeService;
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-aop.xml");
		shapeService = (ShapeService) context.getBean("shapeService");
	}

	@After
	public void tearDown() throws Exception {
		shapeService = null;
	}

	@Test
	public void test() {
		assertNotNull(shapeService);
		String name = shapeService.getCircle().getName();
		System.out.println(name);
		
		shapeService.getCircle().setName("circle-2");
		/*String name1 = shapeService.getTriangle().getName();
		
		System.out.println("Name of the traingle: "+name1);*/
	}

}
