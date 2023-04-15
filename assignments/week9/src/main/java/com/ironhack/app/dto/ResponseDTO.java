package com.ironhack.app.dto;
import java.util.List;

public interface ResponseDTO{
  void setMessage(String message);
  void setStatusCode(int statusCode);
  void setTimestamp();

  String getMessage();
  int getStatusCode();
  long getTimestamp();
  List<?> getResponseContent();

}
