package com.demantic.exercise.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "antique_books")
public class AntiqueBook extends Book {
  @Id
  @GeneratedValue
  private Long id;
  private int releaseYear;

  @Override
  public double getTotalPrice() {
    return quantity * price * ( LocalDate.now().getYear() - releaseYear) / 10;
  }
}
