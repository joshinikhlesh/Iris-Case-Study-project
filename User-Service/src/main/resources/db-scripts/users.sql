-- user data base script and other mysql commands --

create database users;
CREATE TABLE users (
    user_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone_number VARCHAR(20),
    address TEXT,
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50),
    postal_code VARCHAR(20),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO users (
    username,
    email,
    password_hash,
    first_name,
    last_name,
    phone_number,
    address,
    city,
    state,
    country,
    postal_code,
    is_active
) VALUES (
    'john_doe',
    'john.doe@example.com',
    '$2a$10$EixZaYVK1fsbw1Zfbx3OXePaWxn96p36K6Q7L9WjGp3eVhE0uXG6K', -- Example hashed password
    'John',
    'Doe',
    '+1234567890',
    '1234 Elm Street',
    'Springfield',
    'IL',
    'USA',
    '62704',
    TRUE
);