package com.example.ss9.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class LoggingAspect {

    // ================== ĐẾM VIEW ==================
    private static AtomicInteger counter = new AtomicInteger(0);

    @AfterReturning("execution(* com.example.ss9.service.IBorrowService.borrowBook(..))")
    public void logBorrow(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        System.out.println("===== BORROW SUCCESS =====");
        System.out.println("Book ID: " + args[0]);
        System.out.println("Time: " + java.time.LocalDateTime.now());
    }

    @AfterReturning("execution(* com.example.ss9.service.IBorrowService.returnBook(..))")
    public void logReturn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        System.out.println("===== RETURN SUCCESS =====");
        System.out.println("Code: " + args[0]);
        System.out.println("Time: " + java.time.LocalDateTime.now());
    }

    @AfterThrowing(pointcut = "execution(* com.example.ss9.service.IBorrowService.*(..))", throwing = "ex")
    public void logError(Exception ex) {
        System.out.println("===== ERROR =====");
        System.out.println("Message: " + ex.getMessage());
        System.out.println("Time: " + java.time.LocalDateTime.now());
    }

    @Before("execution(* com.example.ss9.controller.*.*(..))")
    public void countVisitor(JoinPoint joinPoint) {
        int current = counter.incrementAndGet();

        System.out.println("===== VISITOR =====");
        System.out.println("Total visits: " + current);
        System.out.println("Accessed: " + joinPoint.getSignature().toShortString());
    }
}
