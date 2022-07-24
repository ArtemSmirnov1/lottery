CREATE TABLE participants
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age  INTEGER,
    city VARCHAR(255)
);

CREATE TABLE winners
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(255),
    age   INTEGER,
    city  VARCHAR(255),
    prize INTEGER
)
;