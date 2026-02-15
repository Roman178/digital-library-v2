CREATE TABLE IF NOT EXISTS loans
(
    id                  INTEGER PRIMARY KEY,
    publication_item_id INTEGER NOT NULL,
    reader_id           INTEGER NOT NULL,
    loaned_at           DATE    NOT NULL,
    due_at              DATE    NOT NULL,
    returned_at         DATE    NULL,
    status              TEXT    NOT NULL,
    FOREIGN KEY (publication_item_id) REFERENCES publication_items (id),
    FOREIGN KEY (reader_id) REFERENCES readers (id)
)