# Digital Library v2

CLI-приложение для работы с цифровой библиотекой.

## Стек

- Java 17
- Maven
- SQLite
- JDBC
- Liquibase

## Формат команд

```text
entity; action; [subaction]; key=value; key=value
```

Пример:

```text
reader; add; fullName=Roman Petrov; email=roman@example.com
```

## Общие команды

- `help` - показать список команд.
- `exit` - завершить приложение.

```text
help
exit
```

## Публикации

- `pub; add; book; title=<...>; author=<...>; genre=<...>; year=<...>; isbn=<...>` - добавить книгу.
- `pub; add; magazine; title=<...>; genre=<...>; year=<...>; issue=<...>` - добавить выпуск журнала.
- `pub; add; comic; title=<...>; genre=<...>; year=<...>; series=<...>; issue=<...>` - добавить выпуск комикса.
- `pub; list` - показать все публикации.
- `pub; get; id=<id>` - показать публикацию по id.
- `pub; search; title; q=<text>` - поиск по названию.
- `pub; search; author; q=<text>` - поиск по автору.
- `pub; filter; genre; genre=<GENRE>` - фильтр по жанру.
- `pub; filter; yearAfter; year=<yyyy>` - публикации после указанного года.
- `pub; sort; by=<field>; dir=<asc|desc>` - сортировка публикаций.

```text
pub; add; book; title=1984; author=George Orwell; genre=CLASSIC; year=1949; isbn=9780451524935
pub; add; magazine; title=National Geographic; genre=HISTORY; year=2025; issue=2025-01
pub; add; comic; title=Spider-Man; genre=COMICS; year=1990; series=Spider-Man; issue=1
pub; list
pub; get; id=3
pub; search; title; q=Harry
pub; search; author; q=Orwell
pub; filter; genre; genre=FANTASY
pub; filter; yearAfter; year=2000
pub; sort; by=title; dir=asc
pub; sort; by=year; dir=desc
```

## Экземпляры

- `item; add; pubId=<id>; count=<n>` - добавить экземпляры публикации.
- `item; list; pubId=<id>` - показать все экземпляры публикации.
- `item; available; pubId=<id>` - показать доступные экземпляры.

```text
item; add; pubId=3; count=2
item; list; pubId=3
item; available; pubId=3
```

## Читатели

- `reader; add; fullName=<...>; email=<...>` - добавить читателя.
- `reader; list` - показать список читателей.
- `reader; get; id=<id>` - показать читателя по id.

```text
reader; add; fullName=Roman Petrov; email=roman@example.com
reader; add; fullName=Anna Smirnova; email=anna@example.com
reader; list
reader; get; id=1
```

## Выдача и возврат

- `loan; issue; pubId=<id>; readerId=<id>` - выдать первый доступный экземпляр публикации.
- `loan; issue; item; itemId=<id>; readerId=<id>` - выдать конкретный экземпляр.
- `loan; return; itemId=<id>` - вернуть экземпляр.
- `loan; list; active` - показать активные выдачи.
- `loan; list; byReader; readerId=<id>` - показать все выдачи читателя.

```text
loan; issue; pubId=3; readerId=1
loan; issue; item; itemId=1002; readerId=1
loan; return; itemId=1002
loan; list; active
loan; list; byReader; readerId=1
```

## Отчёты

- `report; authors` - показать уникальных авторов.
- `report; countByGenre` - показать количество публикаций по жанрам.
- `report; topGenres; limit=<n>` - показать топ жанров.
- `report; inventory` - показать всего / доступно / выдано по публикациям.

```text
report; authors
report; countByGenre
report; topGenres; limit=3
report; inventory
```

## Сервис

- `db; info` - показать путь к SQLite, версию и количество строк в таблицах.
- `db; reset` - пересоздать базу данных.

```text
db; info
db; reset
```
