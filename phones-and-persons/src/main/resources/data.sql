-------------------------------------------------------------------------------
-- Table person
INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (1, 'Jack', 'White', {ts '2010-01-01 20:00:02.00'}, 186);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (2, 'John', 'Fruciante', {ts '2000-01-01 20:00:02.00'}, 190);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (3, 'Jimmy', 'Page', {ts '1950-01-01T20:00:02'}, 179);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (4, 'John', 'Bohnam', {ts '1952-01-01T20:00:02'}, 169);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (5, 'Robby', 'Williams', {ts '1980-01-01T20:00:02'}, 185);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (6, 'John', 'Zorn', {ts '1955-01-01T20:00:02'}, 183);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (7, 'Anna', 'Van Lare', {ts '1978-01-01T20:00:02'}, 187);

INSERT INTO person(id, first_name, last_name, birth_date, height_in_centimeters)
VALUES (8, 'Edith', 'Piath', {ts '1930-01-01T20:00:02'}, 150);

-------------------------------------------------------------------------------
-- Table phone
INSERT INTO phone(id, country_prefix, number) VALUES (1, '48', '604762345');
INSERT INTO phone(id, country_prefix, number) VALUES (2, '48', '765993455');
INSERT INTO phone(id, country_prefix, number) VALUES (3, '12', '778843334');
INSERT INTO phone(id, country_prefix, number) VALUES (4, '67', '576767777');

ALTER SEQUENCE phone_seq RESTART WITH 5 INCREMENT BY 1