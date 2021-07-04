package com.demantic.exercise.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntiqueBook extends Book {
  private int releaseYear;

  @Override
  public double getTotalPrice() {
    return quantity * price * ( LocalDate.now().getYear() - releaseYear) / 10;
  }
}
