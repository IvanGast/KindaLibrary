DROP TABLE IF EXISTS regular_books;
DROP TABLE IF EXISTS antique_books;
DROP TABLE IF EXISTS science_books;

CREATE TABLE regular_books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  barcode VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  price DECIMAL NOT NULL
);

CREATE TABLE antique_books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  barcode VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  price DECIMAL NOT NULL,
  release_year INT NOT NULL
);

CREATE TABLE science_books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  barcode VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  price DECIMAL NOT NULL,
  science_index INT NOT NULL
);