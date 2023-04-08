package com.ironhack.app.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@AttributeOverride(name="name",column = @Column(name="name"))
@AttributeOverride(name="status",column = @Column(name="status"))
@AttributeOverride(name="renewalDate",column = @Column(name="renewal_date"))
public class Division{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  protected int id;

  protected String name;
  protected String district;

  @Embedded
  protected Member president;
  @Embedded
  protected List<Member> list;


  public Division(String name, String district, Member president, List<Member> list){
    setName(name);
    setDistrict(district);
    setPresident(president);
    setList(list);

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

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Member getPresident() {
    return president;
  }

  public void setPresident(Member president) {
    this.president = president;
  }

  public List<Member> getList() {
    return list;
  }

  public void setList(List<Member> list) {
    this.list = list;
  }

  public Division(){}

}
