package org.example.db;

import org.example.util.SqlReader;

public enum Query {
    INDEX_UX_LOANS_ACTIVE_ITEM("sql/index_ux_loans_active_item.sql"),
    SCHEMA_AUTHORS("sql/schema_authors.sql"),
    SCHEMA_BOOKS("sql/schema_books.sql"),
    SCHEMA_COMIC_ISSUES("sql/schema_comic_issues.sql"),
    SCHEMA_LOANS("sql/schema_loans.sql"),
    SCHEMA_MAGAZINE_ISSUES("sql/schema_magazine_issues.sql"),
    SCHEMA_PUBLICATION_AUTHORS("sql/schema_publication_authors.sql"),
    SCHEMA_PUBLICATION_ITEMS("sql/schema_publication_items.sql"),
    SCHEMA_PUBLICATIONS("sql/schema_publications.sql"),
    SCHEMA_READERS("sql/schema_readers.sql");

    private final String sql;

    Query(String path) {
        sql = SqlReader.load(path);
    }

    public String getSql() {
        return sql;
    }
}
