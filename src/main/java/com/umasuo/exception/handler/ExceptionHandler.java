package com.umasuo.exception.handler;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.umasuo.exception.AlreadyExistException;
import com.umasuo.exception.AuthFailedException;
import com.umasuo.exception.AuthInfoMissingException;
import com.umasuo.exception.ConflictException;
import com.umasuo.exception.CreateResourceFailed;
import com.umasuo.exception.ImmutableException;
import com.umasuo.exception.NotExistException;
import com.umasuo.exception.ParametersException;
import com.umasuo.exception.PasswordErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exception handler interface.
 */
public interface ExceptionHandler {

  /**
   * logger.
   */
  Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  /**
   * exception EXCEPTION_MAP.
   */
  ImmutableMap EXCEPTION_MAP = ImmutableMap.builder()
      .put(AlreadyExistException.class, HttpStatus.CONFLICT)
      .put(AuthFailedException.class, HttpStatus.UNAUTHORIZED)
      .put(AuthInfoMissingException.class, HttpStatus.BAD_REQUEST)
      .put(ConflictException.class, HttpStatus.CONFLICT)
      .put(CreateResourceFailed.class, HttpStatus.INTERNAL_SERVER_ERROR)
      .put(ImmutableException.class, HttpStatus.FORBIDDEN)
      .put(NotExistException.class, HttpStatus.NOT_FOUND)
      .put(ParametersException.class, HttpStatus.BAD_REQUEST)
      .put(PasswordErrorException.class, HttpStatus.UNAUTHORIZED).build();

  /**
   * exception that do not log.
   */
  List<Class<?>> OMITTED_EXCEPTIONS = ImmutableList.of(
      AlreadyExistException.class,
      AuthFailedException.class,
      AuthInfoMissingException.class,
      ConflictException.class,
      CreateResourceFailed.class,
      ImmutableException.class,
      NotExistException.class,
      ParametersException.class,
      PasswordErrorException.class
  );


  /**
   * set the error info that need to send back to the client.
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param obj      Object
   * @param ex       Exception
   * @return the input exception
   */
  default Exception setResponse(HttpServletRequest request, HttpServletResponse response,
                                Object obj,
                                Exception ex) {
    // get the status
    HttpStatus status = (HttpStatus) EXCEPTION_MAP.get(ex.getClass());
    if (status == null) {
      //if this is an unexpected exception, set the code to internal server error.
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    logException(request, response, obj, status, ex);

    response.setStatus(status.value());
    response.setHeader("ErrorMessage", ex.getMessage());
    response.setContentType(MediaType.APPLICATION_JSON.getType());
    return ex;
  }

  /**
   * log the detail of the exception.
   * only log these exceptions that does not excepted.
   *
   * @param ex exception
   */
  default void logException(HttpServletRequest request, HttpServletResponse response,
                            Object obj, HttpStatus status, Exception ex) {
    boolean shouldLog = !OMITTED_EXCEPTIONS.contains(ex.getClass());
    if (shouldLog) {
      // only log those ones that are real failures
      LOGGER.error("request {}, response {}, obj {}, status {}", request, response, obj, status,
          ex);
    }
  }
}
