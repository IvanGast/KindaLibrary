package com.demantic.exercise.service;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.Book;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.AntiqueBookRepository;
import com.demantic.exercise.repository.RegularBookRepository;
import com.demantic.exercise.repository.ScienceJournalRepository;
import com.demantic.exercise.util.Consts;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  RegularBookRepository regularBookRepository;
  AntiqueBookRepository antiqueBookRepository;
  ScienceJournalRepository scienceJournalRepository;

  BookService(RegularBookRepository regularBookRepository,
      AntiqueBookRepository antiqueBookRepository,
      ScienceJournalRepository scienceJournalRepository) {
    this.regularBookRepository = regularBookRepository;
    this.antiqueBookRepository = antiqueBookRepository;
    this.scienceJournalRepository = scienceJournalRepository;
  }

  public String getPrice(String barcode) {
    var regularBook = regularBookRepository.findByBarcode(barcode)
        .orElseThrow(() -> new InvalidDataException("NO BOOK WAS FOUND"));
    switch (regularBook.getType()) {
      case ANTIQUE:
        return "TOTAL PRICE : " + antiqueBookRepository.getByBarcode(barcode).getTotalPrice();
      case SCIENCE:
        return "TOTAL PRICE : " + scienceJournalRepository.getByBarcode(barcode).getTotalPrice();
      default:
        return "TOTAL PRICE : " + regularBook.getTotalPrice();
    }
  }

  public List<SortByQuantityDTO> groupByQuantity() {
    return regularBookRepository.groupByQuantity()
        .stream()
        .map(Book::toSortByQuantityDTO)
        .collect(Collectors.toList());
  }

  @SuppressWarnings("unchecked")
  public <T extends Book> T findBookByBarcode(String barcode) {
    var regularBook = regularBookRepository.findByBarcode(barcode)
        .orElseThrow(() -> new InvalidDataException(
            Consts.NOT_EXIST_ERROR));
    switch (regularBook.getType()) {
      case ANTIQUE:
        return (T) antiqueBookRepository.getByBarcode(barcode);
      case SCIENCE:
        return (T) scienceJournalRepository.getByBarcode(barcode);
      default:
        return (T) regularBook;
    }
  }
}
