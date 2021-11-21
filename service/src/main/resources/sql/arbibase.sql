-- ARBI_CONFIG
create table arbi_config
(
    id         serial      not null
        constraint arbi_config_pk
            primary key,
    attr_name  varchar(32) not null,
    attr_value varchar(64)
);

alter table arbi_config
    owner to postgres;

create unique index arbi_config_id_uindex
    on arbi_config (ID);


-- OKEX_TICKERS
create table okex_tickers
(
    id     serial                not null
        constraint okex_tickers_pk
            primary key,
    name   varchar(32)           not null,
    active boolean default false not null
);

alter table okex_tickers
    owner to postgres;

create unique index okex_tickers_name_uindex
    on okex_tickers (name);


-- BINANCE_TICKERS
create table binance_tickers
(
    id     serial                not null
        constraint binance_tickers_pk
            primary key,
    name   varchar(32)           not null,
    active boolean default false not null
);

alter table binance_tickers
    owner to postgres;

create unique index binance_tickers_name_uindex
    on binance_tickers (name);

