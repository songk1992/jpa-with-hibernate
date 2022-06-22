-- create table person
-- (
--     id         integer      not null,
--     name       varchar(255) not null,
--     location   varchar(255),
--     birth_date timestamp,
--     primary key (id)
-- );

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'SONG', 'KIM', CURRENT_TIMESTAMP());

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'SONG2', 'KIM2', CURRENT_TIMESTAMP());

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'SONG3', 'KIM3', CURRENT_TIMESTAMP());