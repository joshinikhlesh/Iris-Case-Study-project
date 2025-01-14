-- product database table scripts
select * from Product;
create database products;

drop table product;
CREATE TABLE Product (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT , 
    name VARCHAR(255) NOT NULL,                    
    description VARCHAR(100),                      
    price DECIMAL(10, 2),                          
    category VARCHAR(255),                        
    quantity BIGINT                                
);

INSERT INTO Product (product_id,name, description, price, category, quantity)
VALUES 
(1,'Wireless Mouse', 'Ergonomic wireless mouse with adjustable DPI', 25.99, 'Electronics', 100),
(2, 'Gaming Keyboard', 'RGB mechanical keyboard with blue switches', 79.99, 'Electronics', 50),
(3, 'Bluetooth Speaker', 'Portable Bluetooth speaker with 10 hours battery', 45.50, 'Audio', 200),
(105, 'Laptop Stand', 'Adjustable aluminum laptop stand for desks', 29.99, 'Accessories', 150),
(406, 'USB-C Cable', '1-meter USB-C cable for fast charging and data transfer', 9.99, 'Accessories', 300);