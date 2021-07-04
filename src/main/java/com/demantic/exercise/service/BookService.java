package com.demantic.exercise.service;

import com.demantic.exercise.repository.AntiqueBookRepository;
import com.demantic.exercise.repository.RegularBookRepository;
import com.demantic.exercise.repository.ScienceJournalRepository;
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
    var regularBook = regularBookRepository.findByBarcode(barcode);
    if (regularBook.isPresent())
        return "TOTAL PRICE : " + regularBook.get().getTotalPrice();
    var antiqueBook = antiqueBookRepository.findByBarcode(barcode);
    if (antiqueBook.isPresent())
      return "TOTAL PRICE : " + antiqueBook.get().getTotalPrice();
    var scienceJournal = scienceJournalRepository.findByBarcode(barcode);
    return scienceJournal.map(journal -> "TOTAL PRICE : " + journal.getTotalPrice())
        .orElse("NO BOOK WAS FOUND");
  }
}
