package com.harsha.FarmerInfo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
	@Before(value = "execution(* prepareFormerInfo*(..))")
	public void addsysout() {
		log.info("before Advice");
	}

	@After(value = "execution(* prepareFormerInfo*(..))")
	public void aftersysout(JoinPoint joinPoint) {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		log.info("After Advice class Nmae :" + classname + "  method name :" + methodname);
	}

	@AfterReturning(value = "execution(* prepareFormerInfo*(..))")
	public void afterreturning(JoinPoint joinPoint) {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		log.info("After Advice class Nmae :" + classname + "  method name :" + methodname);
	}

	@Around(value = "execution(* prepareFormerInfo*(..))")
	public Object aroundsysout(ProceedingJoinPoint joinPoint) throws Throwable {
		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String methodname = joinPoint.getSignature().getName();
		log.info("Around Advice before class Nmae :" + classname + "  method name :" + methodname);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		log.info("Around Advice after  time tken " + stopWatch.getTotalTimeMillis());
		return result;
	}

	@AfterThrowing(value = "execution(* prepareFormerInfo*(..))", throwing = "e")
	public void afterthrowingsysout(Exception e) {
		log.info("After throwing   Exception" + e);
	}
}
