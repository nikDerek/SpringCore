package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * this logging aspoect is modularization of a cross cutting concern, that cross cutting being logging.
 * we will handle all of the application's logging from here
 * 
 * @Aspect comes from an AspectJ since that is our implementation
 */

@Aspect
@Component
public class LoggingAspect {
/*
 * if this is a logging aspect, I should create a logger
 */	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	/*
	 * now determine where I want my advice to potentially be injected.  I can do this using a Pointcut, which
	 * allows us to use "point cut expressions" to determine where code might later be injected.
	 */
	@Pointcut("within(com.revature.service..*)")
	public void serviceLog() {}
	
	/*
	 * Lets determine:
	 * 1. what advice should be injected (code that will be injected at some point)
	 * 2. determine when it should be injected(before? after?)
	 */
	/*
	 * this method will use serviceLog() pointcut and the @Before will inject advice before method invokes
	 */
	@Before(value="serviceLog()")
	public void logBeforeService(JoinPoint jp) {
		/*
		 * this is my advice
		 */
		LOGGER.warn("Before Advice. The: "+jp.getSignature().getName() + " method has been called.");
	}
	
	@After(value = "serviceLog()")
	public void logAfterService(JoinPoint jp) {
		LOGGER.warn("After Advice. The: "+jp.getSignature().getName() + " method has been called.");
	}
	
	/*
	 * injected after a method returns
	 */
	@AfterReturning(value = "serviceLog()", returning = "returnedUsers")
	public void logAfterServiceReturn(JoinPoint jp, Object returnedUsers) {
		LOGGER.warn("Return Advice. The: "+jp.getSignature().getName() + " method has returned.");
	}
	
	@AfterThrowing(value = "serviceLog()", throwing = "thrownException")
	public void logAfterServiceException(JoinPoint jp, Exception thrownException) {
		LOGGER.warn("AfterThrowing Advice. The: "+jp.getSignature().getName() 
				+ " method has thrown an exception of type "+ thrownException);
	}
	
	/*
	 * invokes advice befiore and after. not recommende to use unless absolutely needed. it is so powerful
	 * that it stops method invocations entirely.  as it is capable of stopping invication it has access to a 
	 * ProceedingJoinPoint.
	 */
//	@Around("serviceLog()")
//	public Object logAroundAdvice(ProceedingJoinPoint pjp) {
//		
//		Object returnedObject = null;
//		
//		LOGGER.warn("Around Advice. The: "+pjp.getSignature().getName() +" will be and has been invoked");
//		
//		try {
//			returnedObject = pjp.proceed();
//		}catch (Throwable e){
//			e.printStackTrace();
//		}
//		return returnedObject;
//	}
}
