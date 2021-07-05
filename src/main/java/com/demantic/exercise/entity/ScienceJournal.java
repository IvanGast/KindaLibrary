package com.demantic.exercise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "books")
public class ScienceJournal extends Book {

  @Min(1)
  @Max(10)
  @Column(name = "science_index")
  private int scienceIndex;

  @Override
  public double getTotalPrice() {
    return quantity * price * scienceIndex;
  }
}
