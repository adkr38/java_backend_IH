package com.ironhack.app.models;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name="event")
@AttributeOverride(name="name",column = @Column(name="guest_name"))
@AttributeOverride(name="status",column = @Column(name="status"))
public abstract class Event{
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  protected LocalDate date;
  protected float duration;
  protected String title;

  @Embedded
  @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
  protected List<Guest> list;

  Event(LocalDate date, float duration, String title, List<Guest> list){
    setDate(date);
    setDuration(duration);
    setTitle(title);
    setList(list);
  }

  public int getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }


  public void setDate(LocalDate date) {
    this.date = date;
  }


  public float getDuration() {
    return duration;
  }


  public void setDuration(float duration) {
    this.duration = duration;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public List<Guest> getList() {
    return list;
  }


  public void setList(List<Guest> list) {
    this.list = list;
  }

}
