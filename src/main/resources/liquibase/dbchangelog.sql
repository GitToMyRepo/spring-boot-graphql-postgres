--liquibase formatted sql

-- changeset schema:001
CREATE SEQUENCE author_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tutorial_seq START WITH 1 INCREMENT BY 1;

-- changeset schema:002
CREATE TABLE author (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  age INTEGER
);

CREATE TABLE tutorial (
  id BIGINT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  author_id BIGINT,
  CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id)
);

-- changeset author-inserts:001
-- Insert authors
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'George Orwell', 51);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'J. K. Rowling', 63);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'James Joyce', 28);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'Virginia Woolf', 36);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'Charles Dickens', 31);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'J. D. Salinger', 72);
INSERT INTO author (id, name, age) VALUES (nextval('author_seq'), 'William Shakespeare', 91);

-- changeset tutorial-inserts:001
-- Insert tutorials with matching author_id
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), '1984', 'Dystopian novel', (SELECT id FROM author WHERE name = 'George Orwell'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Harry Potter', 'Fantasy novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Ulysses', 'Modernist novel', (SELECT id FROM author WHERE name = 'James Joyce'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Mrs Dalloway', 'Modernist novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Great Expectations', 'Victorian novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'The Catcher in the Rye', 'Novel', (SELECT id FROM author WHERE name = 'J. D. Salinger'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Hamlet', 'Tragedy', (SELECT id FROM author WHERE name = 'William Shakespeare'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Animal Farm', 'Political satire', (SELECT id FROM author WHERE name = 'George Orwell'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'The Casual Vacancy', 'Novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'A Portrait of the Artist as a Young Man', 'Novel', (SELECT id FROM author WHERE name = 'James Joyce'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'To the Lighthouse', 'Novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'A Tale of Two Cities', 'Historical novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Franny and Zooey', 'Novel', (SELECT id FROM author WHERE name = 'J. D. Salinger'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Macbeth', 'Tragedy', (SELECT id FROM author WHERE name = 'William Shakespeare'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Coming Up for Air', 'Novel', (SELECT id FROM author WHERE name = 'George Orwell'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'The Silkworm', 'Novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Dubliners', 'Short stories', (SELECT id FROM author WHERE name = 'James Joyce'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Orlando', 'Novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Oliver Twist', 'Novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
INSERT INTO tutorial (id, title, description, author_id) VALUES (nextval('tutorial_seq'), 'Nine Stories', 'Short stories', (SELECT id FROM author WHERE name = 'J. D. Salinger'));