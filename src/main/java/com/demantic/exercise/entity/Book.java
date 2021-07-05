package com.demantic.exercise.entity;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.util.BookType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Book {

  @Id
  @GeneratedValue
  private Long id;

  protected String name;
  protected String author;
  protected String barcode;
  protected int quantity;
  protected double price;
  protected BookType type;

  public double getTotalPrice() {
    return quantity * price;
  }

  public SortByQuantityDTO toSortByQuantityDTO() {
    return new SortByQuantityDTO(quantity, barcode);
  }
}
