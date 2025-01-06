CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(200),
    date TIMESTAMP,
    deadline DATE,
    priority INT,
    status INT
);