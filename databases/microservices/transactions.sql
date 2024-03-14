create table microservices.transactions
(
    id               bigint auto_increment
        primary key,
    user_id          bigint                                not null,
    product_id       bigint                                not null,
    quantity         int                                   not null,
    total_price      double                                null,
    transaction_date timestamp default current_timestamp() not null on update current_timestamp(),
    status           varchar(32)                           null,
    payment_method   varchar(64)                           null,
    shipping_address varchar(256)                          not null,
    tracking_number  varchar(128)                          null
);

