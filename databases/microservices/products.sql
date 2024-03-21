create table microservices.products
(
    id          bigint auto_increment
        primary key,
    name        varchar(64)  not null,
    stock       int          not null,
    price       double       not null,
    description varchar(256) null,
    constraint cameras_name_uindex
        unique (name)
);

