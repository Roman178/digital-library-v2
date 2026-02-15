CREATE TABLE IF NOT EXISTS comic_issues
(
    id             INTEGER PRIMARY KEY,
    publication_id INTEGER NOT NULL,
    series_title   TEXT    NOT NULL,
    issue_number   INTEGER NOT NULL,
    universe       TEXT    NULL,
    created_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updated_at TEXT NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    FOREIGN KEY (publication_id) REFERENCES publications (id) ON DELETE CASCADE,
    UNIQUE (issue_number, series_title, publication_id)
)