package com.ironhack.app.dto;
import java.time.Instant;
import java.util.List;

public class ErrorDTO implements ResponseDTO{
  protected int statusCode;
  protected String message;
  protected long timestamp;
  protected List<Object> responseContent;

  public ErrorDTO(int statusCode, String message){
    setStatusCode(statusCode);
    setMessage(message);
    setTimestamp();
    setResponseContent();
  }

  public void setResponseContent(){
    this.responseContent = List.of();
  }

  public List<Object> getResponseContent(){
    return responseContent;
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

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp() {
    this.timestamp = Instant.now().toEpochMilli();
  }


}
