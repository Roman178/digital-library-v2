CREATE TABLE IF NOT EXISTS publication_authors
(
    publication_id INTEGER NOT NULL,
    author_id      INTEGER NOT NULL,
    created_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updated_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    PRIMARY KEY (publication_id, author_id),
    FOREIGN KEY (publication_id) REFERENCES publications (id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors (id) ON DELETE CASCADE
)