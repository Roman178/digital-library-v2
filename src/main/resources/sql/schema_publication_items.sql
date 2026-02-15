CREATE TABLE IF NOT EXISTS publication_items
(
    id             INTEGER PRIMARY KEY,
    publication_id INTEGER NOT NULL,
    inventory_code TEXT    NOT NULL,
    status         TEXT    NOT NULL,
    created_at     TEXT    NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updated_at     TEXT    NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    UNIQUE (inventory_code),
    FOREIGN KEY (publication_id) REFERENCES publications (id),
    CHECK ( status IN ('AVAILABLE', 'LOANED', 'LOST', 'DAMAGED') )
)