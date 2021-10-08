package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * lets say we created a business exception. we can directly annotate the exception that we created
 * using Spring web annotations.
 * 
 * the annotation we can use directly above is called @ResponseStatus
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Sorry. We can't complete your request.")
public class BusinessException extends Exception{
}
