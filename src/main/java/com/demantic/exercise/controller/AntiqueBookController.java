package com.demantic.exercise.controller;

import com.demantic.exercise.entity.AntiqueBook;
import com.demantic.exercise.service.AntiqueBookService;
import com.demantic.exercise.util.Consts;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Consts.API_PATH)
public class AntiqueBookController {

  private AntiqueBookService antiqueBookService;

  public AntiqueBookController(AntiqueBookService antiqueBookService) {
    this.antiqueBookService = antiqueBookService;
  }

  @PostMapping("/" + Consts.ANTIQUE_PATH + "/add")
  public void addBook(@RequestBody AntiqueBook book) {
    antiqueBookService.addBook(book);
  }

  @PutMapping("/" + Consts.ANTIQUE_PATH + "/update")
  public void updateBook(@RequestBody @Valid AntiqueBook book) {
    antiqueBookService.updateBook(book);
  }
}
