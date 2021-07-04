package com.demantic.exercise.service;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.Book;
import com.demantic.exercise.entity.RegularBook;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.RegularBookRepository;
import com.demantic.exercise.util.Consts;
import java.util.List;
import java.util.stream.Collectors;
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
    if (regularBookRepository.findByBarcode(book.getBarcode()).isEmpty())
      regularBookRepository.addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice());
    else
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
  }

  @Transactional
  public void updateBook(RegularBook book) {
    regularBookRepository.findByBarcode(book.getBarcode()).orElseThrow(() -> new InvalidDataException(Consts.UPDATE_BOOK_ERROR));
    regularBookRepository.updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice());
  }

  public List<SortByQuantityDTO> sortByQuantity() {
    return regularBookRepository.sortByQuantity()
                                .stream()
                                .map(Book::toSortByQuantityDTO)
                                .collect(Collectors.toList());
  }
}
