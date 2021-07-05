package com.demantic.exercise.exception;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServerError {
  private String header;
  private List<String> items;
}
