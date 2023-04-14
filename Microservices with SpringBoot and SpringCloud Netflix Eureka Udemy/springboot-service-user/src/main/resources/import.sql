INSERT INTO users (username, password, enabled,name,surname,email) VALUES('user1', '123', 1,'user10','user11','asd@asd.cl');
INSERT INTO users (username, password, enabled,name,surname,email) VALUES('user2', '123', 1,'user20','user21','asd2@asd.cl');

INSERT INTO roles (name) VALUES('ROLE_ADMIN');
INSERT INTO roles (name) VALUES('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES( 1,2);
INSERT INTO users_roles (user_id, role_id) VALUES( 2,1);
INSERT INTO users_roles (user_id, role_id) VALUES( 2,2);
