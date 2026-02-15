CREATE TABLE IF NOT EXISTS magazine_issues
(
    id             INTEGER PRIMARY KEY,
    magazine_title TEXT                                                             NOT NULL,
    issue_number   INTEGER                                                          NOT NULL,
    issn           TEXT                                                             NOT NULL,
    month          INTEGER CHECK (month IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)) NULL,
    publication_id INTEGER NULL,
    created_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updated_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    FOREIGN KEY (publication_id) REFERENCES publications (id) ON DELETE CASCADE,
    UNIQUE (issn, issue_number, publication_id)
)