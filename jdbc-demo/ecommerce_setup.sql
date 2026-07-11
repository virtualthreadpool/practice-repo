CREATE DATABASE ecommerce_db;
USE ecommerce_db;
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT DEFAULT 0
);

INSERT INTO products (product_name, category, price, stock_quantity) VALUES
('One Piece Comic Books', 'Comics', 2499.00, 35),
('Anime Waterproof Stickers (Pack of 50)', 'Stickers', 299.00, 200),
('Crocs', 'Footwear', 3995.00, 60),
('Sony PlayStation(PS6)', 'Gaming', 69999.00, 10),
('Almonds & Cashews', 'Dry Fruits', 899.00, 85),
('JBL Speaker', 'Speaker', 9999.00, 40),
('Bean Bag', 'Furniture', 1799.00, 25),
('Davidoff', 'Perfumes', 5400.00, 18),
('Amla Juice (1L)', 'Health & Wellness', 349.00, 120);

SELECT * FROM products;