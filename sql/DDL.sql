CREATE SCHEMA IF NOT EXISTS schema_a
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_unicode_ci;

USE schema_a;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE SCHEMA IF NOT EXISTS schema_b
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_unicode_ci;

USE schema_b;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL
) ENGINE = InnoDB
  CHARACTER SET utf8mb4
  COLLATE = utf8mb4_unicode_ci;
