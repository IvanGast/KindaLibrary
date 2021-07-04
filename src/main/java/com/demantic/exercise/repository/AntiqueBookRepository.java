package com.demantic.exercise.repository;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.AntiqueBook;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntiqueBookRepository extends CrudRepository<AntiqueBook, String> {
  @Query(value = "SELECT * FROM antique_books b WHERE b.barcode = ?1", nativeQuery = true)
  Optional<AntiqueBook> findByBarcode(String barcode);

  @Query(value = "INSERT INTO antique_books (name, author, barcode, quantity, price, release_year) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  void addBook(String name, String author, String barcode, int quantity, double price, int releaseYear);

  @Query(value = "UPDATE antique_books SET name = ?1, author = ?2, quantity = ?4, price = ?5, release_year = ?6 WHERE barcode = ?3", nativeQuery = true)
  void updateBook(String name, String author, String barcode, int quantity, double price, int releaseYear);

  @Query(value = "SELECT * FROM antique_books GROUP BY quantity, id", nativeQuery = true)
  List<AntiqueBook> sortByQuantity();
}
