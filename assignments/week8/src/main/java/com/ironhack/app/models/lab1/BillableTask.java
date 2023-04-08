package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class BillableTask extends Task{
  private double hourlyRate; 

  public BillableTask(String title, LocalDate dueDate, boolean status, double hourlyRate){
    super(title, dueDate, status);
    setHourlyRate(hourlyRate);
  }

  public double getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  BillableTask(){};
}
