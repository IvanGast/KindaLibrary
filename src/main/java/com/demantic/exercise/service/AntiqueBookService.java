package com.demantic.exercise.service;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.AntiqueBook;
import com.demantic.exercise.entity.Book;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.AntiqueBookRepository;
import com.demantic.exercise.util.Consts;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AntiqueBookService {
  private AntiqueBookRepository antiqueBookRepository;

  public AntiqueBookService(AntiqueBookRepository antiqueBookRepository) {
    this.antiqueBookRepository = antiqueBookRepository;
  }

  public void addBook(AntiqueBook book) {
    if (antiqueBookRepository.findByBarcode(book.getBarcode()).isEmpty())
      antiqueBookRepository.addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice(), book.getReleaseYear());
    else
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
  }

  public void updateBook(AntiqueBook book) {
    antiqueBookRepository.findByBarcode(book.getBarcode()).orElseThrow(() -> new InvalidDataException(Consts.UPDATE_BOOK_ERROR));
    antiqueBookRepository.updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice(), book.getReleaseYear());
  }

  public List<SortByQuantityDTO> sortByQuantity() {
    return antiqueBookRepository.sortByQuantity()
                                .stream()
                                .map(Book::toSortByQuantityDTO)
                                .collect(Collectors.toList());
  }
}
