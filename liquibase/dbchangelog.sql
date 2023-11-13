--liquibase formatted sql

-- changeset author-inserts:001
START TRANSACTION;

-- Insert authors
INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'George Orwell', 51);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'J. K. Rowling', 63);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'James Joyce', 28);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'Virginia Woolf', 36);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'Charles Dickens', 31);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'J. D. Salinger', 72);
UPDATE author_seq SET next_val = next_val + 1;

INSERT INTO author (id, name, age) VALUES ((SELECT next_val FROM author_seq), 'William Shakespeare', 91);
UPDATE author_seq SET next_val = next_val + 1;

COMMIT;

-- changeset tutorial-inserts:001
START TRANSACTION;

-- Insert tutorials with matching author_id
INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), '1984', 'Dystopian novel', (SELECT id FROM author WHERE name = 'George Orwell'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Harry Potter', 'Fantasy novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Ulysses', 'Modernist novel', (SELECT id FROM author WHERE name = 'James Joyce'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Mrs Dalloway', 'Modernist novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Great Expectations', 'Victorian novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'The Catcher in the Rye', 'Novel', (SELECT id FROM author WHERE name = 'J. D. Salinger'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Hamlet', 'Tragedy', (SELECT id FROM author WHERE name = 'William Shakespeare'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Animal Farm', 'Political satire', (SELECT id FROM author WHERE name = 'George Orwell'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'The Casual Vacancy', 'Novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'A Portrait of the Artist as a Young Man', 'Novel', (SELECT id FROM author WHERE name = 'James Joyce'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'To the Lighthouse', 'Novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'A Tale of Two Cities', 'Historical novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Franny and Zooey', 'Novel', (SELECT id FROM author WHERE name = 'J. D. Salinger'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Macbeth', 'Tragedy', (SELECT id FROM author WHERE name = 'William Shakespeare'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Coming Up for Air', 'Novel', (SELECT id FROM author WHERE name = 'George Orwell'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'The Silkworm', 'Novel', (SELECT id FROM author WHERE name = 'J. K. Rowling'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Dubliners', 'Short stories', (SELECT id FROM author WHERE name = 'James Joyce'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Orlando', 'Novel', (SELECT id FROM author WHERE name = 'Virginia Woolf'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Oliver Twist', 'Novel', (SELECT id FROM author WHERE name = 'Charles Dickens'));
UPDATE tutorial_seq SET next_val = next_val + 1;

INSERT INTO tutorial (id, title, description, author_id) VALUES ((SELECT next_val FROM tutorial_seq), 'Nine Stories', 'Short stories', (SELECT id FROM author WHERE name = 'J. D. Salinger'));
UPDATE tutorial_seq SET next_val = next_val + 1;

COMMIT;
