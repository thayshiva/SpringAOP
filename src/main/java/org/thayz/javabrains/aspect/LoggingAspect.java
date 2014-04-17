package org.thayz.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.thayz.javabrains.model.Circle;

@Aspect
public class LoggingAspect {
	
	@Before("allGetters()")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println(joinPoint.toString());
	}
	
	@Before("allCircleMethods()")
	public void secondAdvice(){
		System.out.println("Second Advice executed.");
	}
	
	@Before("allCircleMethods1()")
	public void thirdAdvice(){
		System.out.println("Third Advice executed.");
	}
	
	@Pointcut("execution( * get*(..))")
	public void allGetters(){}
	
	@Pointcut("execution( * org.thayz.javabrains.model.Circle.*(..))")
	public void allCircleMethods(){}
	
	@Pointcut("within(org.thayz.javabrains.model.Circle)")
	public void allCircleMethods1(){}
	
	@Around("performancePointcut()")
	public void logRoundTripTime(ProceedingJoinPoint proceedingJoinPoint){
		long startTime = System.currentTimeMillis();
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long totTime = endTime - startTime;
		System.out.println("Time take to execute is "+totTime);
	}
	
	@Pointcut("execution( * org.thayz.javabrains.model.Circle.getName(..))")
	public void performancePointcut(){}
	
	@AfterReturning("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("The Value is : "+name);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name){
		System.out.println("An exception is thrown.");
	}
	/*@Before("execution( * org.thayz.javabrains.model.Circle.get*(..))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Advice run. Before getName method called.");
	}
	
	@Before("execution(public String getName())")
	public void loggingAdvice(){
		System.out.println("Advice run. Before getName method called.");
	}
	
	@Before("execution(* get*(..))")
	public void loggingAdvice1(){
		System.out.println("Advice run. Before getName method called.");
	}*/
}
