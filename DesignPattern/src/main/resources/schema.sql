create table if not exists product_item
(
    id   INT auto_increment PRIMARY KEY not null,
    name varchar(8)                     not null,
    pid  INT                            not null
);