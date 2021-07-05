package com.demantic.exercise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "books")
public class ScienceJournal extends Book {
  @Column(name = "science_index")
  private int scienceIndex;

  @Override
  public double getTotalPrice() {
    return quantity * price * scienceIndex;
  }
}
