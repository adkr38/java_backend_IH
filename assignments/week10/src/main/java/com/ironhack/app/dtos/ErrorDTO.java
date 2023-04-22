package com.ironhack.app.dtos;
import java.time.Instant;
import java.util.List;

public class ErrorDTO implements ResponseDTO{

  protected int statusCode;
  protected String message;
  protected List<Object> content;
  protected long timestamp;

  public ErrorDTO(int statusCode, String message){
    setStatusCode(statusCode);
    setMessage(message);
    setContent();
    setTimestamp();

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

public List<Object> getContent() {
	return content;
}

public void setContent() {

	this.content = List.of();
}

public long getTimestamp() {
	return timestamp;
}

public void setTimestamp() {
	this.timestamp = Instant.now().toEpochMilli();
}




}
