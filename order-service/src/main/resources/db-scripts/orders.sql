create database orders;
CREATE TABLE Orders (
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT, 
    user_id BIGINT NOT NULL, 
    status VARCHAR(50) NOT NULL, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    note VARCHAR(150) NOT NULL, 
    total_amount DOUBLE NOT NULL, 
    tracking_id VARCHAR(255) NOT NULL,
    payment_method VARCHAR(255), 
    payment_status VARCHAR(50) NOT NULL,
    is_Email_Notification_Send BOOLEAN NOT NULL, 
    is_Phone_Notification_Send BOOLEAN NOT NULL 
);
ALTER TABLE orders ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE orders ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
CREATE TABLE order_products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, -- Unique identifier for each entry
    order_id BIGINT NOT NULL, -- Foreign key referencing Orders table
    product_id BIGINT NOT NULL, -- ID of the product
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE -- Maintain referential integrity
);