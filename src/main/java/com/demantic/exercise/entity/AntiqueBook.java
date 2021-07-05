package com.demantic.exercise.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "books")
public class AntiqueBook extends Book {
  @Column(name = "release_year")
  private int releaseYear;

  @Override
  public double getTotalPrice() {
    return quantity * price * ( LocalDate.now().getYear() - releaseYear) / 10;
  }
}
