package com.demantic.exercise.controller;

import com.demantic.exercise.entity.RegularBook;
import com.demantic.exercise.service.RegularBookService;
import com.demantic.exercise.util.Consts;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Consts.API_PATH)
public class RegularBookController {

  private RegularBookService regularBookService;

  public RegularBookController(RegularBookService regularBookService) {
    this.regularBookService = regularBookService;
  }

  @PostMapping("/" + Consts.REGULAR_PATH + "/add")
  public void addBook(@RequestBody RegularBook book) {
    regularBookService.addBook(book);
  }

  @PutMapping("/" + Consts.REGULAR_PATH + "/update")
  public void updateBook(@RequestBody RegularBook book) {
    regularBookService.updateBook(book);
  }
}
