package com.adkr38.app.models;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
public class Task{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String task;
  private Date date;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "user_id")
  User user;

  public Task(String task, Date date, User user){
    setTask(task);
    setDate(date);
    setUser(user);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Task(){};



}
