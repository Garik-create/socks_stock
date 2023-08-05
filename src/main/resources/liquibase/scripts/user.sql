-- liquibase formatted sql

-- changeset izavalin:create_tables
create TABLE users
(
user_id SERIAL PRIMARY KEY,
user_name VARCHAR(100) NOT NULL,
password TEXT NOT NULL,
role smallint NOT NULL
);

CREATE TABLE socks
(
sock_id SERIAL PRIMARY KEY,
color VARCHAR(50) NOT NULL,
cotton_part INT NOT NULL,
quantity BIGINT NOT NULL
);
