DROP SCHEMA if exists handleliste cascade;

CREATE SCHEMA handleliste;

set search_path to handleliste;

DROP TABLE IF EXISTS  item;

CREATE TABLE item 
(
   item_id	SERIAL NOT NULL,
   item_navn	TEXT NOT NULL,
   PRIMARY KEY (item_id)
);





