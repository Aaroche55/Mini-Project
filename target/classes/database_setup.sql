-- creating tables for database

--                         LAYOUT
-- +-------------------+  +-------------------+   +-------------------+
-- |    Users Table    |  |    Scores Table   |   |  Questions Table  |
-- +-------------------+  +-------------------+   +-------------------+
-- | username (PK)  |<---| username (FK)      |   | id (PK)           |
-- | hashed_password|    | id                 |   | category          |
-- | salt           |    | quiz_mode          |   | difficulty        |
-- +-------------------+ | score              |   | question          |
--                       | difficulty         |   | option_a          |
--                        +-------------------+   | option_b          |
--                                                | option_c          |
--                                                | correct_option    |
--                                                 +-------------------+



-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
    username TEXT PRIMARY KEY,
    hashed_password TEXT NOT NULL,
    salt TEXT NOT NULL
);

-- Create Questions Table
CREATE TABLE IF NOT EXISTS questions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    category TEXT NOT NULL,
    difficulty TEXT NOT NULL,
    question TEXT NOT NULL,
    option_a TEXT NOT NULL,
    option_b TEXT NOT NULL,
    option_c TEXT NOT NULL,
    correct_option TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS scores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT,
    quiz_mode TEXT,
    score INTEGER,
    difficulty TEXT,
    FOREIGN KEY (username) REFERENCES users(username)
);