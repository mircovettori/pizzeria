create extension if not exists "uuid-ossp";

create table if not exists "user" (
    id uuid not null constraint pk_user primary key,
    name text not null,
    surname text not null,
    mail text,
    address text
);

create table if not exists "pizza" (
    id uuid not null constraint pk_pizza primary key,
    name text not null,
    description text
);

