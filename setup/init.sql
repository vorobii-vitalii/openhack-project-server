CREATE DATABASE plates_db;

USE plates_db;

-- USERS TABLE
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(150) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    is_verified TINYINT(1)
);


-- RESPONSIBILITIES TABLE
CREATE TABLE responsibilities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    total_hours INT NOT NULL,
    created_by INT,
    FOREIGN KEY (created_by)
        REFERENCES users (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);

-- TASKS TABLE
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    responsibility_id INT NOT NULL,
    num_hours INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deadline_at TIMESTAMP NOT NULL,
    FOREIGN KEY (responsibility_id)
        REFERENCES responsibilities (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);

-- USER VERIFICATION
CREATE TABLE user_verification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(150) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);