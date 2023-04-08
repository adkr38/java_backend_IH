package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class InteralTask extends Task{

  public InteralTask(String title, LocalDate dueDate, boolean status){
    super(title, dueDate, status);
  }

  InteralTask(){};

}
