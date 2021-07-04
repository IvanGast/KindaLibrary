package com.demantic.exercise.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidDataException extends RuntimeException {
  private String message;
}
