```mysql
CREATE TABLE user(
id VARCHAR(50) PRIMARY KEY,
name VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(100) NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP NOT NULL,
is_deleted BOOLEAN DEFAULT FALSE
);
```