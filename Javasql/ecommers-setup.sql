-- 1. Wipe out the old database first if it exists
DROP DATABASE IF EXISTS ecommerce_db;

-- 2. Create a brand new, empty database container
CREATE DATABASE ecommerce_db;
USE ecommerce_db;

-- 3. Create the tables
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    sku VARCHAR(50) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE SET NULL
);

-- 4. Insert the data fresh
INSERT INTO categories (category_name, description) VALUES
('Electronics', 'Gadgets, devices, and accessories'),
('Home & Kitchen', 'Appliances, cookware, and home decor'),
('Apparel', 'Clothing, footwear, and accessories');

INSERT INTO products (product_name, category_id, price, stock_quantity, sku) VALUES
('Wireless Noise-Canceling Headphones', 1, 249.99, 45, 'ELEC-HDP-001'),
('Ergonomic Mechanical Keyboard', 1, 129.50, 60, 'ELEC-KEY-002'),
('4K Ultra HD Dash Cam', 1, 89.99, 120, 'ELEC-DSH-003'),
('Portable Power Bank 20000mAh', 1, 35.99, 250, 'ELEC-PWR-004'),
('Smart Fitness Watch v2', 1, 179.00, 85, 'ELEC-WTC-005'),
('Stainless Steel Espresso Machine', 2, 599.00, 15, 'HOME-ESP-006'),
('Digital Air Fryer 5.8Qt', 2, 99.95, 70, 'HOME-AFR-007'),
('Memory Foam Pillow (Queen)', 2, 45.00, 110, 'HOME-PLW-008'),
('Robot Vacuum Cleaner', 2, 219.99, 35, 'HOME-VAC-009'),
('12-Piece Ceramic Cookware Set', 2, 149.00, 25, 'HOME-CWK-010'),
('Water-Resistant Windbreaker', 3, 75.00, 90, 'APPL-WND-011'),
('Classic Leather Chelsea Boots', 3, 120.00, 40, 'APPL-BTS-012'),
('Unisex Cotton Hoodie', 3, 49.99, 180, 'APPL-HDD-013'),
('Polarized Sports Sunglasses', 3, 29.95, 300, 'APPL-SUN-014'),
('Minimalist Canvas Backpack', 3, 65.00, 95, 'APPL-BCK-015');
SELECT * FROM products;