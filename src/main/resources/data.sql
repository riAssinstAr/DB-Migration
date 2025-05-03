-- Correcting table name to match the entity
INSERT INTO employees (id, username, email, preferences)
VALUES  (1, 'alice', 'alice@example.com', ' {"theme":"dark"}'),
        (2, 'bob', 'bob@example.com', '{"theme":"light"}'),
        (3, 'charlie', 'charlie@example.com', '{"theme":"dark"}');
