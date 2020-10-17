-- PG 10

CREATE TABLE public.languages (
	"name" varchar(255) NOT NULL,
	description varchar(255) NULL,
	rating int4 NULL,
	CONSTRAINT languages_pkey PRIMARY KEY (name)
);