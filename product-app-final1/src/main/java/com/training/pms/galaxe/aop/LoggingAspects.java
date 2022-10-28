package com.training.pms.galaxe.aop;

import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {

	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doLogging() {
		System.out.println("###Logged in at :"+new Date()+ " By Aspects");
	}

	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSomeWork() {
		System.out.println("###Do Some work called at :"+new Date()+ " By Aspects");
	}
	
	@Around(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public Object doSomeWork2(ProceedingJoinPoint point) throws Throwable {
		Signature methods = point.getSignature();		
		System.out.println("1. ###Before the method gets called :: "+new Date()+ " By Aspects");
		//decide whether to proceed with the method execution
		Object retval = point.proceed();
		System.out.println("4. ###After the method gets called :: "+new Date()+ " By Aspects");
		return retval;
	}
	
	//The @Around will work only when isProductExists() method gets triggered as it is mentioned in line 28.
	//If the return type of isProductExists() is boolean, then the return type of doSomeWork2() method at line 29 also should be boolean.
	//We can give * at line number in the place of isProductExists() only when the return type of all the methods are same.
	//Line number 32 is to proceed with the execution of the method.
}