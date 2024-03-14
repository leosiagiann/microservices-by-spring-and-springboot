create table microservices.users
(
    id       bigint auto_increment
        primary key,
    name     varchar(128) null,
    username varchar(512) not null,
    email    varchar(512) not null,
    password varchar(512) not null,
    age      int          null,
    constraint users_email_uindex
        unique (email),
    constraint users_username_uindex
        unique (username)
);

