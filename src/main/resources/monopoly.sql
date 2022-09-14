CREATE TABLE "Anon_User" (
                             "id" SERIAL PRIMARY KEY,
                             "iden32" varchar NOT NULL
);

CREATE TABLE "Bot" (
                       "id" bigserial PRIMARY KEY,
                       "token" varchar NOT NULL,
                       "date_begin_work" date NOT NULL,
                       "count_of_use" bigint NOT NULL,
                       "is_free" boolean NOT NULL
);

CREATE TABLE "Reg_User" (
                            "id" SERIAL PRIMARY KEY,
                            "username" varchar NOT NULL,
                            "login" varchar NOT NULL,
                            "email" varchar NOT NULL,
                            "count_win" bigint NOT NULL,
                            "count_lose" bigint NOT NULL,
                            "date_of_regist" date NOT NULL,
                            "birthdate" date NOT NULL
);

CREATE TABLE "Rating" (
                          "id" SERIAL,
                          "id_user" bigint,
                          "date_add" date NOT NULL
);

CREATE TABLE "Rooms" (
                         "id" SERIAL PRIMARY KEY,
                         "count_of_player" bigint NOT NULL,
                         "mode_game" varchar NOT NULL,
                         "type_game" varchar NOT NULL,
                         "have_token" boolean NOT NULL,
                         "token" varchar NOT NULL,
                         "must_regist" boolean NOT NULL,
                         "have_bots" boolean NOT NULL,
                         "bots_id" bigint,
                         "users_id" bigint,
                         "anons_id" bigint,
                         "is_active" boolean NOT NULL,
                         "date_of_activate" date NOT NULL
);

ALTER TABLE "Rating" ADD FOREIGN KEY ("id_user") REFERENCES "Reg_User" ("id");

ALTER TABLE "Rooms" ADD FOREIGN KEY ("bots_id") REFERENCES "Bot" ("id");

ALTER TABLE "Rooms" ADD FOREIGN KEY ("users_id") REFERENCES "Reg_User" ("id");

ALTER TABLE "Rooms" ADD FOREIGN KEY ("anons_id") REFERENCES "Anon_User" ("id");
