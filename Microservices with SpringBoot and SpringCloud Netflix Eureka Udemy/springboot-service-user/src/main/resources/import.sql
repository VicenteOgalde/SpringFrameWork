INSERT INTO users (username, password, enabled,name,surname,email) VALUES('user1', '$2a$10$ZhCOIYJBHxHsqRz/0JWNde9V/ukKuJhwRJfT5IWx4YqFQESLAjv7a', 1,'user10','user11','asd@asd.cl');
INSERT INTO users (username, password, enabled,name,surname,email) VALUES('user2', '$2a$10$e8VNN4S2EPTS25P.yveoaOJs/3h4w4DqbLbkewPDmQnnwVrigv5ky', 1,'user20','user21','asd2@asd.cl');

INSERT INTO roles (name) VALUES('ROLE_ADMIN');
INSERT INTO roles (name) VALUES('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES( 1,1);
INSERT INTO users_roles (user_id, role_id) VALUES( 2,2);
INSERT INTO users_roles (user_id, role_id) VALUES( 1,2);
