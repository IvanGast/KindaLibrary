package com.demantic.exercise.repository;

import com.demantic.exercise.entity.ScienceJournal;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScienceJournalRepository extends CrudRepository<ScienceJournal, String> {

  @Query(value = "SELECT * FROM books b WHERE b.barcode = ?1", nativeQuery = true)
  Optional<ScienceJournal> findByBarcode(String barcode);

  @Query(value = "SELECT * FROM books b WHERE b.barcode = ?1", nativeQuery = true)
  ScienceJournal getByBarcode(String barcode);

  @Modifying
  @Query(value = "INSERT INTO books (name, author, barcode, quantity, price, science_index, type) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
  void addBook(String name, String author, String barcode, int quantity, double price,
      int scienceIndex, String type);

  @Modifying
  @Query(value = "UPDATE books SET name = ?1, author = ?2, quantity = ?4, price = ?5, science_index = ?6 WHERE barcode = ?3", nativeQuery = true)
  void updateBook(String name, String author, String barcode, int quantity, double price,
      int scienceIndex);
}
