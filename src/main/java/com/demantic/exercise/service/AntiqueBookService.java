package com.demantic.exercise.service;

import com.demantic.exercise.entity.AntiqueBook;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.AntiqueBookRepository;
import com.demantic.exercise.util.BookType;
import com.demantic.exercise.util.Consts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AntiqueBookService {

  private AntiqueBookRepository antiqueBookRepository;

  public AntiqueBookService(AntiqueBookRepository antiqueBookRepository) {
    this.antiqueBookRepository = antiqueBookRepository;
  }

  @Transactional
  public void addBook(AntiqueBook book) {
    if (antiqueBookRepository.findByBarcode(book.getBarcode()).isEmpty()) {
      antiqueBookRepository
          .addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
              book.getPrice(), book.getReleaseYear(),
              BookType.ANTIQUE.toString());
    } else {
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
    }
  }

  @Transactional
  public void updateBook(AntiqueBook book) {
    antiqueBookRepository.findByBarcode(book.getBarcode())
        .orElseThrow(() -> new InvalidDataException(Consts.NOT_EXIST_ERROR));
    antiqueBookRepository
        .updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
            book.getPrice(), book.getReleaseYear());
  }
}
