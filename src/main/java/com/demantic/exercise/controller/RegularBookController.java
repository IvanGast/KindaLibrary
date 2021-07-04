package com.demantic.exercise.controller;

import com.demantic.exercise.LibraryApplication;
import com.demantic.exercise.entity.RegularBook;
import com.demantic.exercise.service.RegularBookService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = LibraryApplication.PATH)
public class RegularBookController {

  private RegularBookService regularBookService;

  public RegularBookController(RegularBookService regularBookService) {
    this.regularBookService = regularBookService;
  }

  @PostMapping("/regular/add")
  public void addBook(@RequestBody RegularBook book) {
    regularBookService.addBook(book);
  }

  @GetMapping("/regular/get")
  public String getBook() {
    return "";
  }

  @PutMapping("/regular/update")
  public void updateBook(@RequestBody @Valid RegularBook book) {
    regularBookService.updateBook(book);
  }
}
