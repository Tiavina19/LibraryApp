CREATE TABLE IF NOT EXISTS Book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

CREATE TABLE IF NOT EXISTS Author (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    gender CHAR(1)
);

CREATE TABLE IF NOT EXISTS Subscribers (
    subscriber_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255)
);



