package com.demantic.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "science_books")
public class ScienceJournal extends Book {
  private int scienceIndex;

  @Override
  public double getTotalPrice() {
    return quantity * price * scienceIndex;
  }
}
