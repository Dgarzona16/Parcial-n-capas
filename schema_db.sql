create database "Capastify";

create table "Users"
(
    "code"   uuid default gen_random_uuid() not null
        constraint "User_pk"
            primary key,
    username varchar(50)                    not null,
    email    varchar(50)                    not null,
    password varchar(50)                    not null
);

comment on table "Users" is 'Tabla para los usuarios de la app';

alter table "Users"
    owner to postgres;

create table "Playlists"
(
    code        uuid default gen_random_uuid() not null
        constraint "Playlist_pk"
            primary key,
    title       varchar(50)                    not null,
    description varchar(100)                   not null,
    user_code   uuid                           not null
        constraint "Playlist_user_fk"
            references "Users"
);

comment on table "Playlists" is 'tabla para almacenar las playlist de los usuarios';

alter table "Playlists"
    owner to postgres;

create table "Songs"
(
    "code"   uuid default gen_random_uuid() not null
        constraint "Songs_pk"
            primary key,
    title    varchar(50)                    not null,
    duration integer                        not null
);

comment on table "Songs" is 'tabla para almacenar las canciones';

alter table "Songs"
    owner to postgres;

create table "Songs_X_Playlists"
(
    date_added    timestamp                      not null,
    song_code     uuid                           not null
        constraint "Song_X_Playlist_song_fk"
            references "Songs",
    playlist_code uuid                           not null
        constraint "Song_X_Playlist_playlist_fk"
            references "Playlists",
    "code"        uuid default gen_random_uuid() not null
        constraint "Song_X_Playlist_pk"
            primary key
);

comment on table "Songs_X_Playlists" is 'tabla de relacion entre las canciones y las playlist de usuarios';

alter table "Songs_X_Playlists"
    owner to postgres;

