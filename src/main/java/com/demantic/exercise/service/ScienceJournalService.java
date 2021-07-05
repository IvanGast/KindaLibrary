package com.demantic.exercise.service;

import com.demantic.exercise.entity.ScienceJournal;
import com.demantic.exercise.exception.InvalidDataException;
import com.demantic.exercise.repository.ScienceJournalRepository;
import com.demantic.exercise.util.BookType;
import com.demantic.exercise.util.Consts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScienceJournalService {

  private ScienceJournalRepository scienceJournalRepository;

  public ScienceJournalService(ScienceJournalRepository scienceJournalRepository) {
    this.scienceJournalRepository = scienceJournalRepository;
  }

  @Transactional
  public void addBook(ScienceJournal book) {
    if (scienceJournalRepository.findByBarcode(book.getBarcode()).isEmpty()) {
      scienceJournalRepository
          .addBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
              book.getPrice(), book.getScienceIndex(),
              BookType.SCIENCE.toString());
    } else {
      throw new InvalidDataException(Consts.ADD_BOOK_ERROR);
    }
  }

  @Transactional
  public void updateBook(ScienceJournal book) {
    scienceJournalRepository.findByBarcode(book.getBarcode())
        .orElseThrow(() -> new InvalidDataException(Consts.NOT_EXIST_ERROR));
    scienceJournalRepository
        .updateBook(book.getName(), book.getAuthor(), book.getBarcode(), book.getQuantity(),
            book.getPrice(), book.getScienceIndex());
  }
}
