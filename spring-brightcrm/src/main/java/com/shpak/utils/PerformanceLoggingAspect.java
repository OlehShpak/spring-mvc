package com.shpak.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shpak.controller.CustomerController;


@Aspect
public class PerformanceLoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLoggingAspect.class);
	
	@Pointcut("execution(* com.shpak.persistence.service.*ServiceImpl.*(..))")
	private void serviceImpl(){}
	
	@Pointcut("execution(* com.shpak.utils.*ValidatorImpl.*(..))")
	private void validatorImpl(){}
	
	//How long is executed every method in com.shpak.persistence.* classes
	
	@Around("serviceImpl()")
	public Object customerAround(ProceedingJoinPoint joinPoint) {
		 long start = System.currentTimeMillis();
	        Object value = null;
	        try {
	            value = joinPoint.proceed();
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	        long end = System.currentTimeMillis();
	        long result= end-start;
	        LOGGER.info("<serviceAdvice> Method "+joinPoint.getSignature().getName()+" completed in (ms): "+result+" </serviceAdvice>");
	        return value;
		
	} 
	
	//How long is executed every method in com.shpak.utils.InputDBValidatorImpl
	
	@Around("validatorImpl()")
	public Object validatorAround(ProceedingJoinPoint joinPoint) {
		 long start = System.currentTimeMillis();
	        Object value = null;
	        try {
	            value = joinPoint.proceed();
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	        long end = System.currentTimeMillis();
	        long result= end-start;
	        LOGGER.info("<validatorAdvice> Method "+joinPoint.getSignature().getName()+" completed in (ms): "+result+" </validatorAdvice>");
	        return value;
		
	} 
	
}
