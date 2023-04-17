CREATE TABLE IF NOT EXISTS public.games
(
    id bigint NOT NULL DEFAULT nextval('game_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    creation_date date NOT NULL,
    authors_of_game boolean[] NOT NULL,
    CONSTRAINT game_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.game_authors
(
    id bigint NOT NULL DEFAULT nextval('game_author_id_seq'::regclass),
    nickname character varying COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    games_of_author bigint[],
    CONSTRAINT game_author_pkey PRIMARY KEY (id)
)
