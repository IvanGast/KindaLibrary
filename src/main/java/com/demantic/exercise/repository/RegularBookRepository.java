package com.demantic.exercise.repository;

import com.demantic.exercise.entity.Book;
import com.demantic.exercise.entity.RegularBook;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularBookRepository extends CrudRepository<Book, String> {

  @Query(value = "SELECT * FROM books b WHERE b.barcode = ?1", nativeQuery = true)
  Optional<RegularBook> findByBarcode(String barcode);

  @Modifying
  @Query(value = "INSERT INTO books (name, author, barcode, quantity, price, type) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  void addBook(String name, String author, String barcode, int quantity, double price, String type);

  @Modifying
  @Query(value = "UPDATE books SET name = ?1, author = ?2, quantity = ?4, price = ?5 WHERE barcode = ?3", nativeQuery = true)
  void updateBook(String name, String author, String barcode, int quantity, double price);

  @Query(value = "SELECT * FROM books GROUP BY quantity, id", nativeQuery = true)
  List<RegularBook> groupByQuantity();
}
