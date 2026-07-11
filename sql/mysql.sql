CREATE DATABASE ecommerce;

USE ecommerce;

CREATE TABLE product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    price DOUBLE,
    quantity INT
);