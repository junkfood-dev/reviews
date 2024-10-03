```mysql
CREATE TABLE customer(
                         customer_id INT PRIMARY KEY AUTO_INCREMENT,
                         name        VARCHAR(50) NOT NULL,
                         address     VARCHAR(100) NOT NULL,
                         password    VARCHAR(20) NOT NULL,
                         created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         deleted_at  TIMESTAMP NULL,
                         is_deleted  BOOLEAN DEFAULT false
);

CREATE TABLE account(
                        account_id  INT PRIMARY KEY AUTO_INCREMENT,
                        customer_id INT NOT NULL,
                        balance     DECIMAL(15, 2) DEFAULT 0,
                        FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE TABLE transaction(
                            transaction_id   INT PRIMARY KEY AUTO_INCREMENT,
                            account_id       INT NOT NULL,
                            transaction_type ENUM('DEPOSIT', 'WITHDRAW', 'TRANSFER'),
                            amount           DECIMAL(15, 2) DEFAULT 0 CHECK (amount > 0),
                            date             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (account_id) REFERENCES account (account_id)
);
```
