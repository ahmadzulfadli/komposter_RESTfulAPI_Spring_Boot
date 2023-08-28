CREATE DATABASE komposter;

use komposter;

DROP TABLE temperatures;
DROP TABLE moistures;
Drop TABLE ph_meters;

CREATE TABLE temperatures(
    id VARCHAR(100) NOT NULL,
    value VARCHAR(100) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
)ENGINE InnoDB;

SELECT * FROM temperatures;
DESC temperatures;

CREATE TABLE moistures(
    id VARCHAR(100) NOT NULL,
    value VARCHAR(100) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
)ENGINE InnoDB;

CREATE TABLE ph_meters(
    id VARCHAR(100) NOT NULL,
    value VARCHAR(100) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
)ENGINE InnoDB;