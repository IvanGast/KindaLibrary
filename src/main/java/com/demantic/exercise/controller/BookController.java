package com.demantic.exercise.controller;

import com.demantic.exercise.LibraryApplication;
import com.demantic.exercise.service.BookService;
import com.demantic.exercise.util.Consts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Consts.API_PATH)
public class BookController {
  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/price/{barcode}")
  public String getPrice(@PathVariable(value = "barcode") String barcode) {
    return bookService.getPrice(barcode);
  }
}
