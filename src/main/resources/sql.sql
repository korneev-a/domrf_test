CREATE TABLE orders(
                       order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       customer_name VARCHAR(30),
                       customer_phone VARCHAR(15),
                       customer_email VARCHAR(100),
                       customer_address VARCHAR(255)

);

INSERT INTO orders (customer_name, customer_phone, customer_email, customer_address)
VALUES ('Kensyn', '+7800200600', 'asdad@mail', 'Moscow');
VALUES ('Alex', '+78553535', 'lex@mail', 'Petersburg');
VALUES ('Malaya', '+787654321', 'maly@mail', 'Kazan');