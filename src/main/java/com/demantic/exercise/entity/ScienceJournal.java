package com.demantic.exercise.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ScienceJournal extends Book {
  private int scienceIndex;

  @Override
  public double getTotalPrice() {
    return quantity * price * scienceIndex;
  }
}
