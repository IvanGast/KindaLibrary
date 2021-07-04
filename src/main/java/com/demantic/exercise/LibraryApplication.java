package com.demantic.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
  public static final String PATH = "api";

  public static void main(String[] args) {
    SpringApplication.run(LibraryApplication.class, args);
  }
}
