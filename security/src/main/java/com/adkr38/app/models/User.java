package com.adkr38.app.models;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class User{
  
  @GeneratedValue
  @Id
  private long id;

  private String name;
  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Role> roles = new ArrayList<Role>();

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
  List<Task> tasks;

  public User(String name, String username, String password){
    setName(name);
    setUsername(username);
    setPassword(password);
    setRoles(roles);
    setTasks(tasks);
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

public List<Role> getRoles() {
	return roles;
}


public void setRoles(List<Role> roles) {
	this.roles = roles;
}


public List<Task> getTasks() {
	return tasks;
}


public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
};


  public User(){}




}
