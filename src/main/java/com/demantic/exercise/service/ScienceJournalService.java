package com.demantic.exercise.service;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.Book;
import com.demantic.exercise.entity.ScienceJournal;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.ScienceJournalRepository;
import com.demantic.exercise.util.Consts;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ScienceJournalService {

  private ScienceJournalRepository scienceJournalRepository;

  public ScienceJournalService(ScienceJournalRepository scienceJournalRepository) {
    this.scienceJournalRepository = scienceJournalRepository;
  }

  public void addBook(ScienceJournal book) {
    if (scienceJournalRepository.findByBarcode(book.getBarcode()).isEmpty())
      scienceJournalRepository.addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice(), book.getScienceIndex());
    else
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
  }

  public void updateBook(ScienceJournal book) {
    scienceJournalRepository.findByBarcode(book.getBarcode()).orElseThrow(() -> new InvalidDataException(Consts.UPDATE_BOOK_ERROR));
    scienceJournalRepository.updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(), book.getPrice(), book.getScienceIndex());
  }

  public List<SortByQuantityDTO> sortByQuantity() {
    return scienceJournalRepository.sortByQuantity()
                                    .stream()
                                    .map(Book::toSortByQuantityDTO)
                                    .collect(Collectors.toList());
  }
}
