package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Task{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  private String title;
  private LocalDate dueDate;
  private boolean status;

  public Task(String title, LocalDate dueDate, boolean status){
    setTitle(title);
    setDueDate(dueDate);
    setStatus(status);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  Task(){};


}
