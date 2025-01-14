create database payment_db;

use  payment_db;
 drop table payments;
CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    payment_id BIGINT,
    order_id BIGINT NOT NULL,             
    user_id BIGINT NOT NULL,              
    amount DECIMAL(10, 2) NOT NULL,     
    payment_status VARCHAR(50) NOT NULL, 
    payment_method VARCHAR(50) NOT NULL,
    payment_gateway VARCHAR(100) NOT NULL, 
    transaction_id VARCHAR(100) NOT NULL, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP 
);