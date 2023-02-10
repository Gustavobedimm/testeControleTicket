-- Table: public.ticket

-- DROP TABLE IF EXISTS public.ticket;

CREATE TABLE IF NOT EXISTS public.ticket
(
    id_ticket integer NOT NULL,
    id_func integer NOT NULL,
    quantidade integer NOT NULL,
    situacao "char" NOT NULL,
    data_entrega text COLLATE pg_catalog."default",
    CONSTRAINT ticket_pkey PRIMARY KEY (id_ticket)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.ticket
    OWNER to postgres;