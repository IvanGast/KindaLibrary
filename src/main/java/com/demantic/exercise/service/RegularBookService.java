package com.demantic.exercise.service;

import com.demantic.exercise.entity.RegularBook;
import org.springframework.stereotype.Service;

@Service
public class RegularBookService {

  public void addBook(RegularBook book) {
    System.out.println(book.getTotalPrice());
  }

  public void updateBook(RegularBook book) {

  }


}
