package com.ironhack.app.dtos;
import java.util.List;

public class SuccessDTO<T>  implements ResponseDTO{

  protected int statusCode;
  protected String message;
  protected  List<T> content;

  public SuccessDTO(int statusCode, String message, List<T> content){
    setStatusCode(statusCode);
    setMessage(message);
    setContent(content);
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }



}
