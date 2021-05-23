DROP TABLE IF EXISTS products;
CREATE TABLE products(id serial PRIMARY KEY, name VARCHAR(255), description VARCHAR(255), price INTEGER, quantity INTEGER);
DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START 1;
DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions(id INT, productID INT,date VARCHAR(255), price INTEGER, quantity INTEGER);