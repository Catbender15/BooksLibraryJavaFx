SET GLOBAL time_zone = '+3:00';


create table booksdb.authors(
id_authors int unsigned auto_increment primary key,
first_name Varchar(30) not NULL,
last_name Varchar(30) not NULL,
id_books int unsigned,
foreign key(id_books) references books(id_books)
);

insert into booksdb.authors
(first_name, last_name)
values
('Petras', 'Petraitis'),
('Jonas', 'Jonaitis');


create table booksdb.books(
id_books int unsigned auto_increment primary key,
title Varchar(30) not NULL,
descriptions Varchar(300) not NULL,
author Varchar(30) not NULL
);

insert into booksdb.books
(id_books, title, descriptions, author)
values
(1, 'Piter Pen', 'about your life', 'Petras Petrauskas'),
(2, 'Labas ate', 'About labas', 'Tomas Tomauskas');
