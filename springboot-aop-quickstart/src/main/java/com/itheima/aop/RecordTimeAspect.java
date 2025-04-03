package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect  //标识是一个AOP类
@Component
public class RecordTimeAspect {
    @Around("execution(* com.itheima.service.impl.*.*(..))") //切入点表达式
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = pjp.proceed(); //执行目标方法

        long end = System.currentTimeMillis();
        log.info("方法:{} 执行耗时：{}ms", pjp.getSignature(),end - begin);
        return result;
    }
}
