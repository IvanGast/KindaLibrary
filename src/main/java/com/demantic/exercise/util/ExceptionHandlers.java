package com.demantic.exercise.util;

import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.exception.ServerError;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlers {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(value = InvalidDataException.class)
  @ResponseBody
  public ServerError handleInvalidDataException(
      HttpServletResponse response,
      InvalidDataException ex
  ) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

    String header = "Request failed";
    List<String> items = new ArrayList<>();
    items.add(ex.getMessage());

    return new ServerError(header, items);
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseBody
  public ServerError handleIllegalArgumentException(HttpServletResponse response,
      IllegalArgumentException ex) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    String header = ex.getMessage();
    return new ServerError(header, new ArrayList<>());
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ServerError handleGeneralException(HttpServletResponse response, Exception ex) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    String header = messageSource.getMessage("serverError", null, Locale.getDefault());
    return new ServerError(header, new ArrayList<>());
  }
}
