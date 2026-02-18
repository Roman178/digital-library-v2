BEGIN TRANSACTION;

INSERT INTO authors(full_name)
VALUES ('George Orwell'),
       ('Aldous Huxley'),
       ('J.D. Salinger'),
       ('Harper Lee'),
       ('J.R.R. Tolkien'),
       ('J.K. Rowling');

INSERT INTO publications(type, title, genre, publisher, publication_year)
VALUES ('BOOK', '1984', 'DYSTOPIAN', 'Secker & Warburg', 1949),
       ('BOOK', 'Brave New World', 'DYSTOPIAN', 'Chatto & Windus', 1932),
       ('BOOK', 'The Catcher in the Rye', 'CLASSIC', 'Little, Brown and Company', 1951),
       ('BOOK', 'To Kill a Mockingbird', 'CLASSIC', 'J.B. Lippincott & Co.', 1960),
       ('BOOK', 'The Hobbit', 'FANTASY', 'George Allen & Unwin', 1937),
       ('BOOK', 'Harry Potter and the Philosopher''s Stone', 'FANTASY', 'Bloomsbury', 1997);

INSERT INTO books(publication_id, isbn, pages)
VALUES (1, '9780451524935', 328),
       (2, '9780060850524', 311),
       (3, '9780316769488', 277),
       (4, '9780061120084', 281),
       (5, '9780261102217', 310),
       (6, '9780747532699', 223);

INSERT INTO publication_authors (publication_id, author_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6);

-- Публикации (MAGAZINE_ISSUE)
INSERT INTO publications (type, title, genre, publisher, publication_year)
VALUES ('MAGAZINE_ISSUE', 'National Geographic — Issue 202', 'SCIENCE', 'National Geographic Partners', 2024),
       ('MAGAZINE_ISSUE', 'National Geographic — Issue 203', 'SCIENCE', 'National Geographic Partners', 2024);

-- Детали журналов (publication_id = 7..8)
INSERT INTO magazine_issues (publication_id, magazine_title, issue_number, issn, month, publication_year)
VALUES (7, 'National Geographic', 202, '0027-9358', 9, 2024),
       (8, 'National Geographic', 203, '0027-9358', 10, 2024);

-- Публикации (COMIC_ISSUE)
INSERT INTO publications (type, title, genre, publisher, publication_year)
VALUES ('COMIC_ISSUE', 'Batman #5 (Vol. 3)', 'COMICS', 'DC', 2016),
       ('COMIC_ISSUE', 'Batman #5 (Vol. 3)', 'COMICS', 'DC', 2016);

-- Примечание: две одинаковые записи publications обычно НЕ нужны,
-- но я оставил специально как "антипример". Ниже покажу правильный подход через items.
-- Поэтому сейчас удалим дубль и оставим 1 publication.

DELETE
FROM publications
WHERE id = 10;

-- Детали комикса (publication_id = 9)
INSERT INTO comic_issues (publication_id, series_title, issue_number, universe, publication_year)
VALUES (9, 'Batman (Vol. 3)', 5, 'DC', 2016);

-- Экземпляры (items)
-- Для книг сделаем по 1 экземпляру, для комикса 3 экземпляра, для журнала 2 экземпляра
INSERT INTO publication_items (publication_id, inventory_code, status, location)
VALUES (1, 'INV-000001', 'AVAILABLE', 'A-1'),
       (2, 'INV-000002', 'AVAILABLE', 'A-1'),
       (3, 'INV-000003', 'AVAILABLE', 'A-2'),
       (4, 'INV-000004', 'AVAILABLE', 'A-2'),
       (5, 'INV-000005', 'AVAILABLE', 'B-1'),
       (6, 'INV-000006', 'AVAILABLE', 'B-1'),

       (7, 'INV-000007', 'AVAILABLE', 'M-1'),
       (7, 'INV-000008', 'AVAILABLE', 'M-1'),

       (9, 'INV-000009', 'AVAILABLE', 'C-1'),
       (9, 'INV-000010', 'AVAILABLE', 'C-1'),
       (9, 'INV-000011', 'AVAILABLE', 'C-1');

-- Читатели
INSERT INTO readers (full_name, email)
VALUES ('Ivan Petrov', 'ivan.petrov@example.com'),
       ('Anna Smirnova', 'anna.smirnova@example.com');

-- Выдачи: одну сделаем активной, одну возвращённой
-- Активная: выдадим INV-000009 (item_id можно получить по порядку: это 9-й item)
INSERT INTO loans (publication_item_id, reader_id, loaned_at, due_at, returned_at, status)
VALUES (9, 1, datetime('now', '-1 day'), datetime('now', '+13 day'), NULL, 'ACTIVE');

-- Возвращённая: INV-000007 (item_id=7)
INSERT INTO loans (publication_item_id, reader_id, loaned_at, due_at, returned_at, status)
VALUES (7, 2, datetime('now', '-20 day'), datetime('now', '-6 day'), datetime('now', '-5 day'), 'RETURNED');

COMMIT;