CREATE TABLE IF NOT EXISTS publications
(
    id               INTEGER PRIMARY KEY,
    type             TEXT CHECK (type IN ('BOOK', 'MAGAZINE_ISSUE', 'COMIC_ISSUE')) NOT NULL,
    title            TEXT                                                           NOT NULL,
    genre            TEXT                                                           NOT NULL,
    publisher        TEXT                                                           NULL,
    publication_year INTEGER CHECK (publication_year > 0)                           NOT NULL,
    created_at       DATE                                                           NOT NULL DEFAULT (datetime('now')),
    updated_at       DATE                                                           NOT NULL DEFAULT (datetime('now'))
)
