CREATE DATABASE IF NOT EXISTS simple_accounts;

CREATE TABLE account(
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(20) NOT NULL UNIQUE,
  password VARCHAR(64) NOT NULL,
  email VARCHAR(255)
);

INSERT INTO account(username, password, email)
VALUES ("tomnook", "leaftime", "thetomnook@spamcode.com");