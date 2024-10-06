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

create table if not exists "order" (
    id uuid not null constraint pk_order primary key,
    user_id uuid references user(id),
);

create table if not exists "order_pizza" (
    id uuid not null constraint pk_order primary key,
    pizza_id uuid references pizza(id),
    number int not null
);

create table if not exists "order_history" (
    id uuid not null constraint pk_order primary key,
    order_id uuid references order(id),
    status text not null,
    update_ts bigint
);