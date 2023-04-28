package com.ironhack.app.models;
import jakarta.persistence.*;
import java.math.BigDecimal;
import com.ironhack.app.enums.*;


@Entity
@Table(name = "products")
class Product{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  protected String name;
  protected BigDecimal price;

  @Enumerated(EnumType.STRING)
  protected Category category;

  @Enumerated(EnumType.STRING)
  protected Department department;

  public int getId() {
    return id;
  }

  // public void setId(int id) {
  //   this.id = id;
  // }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

}
