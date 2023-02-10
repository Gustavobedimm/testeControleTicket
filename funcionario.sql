-- Table: public.funcionario

-- DROP TABLE IF EXISTS public.funcionario;

CREATE TABLE IF NOT EXISTS public.funcionario
(
    id integer NOT NULL,
    nome text COLLATE pg_catalog."default" NOT NULL,
    cpf text COLLATE pg_catalog."default" NOT NULL,
    situacao "char" NOT NULL,
    data_alteracao text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT funcionario_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.funcionario
    OWNER to postgres;