package com.demantic.exercise.service;

import com.demantic.exercise.entity.RegularBook;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.RegularBookRepository;
import com.demantic.exercise.util.BookType;
import com.demantic.exercise.util.Consts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegularBookService {

  private RegularBookRepository regularBookRepository;

  public RegularBookService(RegularBookRepository regularBookRepository) {
    this.regularBookRepository = regularBookRepository;
  }

  @Transactional
  public void addBook(RegularBook book) {
    if (regularBookRepository.findByBarcode(book.getBarcode()).isEmpty()) {
      regularBookRepository
          .addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
              book.getPrice(),
              BookType.REGULAR.toString());
    } else {
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
    }
  }

  @Transactional
  public void updateBook(RegularBook book) {
    regularBookRepository.findByBarcode(book.getBarcode())
        .orElseThrow(() -> new InvalidDataException(Consts.NOT_EXIST_ERROR));
    regularBookRepository
        .updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
            book.getPrice());
  }
}
