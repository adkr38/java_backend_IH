package com.ironhack.app.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import com.ironhack.app.enums.*;


@Entity
@Table(name = "products")
public class Product{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @NotNull
  protected String name;

  @NotNull
  protected BigDecimal price;

  @Enumerated(EnumType.STRING)
  @NotNull
  protected Category category;

  @Enumerated(EnumType.STRING)
  @NotNull
  protected Department department;

  public Product(String name, BigDecimal price, Category category, Department department){
    setName(name);
    setPrice(price);
    setCategory(category);
    setDepartment(department);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public boolean equals(Object o){
    if (!(o instanceof Product)){
      return false;
    }

    Product instanciatedObject = (Product) o;

    return instanciatedObject.getId() == this.getId();
  }

  Product(){};

}
