CREATE TABLE if not exists "teacher" (
                         id SERIAL PRIMARY KEY,
                         firstName VARCHAR NOT NULL,
                         lastName VARCHAR NOT NULL,
                         email VARCHAR NOT NULL,
                         ref VARCHAR NOT NULL,
                         status VARCHAR NOT NULL,
                         phone VARCHAR NOT NULL,
                         birthDate DATE,
                         entranceDatetime TIMESTAMP,
                         sex VARCHAR NOT NULL,
                         address VARCHAR NOT NULL
);