-- change the owner field with the name of owner you want to manage this database
create database "curso-jsp"
    with
    owner = owner_name
    encoding = UTF8
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    tablespace = pg_default
    connection limit = -1
    template template0;

-- table usuarios
create table usuario (
  id bigint primary key,
  nome character varying(255),
  telefone character varying(255),
  login character varying(255),
  senha character varying(255),
  ibge character varying(255),
  cep character varying(255),
  rua character varying(255),
  bairro character varying(255),
  cidade character varying(255),
  estado character varying(255)
);

-- sequence for autoincrement id (there are three commands. Run ony by one)
create sequence serialuser
  increment 1
  minvalue 1
  maxvalue 9223372036854775807
  start 1
  cache 1;
  
alter table serialuser
    owner to user_owner;
  
alter table usuario alter column id set default nextval('serialuser'::regclass);
