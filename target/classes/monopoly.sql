create sequence "Anon_User_id_seq"
    as integer;


create sequence "Rating_id_seq"
    as integer;


create sequence "Reg_User_id_seq"
    as integer;


create sequence "Rooms_id_seq"
    as integer;

create table anon_user
(
    id     integer default nextval('"Anon_User_id_seq"'::regclass) not null
        constraint "Anon_User_pkey"
            primary key,
    iden32 varchar                                                 not null
);


create unique index anon_user_iden32_uindex
    on anon_user (iden32);



create table bot
(
    id              bigint default nextval('"Bot_id_seq"'::regclass) not null
        constraint "Bot_pkey"
            primary key,
    token           varchar                                          not null,
    date_begin_work date,
    count_of_use    bigint,
    is_free         boolean
);

create unique index bot_token_uindex
    on bot (token);

create table reg_user
(
    id             integer default nextval('"Reg_User_id_seq"'::regclass) not null
        constraint "Reg_User_pkey"
            primary key,
    username       varchar                                                not null,
    login          varchar                                                not null,
    email          varchar                                                not null,
    count_win      bigint,
    count_lose     bigint,
    date_of_regist date    default CURRENT_DATE,
    birthdate      date                                                   not null
);

create unique index reg_user_email_uindex
    on reg_user (email);

create unique index reg_user_login_uindex
    on reg_user (login);

create unique index reg_user_username_uindex
    on reg_user (username);

create table rating
(
    id       integer default nextval('"Rating_id_seq"'::regclass) not null
        constraint rating_pk
            primary key,
    id_user  bigint
        constraint "Rating_id_user_fkey"
            references reg_user,
    date_add date
);



create table rooms
(
    id               integer default nextval('"Rooms_id_seq"'::regclass) not null
        constraint "Rooms_pkey"
            primary key,
    count_of_player  bigint,
    mode_game        varchar,
    type_game        varchar,
    have_token       boolean,
    token            varchar,
    must_regist      boolean,
    have_bots        boolean,
    bots_id          bigint
        constraint "Rooms_bots_id_fkey"
            references bot,
    users_id         bigint
        constraint "Rooms_users_id_fkey"
            references reg_user,
    anons_id         bigint
        constraint "Rooms_anons_id_fkey"
            references anon_user,
    is_active        boolean,
    date_of_activate date
);

create unique index rooms_token_uindex
    on rooms (token);


