package com.harsha.FarmerInfo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class FarmerInfoAspect {
	@Before(value = "execution(com.harsha.FarmerInfo..*.*(..)")
	public void addsysout(JoinPoint joinPoint) {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		log.info("Method execution started :" + classname + "  method name :" + methodname);
	}

	@After(value = "execution(com.harsha.FarmerInfo..*.*(..)")
	public void aftersysout(JoinPoint joinPoint) {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		log.info("Method execution ended :" + classname + "  method name :" + methodname);
	}

	/*
	 * @AfterReturning(value = "execution(* prepareFormerInfo*(..))") public void
	 * afterreturning(JoinPoint joinPoint) { String classname =
	 * joinPoint.getSignature().getDeclaringType().getName(); String methodname =
	 * joinPoint.getSignature().getName(); log.info("After Advice class Nmae :" +
	 * classname + "  method name :" + methodname); }
	 */

	@Around(value = "execution(* prepareFormerInfo*(..))")
	public Object aroundsysout(ProceedingJoinPoint joinPoint) throws Throwable {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		log.info("Metod execution :" + classname + "  method name :" + methodname + "time taken "
				+ stopWatch.getTotalTimeMillis());
		return result;
	}

	@AfterThrowing(value = "execution(* prepareFormerInfo*(..))", throwing = "e")
	public void afterthrowingsysout(Exception e) {

		// JMS email
		log.info("After throwing   Exception" + e);
	}
}
