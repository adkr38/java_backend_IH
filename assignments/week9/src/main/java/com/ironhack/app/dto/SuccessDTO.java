package com.ironhack.app.dto;
import java.util.List;
import java.time.Instant;

public class SuccessDTO<T> implements ResponseDTO{
  protected String message;
  protected int statusCode;
  protected long timestamp;
  protected List<T> responseContent;

  public SuccessDTO(String message,int statusCode,List<T> responseContent){
    setMessage(message);
    setStatusCode(statusCode);
    setTimestamp();
    setResponseContent(responseContent);
  }

    public List<T> getResponseContent() {
    return responseContent;
  }

  public void setResponseContent(List<T> responseContent) {
    this.responseContent = responseContent;
  }

public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp() {
    this.timestamp = Instant.now().toEpochMilli();
  }

}
