package com.ewangclarks.quartzsheduler.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({SchedulerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleApiSchedulerException(SchedulerException exp, HttpServletRequest request){
        return ErrorResponse
                .builder()
                .code(ErrorCode.API_INTERNAL_SERVER_ERROR)
                .message(exp.getMessage())
                .endPoint(request.getRequestURI())
                .build();
    }

}
