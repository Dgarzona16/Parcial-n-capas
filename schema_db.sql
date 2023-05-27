create database "Capastify";

create table "User"
(
    "Code"   uuid default gen_random_uuid() not null
        constraint "User_pk"
            primary key,
    username varchar(50)                    not null,
    email    varchar(50)                    not null,
    password varchar(50)                    not null
);

comment on table "User" is 'Tabla para los usuarios de la app';

comment on column "User"."Code" is 'Codigo UUID para identificar a los usuarios';

alter table "User"
    owner to postgres;

create table "Playlist"
(
    code        uuid default gen_random_uuid() not null
        constraint "Playlist_pk"
            primary key,
    title       varchar(50)                    not null,
    description varchar(100)                   not null,
    user_code   uuid                           not null
        constraint "Playlist_user_fk"
            references "User"
);

comment on table "Playlist" is 'tabla para almacenar las playlist de los usuarios';

alter table "Playlist"
    owner to postgres;

create table "Songs"
(
    "Code"   uuid default gen_random_uuid() not null
        constraint "Songs_pk"
            primary key,
    title    varchar(50)                    not null,
    duration integer                        not null
);

comment on table "Songs" is 'tabla para almacenar las canciones';

alter table "Songs"
    owner to postgres;

create table "Song_X_Playlist"
(
    date_added    timestamp                      not null,
    song_code     uuid                           not null
        constraint "Song_X_Playlist_song_fk"
            references "Songs",
    playlist_code uuid                           not null
        constraint "Song_X_Playlist_playlist_fk"
            references "Playlist",
    "Code"        uuid default gen_random_uuid() not null
        constraint "Song_X_Playlist_pk"
            primary key
);

comment on table "Song_X_Playlist" is 'tabla de relacion entre las canciones y las playlist de usuarios';

alter table "Song_X_Playlist"
    owner to postgres;

