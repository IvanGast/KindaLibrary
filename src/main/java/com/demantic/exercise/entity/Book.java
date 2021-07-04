package com.demantic.exercise.entity;

import com.demantic.exercise.dto.SortByQuantityDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Entity
@Table(name = "regular_books")
public abstract class Book {
  @Id
  @GeneratedValue
  private Long id;
  protected String name;
  protected String author;
  protected String barcode;
  protected int quantity;
  protected double price;

  public double getTotalPrice() {
    return quantity * price;
  }

  public SortByQuantityDTO toSortByQuantityDTO() {
    return new SortByQuantityDTO(quantity, barcode);
  }
}
