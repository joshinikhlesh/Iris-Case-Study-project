-- card databse scripts -- 
create database cards;
use cards;

CREATE TABLE cards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    card_number VARCHAR(16) NOT NULL,
    card_holder_name VARCHAR(100) NOT NULL,
    card_type VARCHAR(50) NOT NULL,
    expiration_month INT NOT NULL CHECK (expiration_month BETWEEN 1 AND 12),
    expiration_year INT NOT NULL CHECK (expiration_year >= 2023),
    cvv VARCHAR(3) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO cards (
    user_id,
    card_number,
    card_holder_name,
    card_type,
    expiration_month,
    expiration_year,
    cvv
) VALUES (
    101,                      -- Example user ID
    '4111111111111111',       -- Example card number
    'John Doe',               -- Example cardholder name
    'VISA',                   -- Example card type
    12,                       -- Expiration month (December)
    2025,                     -- Expiration year
    '123'                     -- CVV
);
CREATE TABLE cards_seq (
    next_val BIGINT NOT NULL
);
INSERT INTO cards_seq (next_val) VALUES (1);