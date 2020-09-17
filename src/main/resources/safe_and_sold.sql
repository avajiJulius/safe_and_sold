drop table if exists order_items;
drop table if exists orders;
drop table if exists roles;
drop table if exists categories;
drop table if exists products;
drop table if exists users;

create table users (
    user_id serial not null,
    username varchar(20) not null,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    patronymic varchar(30),
    date_of_birth date not null,
    email varchar(40) not null,
    password varchar(40) not null,
    active boolean default true not null,
    exist boolean default true not null,
    primary key(user_id)
);

create table products (
    product_id serial not null primary key,
    product_name varchar(40) not null,
    price numeric not null,
    check (price > 0),
    discounter_price numeric,
    check (discounter_price > 0),
    constraint valid_price check (price > discounter_price),
    quantity integer not null,
    owner_id integer not null,
    checked boolean default false,
    visible boolean default true,
    foreign key(owner_id) references users(user_id) on delete restrict

);

create table roles (
    user_id integer not null,
    roles varchar(100) not null,
    foreign key(user_id) references users(user_id) on delete restrict
);

create table categories (
    product_id integer not null,
    categories varchar(100) not null,
    foreign key(product_id) references products(product_id) on delete restrict
);

create table orders (
    order_id serial not null primary key,
    buyer integer not null,
    shipping_address varchar(100) not null,
    foreign key (buyer) references users(user_id) on delete restrict
);

create table order_items (
    order_id integer not null,
    product_id integer not null,
    order_item_quantity integer not null,
    primary key(order_id, product_id),
    foreign key(order_id) references orders(order_id) on delete restrict,
    foreign key(product_id) references products(product_id) on delete restrict
);