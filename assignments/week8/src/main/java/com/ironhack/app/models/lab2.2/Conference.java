package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="conference")
@AttributeOverride(name="name",column = @Column(name="orator_name"))
@AttributeOverride(name="presentationDuration",column = @Column(name="presentation_duration"))
public class Conference extends Event{
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @Embedded
  @OneToMany(mappedBy = "conference",fetch = FetchType.EAGER)
  protected List<Orator> orators;

  public Conference(LocalDate date, float duration, String title, List<Guest> list){
    super(date, duration, title, list);
  }

  public int getId(){
    return id;
  }

  public void setOrators(List<Orator> orators){
    this.orators = orators;
  }

  public List<Orator> getOrators(){
    return orators;
  }

}



