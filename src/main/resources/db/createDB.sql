
CREATE TABLE category
(
  id serial NOT NULL,
  name character varying(100),
  owner_id bigint,
  parent_category bigint,
  group_id bigint,
  CONSTRAINT category_pk PRIMARY KEY (id)
);

CREATE TABLE challenge
(
  metadata_id bigint,
  name character varying(100),
  id serial NOT NULL,
  CONSTRAINT challenege_pk PRIMARY KEY (id)
);

CREATE INDEX fki_challenge_challenge_metadata_pk
  ON challenge
  USING btree
  (metadata_id);
  
  CREATE TABLE challenge_details
(
  id serial NOT NULL,
  description character varying(500),
  links bigint,
  more_info character varying(500),
  duration integer,
  challenge_id bigint,
  CONSTRAINT challenge_details_pk PRIMARY KEY (id),
  CONSTRAINT challenege_challenege_details_fk FOREIGN KEY (challenge_id)
      REFERENCES challenge (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE challenge_metadata_id_name_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 23
  CACHE 1;

CREATE TABLE challenge_metadata
(
  group_age character varying(20),
  challenge_id bigint,
  id integer NOT NULL DEFAULT nextval('challenge_metadata_id_name_seq'::regclass),
  CONSTRAINT challenge_metadata_pk PRIMARY KEY (id),
  CONSTRAINT "challenge_FK" FOREIGN KEY (challenge_id)
      REFERENCES challenge (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE challenge_metadata_category
(
  id serial NOT NULL,
  category_id bigint,
  metadata_category_id bigint,
  CONSTRAINT challenge_metadata_category_pk PRIMARY KEY (id),
  CONSTRAINT category_fk FOREIGN KEY (category_id)
      REFERENCES category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT challenege_metadata_fk FOREIGN KEY (metadata_category_id)
      REFERENCES challenge_metadata (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO category(
            id, name, owner_id, parent_category, group_id)
    VALUES (1, 'Animals', 0, 0, 0),
     (2, 'Games', 0, 0, 0),
     (3, 'Environment', 0, 0, 0),
     (4, 'Art', 0, 0, 0),
     (5, 'Sport', 0, 0, 0),
     (6, 'Travel', 0, 0, 0),
     (7, 'Technology', 0, 0, 0);



