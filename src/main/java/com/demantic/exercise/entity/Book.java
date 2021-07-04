package com.demantic.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Book {
  protected String name;
  protected String author;
  protected String barcode;
  protected int quantity;
  protected double price;

  public double getTotalPrice() {
    return quantity * price;
  }
}
