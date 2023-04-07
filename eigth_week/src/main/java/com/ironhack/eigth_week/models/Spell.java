package com.ironhack.eigth_week.models;
import com.ironhack.eigth_week.enums.*;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="spell")
class Spell{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Level level;

  @ManyToMany(mappedBy = "spells")
  private List<Student> students;

  Spell(String name,Level level, List<Student> students){
    setName(name);
    setLevel(level);
    setStudents(students);
  }

  public List<Student> getStudents(){
    return students;

  }
  
  public void setStudents(List<Student> students){
      this.students = students;
    }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

}
