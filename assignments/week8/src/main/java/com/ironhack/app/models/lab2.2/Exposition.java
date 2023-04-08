package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="exposition")
@AttributeOverride(name="name",column = @Column(name="guest_name"))
@AttributeOverride(name="status",column = @Column(name="status"))
public class Exposition extends Event{
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;


  public Exposition(LocalDate date, float duration, String title, List<Guest> list){
    super(date, duration, title, list);
  }

}



