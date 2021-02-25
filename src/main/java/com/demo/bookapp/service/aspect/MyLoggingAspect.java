package com.demo.bookapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyLoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(MyLoggingAspect.class);
	
	@Around("@annotation(MyLogger)")
	public Object aroundLogging(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		Object returnVal = pjp.proceed();
		long end = System.currentTimeMillis();
		
		logger.info("Method	took "+ (end-start) + " method name " + pjp.getSignature().getName());
		return returnVal;
		
	}
	
}
