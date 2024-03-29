PGDMP         ,                 {         	   game_shop    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16399 	   game_shop    DATABASE     }   CREATE DATABASE game_shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE game_shop;
                postgres    false            �            1259    16401    game    TABLE     �   CREATE TABLE public.game (
    game_id bigint NOT NULL,
    name character varying NOT NULL,
    creation_date date NOT NULL
);
    DROP TABLE public.game;
       public         heap    postgres    false            �            1259    16410    game_author    TABLE     �   CREATE TABLE public.game_author (
    game_author_id bigint NOT NULL,
    nickname character varying NOT NULL,
    birth_date date NOT NULL,
    game_game_id bigint
);
    DROP TABLE public.game_author;
       public         heap    postgres    false            �            1259    16428    game_author_id_seq    SEQUENCE     {   CREATE SEQUENCE public.game_author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.game_author_id_seq;
       public          postgres    false    215                       0    0    game_author_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.game_author_id_seq OWNED BY public.game_author.game_author_id;
          public          postgres    false    217            �            1259    16427    game_id_seq    SEQUENCE     t   CREATE SEQUENCE public.game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.game_id_seq;
       public          postgres    false    214                       0    0    game_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.game_id_seq OWNED BY public.game.game_id;
          public          postgres    false    216            �          0    16401    game 
   TABLE DATA           <   COPY public.game (game_id, name, creation_date) FROM stdin;
    public          postgres    false    214   �       �          0    16410    game_author 
   TABLE DATA           Y   COPY public.game_author (game_author_id, nickname, birth_date, game_game_id) FROM stdin;
    public          postgres    false    215          	           0    0    game_author_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.game_author_id_seq', 15, true);
          public          postgres    false    217            
           0    0    game_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.game_id_seq', 23, true);
          public          postgres    false    216            m           2606    16417    game_author game_author_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.game_author
    ADD CONSTRAINT game_author_pkey PRIMARY KEY (game_author_id);
 F   ALTER TABLE ONLY public.game_author DROP CONSTRAINT game_author_pkey;
       public            postgres    false    215            k           2606    16408    game game_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_pkey PRIMARY KEY (game_id);
 8   ALTER TABLE ONLY public.game DROP CONSTRAINT game_pkey;
       public            postgres    false    214            n           2606    16429    game_author game_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.game_author
    ADD CONSTRAINT game_id FOREIGN KEY (game_game_id) REFERENCES public.game(game_id) NOT VALID;
 =   ALTER TABLE ONLY public.game_author DROP CONSTRAINT game_id;
       public          postgres    false    214    3179    215            �      x������ � �      �      x������ � �     