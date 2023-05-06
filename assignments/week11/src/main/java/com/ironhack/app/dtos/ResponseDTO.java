package com.ironhack.app.dtos;
import java.util.List;

public interface ResponseDTO{

  public void setStatusCode(int statusCode);
  public void setMessage(String message);

  public int getStatusCode();
  public String getMessage();
}
