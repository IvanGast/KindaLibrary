package com.demantic.exercise.controller;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.Book;
import com.demantic.exercise.service.BookService;
import com.demantic.exercise.util.Consts;
import java.util.List;
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

  @GetMapping("/find/{barcode}")
  public <T extends Book> T findBookByBarcode(@PathVariable(value = "barcode") String barcode) {
    return bookService.findBookByBarcode(barcode);
  }

  @GetMapping("/groupByQuantity")
  public List<SortByQuantityDTO> groupByQuantity() {
    return bookService.groupByQuantity();
  }
}
