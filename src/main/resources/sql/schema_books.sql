CREATE TABLE IF NOT EXISTS books
(
    id             INTEGER PRIMARY KEY,
    publication_id INTEGER,
    isbn           TEXT UNIQUE               NOT NULL,
    pages          INTEGER CHECK (pages > 0) NOT NULL,
    created_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updated_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    FOREIGN KEY (publication_id) REFERENCES publications (id) ON DELETE CASCADE
)