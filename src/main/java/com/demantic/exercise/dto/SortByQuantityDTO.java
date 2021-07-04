package com.demantic.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortByQuantityDTO {
  private int quantity;
  private String barcode;
}
