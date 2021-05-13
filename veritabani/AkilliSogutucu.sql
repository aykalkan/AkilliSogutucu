-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

-- DROP SEQUENCE public.kullanicilar_id_seq;

CREATE SEQUENCE public.kullanicilar_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.sicaklik_id_seq;

CREATE SEQUENCE public.sicaklik_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public."Kullanicilar" definition

-- Drop table

-- DROP TABLE public."Kullanicilar";

CREATE TABLE public."Kullanicilar" (
	id int4 NOT NULL DEFAULT nextval('kullanicilar_id_seq'::regclass),
	isim varchar NOT NULL,
	sifre varchar NOT NULL,
	yas int2 NULL
);


-- public."Sicaklik" definition

-- Drop table

-- DROP TABLE public."Sicaklik";

CREATE TABLE public."Sicaklik" (
	id int4 NOT NULL DEFAULT nextval('sicaklik_id_seq'::regclass),
	sicaklik int4 NOT NULL,
	saat timestamp(0) NOT NULL
);

