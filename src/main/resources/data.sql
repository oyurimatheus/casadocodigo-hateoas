INSERT INTO authors (id, first_name, last_name) VALUES(1, 'Alberto', 'Souza');
INSERT INTO authors (id, first_name, last_name) VALUES(2, 'Mauricio', 'Aniche');

INSERT INTO books (id, title, subtitle, publishing_date, isbn) VALUES(1, 'Spring MVC', 'Domine o principal framework web Java', '2015-04-01', '978-85-5519-019-3');
INSERT INTO books (id, title, subtitle, publishing_date, isbn) VALUES(2, 'Java EE', 'Aproveite toda a plataforma para construir aplicações', '2015-11-01', '978-85-5519-115-2');
INSERT INTO books (id, title, subtitle, publishing_date, isbn) VALUES(3, 'Orientação a Objetos e SOLID para Ninjas', 'Projetando classes flexíveis ', '2015-03-01', '978-85-5519-037-7');

INSERT INTO books_authors (book_id, authors_id) VALUES(1, 1);
INSERT INTO books_authors (book_id, authors_id) VALUES(2, 1);
INSERT INTO books_authors (book_id, authors_id) VALUES(3, 2);