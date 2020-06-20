package com.scut.blockchain.aspect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ResponseAspect {

    @Data
    public static class GeneralResponse {
        private Integer errno = 0;
        private String errmsg = "Success";
        private Object data;
    }

    public Object createStandardResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        GeneralResponse response = new GeneralResponse();
        Object result = joinPoint.proceed();
        response.setData(result);
        return response;
    }

    @Around("execution(* com.scut.blockchain.controller.BankController.getAllCompanies()) ||" +
            "execution(* com.scut.blockchain.controller.CompanyController.getAllGifts()) ||" +
            "execution(* com.scut.blockchain.controller.CompanyController.getAllGoods()) ||" +
            "execution(* com.scut.blockchain.controller.CompanyController.posGift()) ||" +
            "execution(* com.scut.blockchain.controller.CompanyController.posGoods()) ||" +
            "execution(* com.scut.blockchain.controller.UserController.getAllCompanyInfo())")
    public Object amplifyReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        return createStandardResponse(joinPoint);
    }

    private void printStackTraceToLog(Exception e) {
        String exceptionType = e.toString();
        StackTraceElement[] stackTrace = e.getStackTrace();

        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuilder.append(stackTraceElement.toString()).append("\n");
        }
        log.error("Exception: {}, {}", exceptionType, stringBuilder.toString());
    }
}
