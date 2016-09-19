DROP SCHEMA if exists skole cascade;

CREATE SCHEMA skole;

set search_path to skole;

DROP TABLE IF EXISTS  student;
DROP TABLE IF EXISTS klasse;

CREATE TABLE klasse 
(
   kode      	TEXT NOT NULL,
   program		TEXT NOT NULL,
   PRIMARY KEY (kode)
);

CREATE TABLE student 
(
   id           TEXT NOT NULL,
   navn         TEXT NOT NULL,
   klasse_kode  TEXT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (klasse_kode) REFERENCES klasse (kode)
);

INSERT INTO klasse VALUES('15HDATA', 'Bachelor Ingeniørfag, Data');
INSERT INTO klasse VALUES('15HINF',  'Bachelor Informasjonsteknologi');

INSERT INTO student VALUES('h123456', 'King Kong', '15HDATA');
INSERT INTO student VALUES('h234567', 'Super Mann', '15HINF');







