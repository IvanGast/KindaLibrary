package com.demantic.exercise.repository;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.ScienceJournal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScienceJournalRepository extends CrudRepository<ScienceJournal, String> {
  @Query(value = "SELECT * FROM science_books b WHERE b.barcode = ?1", nativeQuery = true)
  Optional<ScienceJournal> findByBarcode(String barcode);

  @Query(value = "INSERT INTO science_books (name, author, barcode, quantity, price, science_index) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  void addBook(String name, String author, String barcode, int quantity, double price, int scienceIndex);

  @Query(value = "UPDATE science_books SET name = ?1, author = ?2, quantity = ?4, price = ?5, science_index = ?6 WHERE barcode = ?3", nativeQuery = true)
  void updateBook(String name, String author, String barcode, int quantity, double price, int scienceIndex);

  @Query(value = "SELECT * FROM science_books GROUP BY quantity, id", nativeQuery = true)
  List<ScienceJournal> sortByQuantity();
}
