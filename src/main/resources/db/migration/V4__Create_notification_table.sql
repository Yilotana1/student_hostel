CREATE TABLE IF NOT EXISTS notification
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50)   NOT NULL,
    text  VARCHAR(2048) NOT NULL,
    author INT NOT NULL,

    FOREIGN KEY (author) REFERENCES user (id)
);

