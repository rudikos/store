package com.example.store.endpoint;

import com.example.store.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LogManager.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleUmRuntimeException(IllegalArgumentException e) {
		logger.error(e::getMessage);
		return e.getMessage();
	}

	@ExceptionHandler({AccessDeniedException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public String handleAccessDeniedException(AccessDeniedException e) {
		logger.error(e::getMessage);
		return e.getMessage();
	}

	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleUmRuntimeException(Exception e) {
		logger.error(e::getMessage, e);
		return e.getMessage();
	}

	@ExceptionHandler({ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleUmRuntimeException(ResourceNotFoundException e) {
		logger.error(e::getMessage);
		return e.getMessage();
	}
}
