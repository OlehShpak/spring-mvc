



INSERT INTO users VALUES ('admin', 'email@mail.com', TRUE, 'fullname', '$2a$10$.V2BUCfNPNIo3Cn1006T1.8cAmmfPwyIjaXOOlqlhYZ8TKmfMiDEa', '12348888', 'admin'   );

INSERT INTO user_roles VALUES (1, 'ROLE_USER', 'admin');

INSERT INTO employee_tasks VALUES (2, TRUE, 'admin','2015-01-15','Its task number 1', 'fullname');
INSERT INTO employee_tasks VALUES (3, TRUE, 'admin','2015-01-15','Its task number 2', 'fullname');
INSERT INTO employee_tasks VALUES (4, TRUE, 'admin','2015-01-15','Its task number 3', 'fullname');
INSERT INTO employee_tasks VALUES (5, TRUE, 'admin','2015-01-15','Its task number 4', 'fullname');
INSERT INTO employee_tasks VALUES (6, TRUE, 'admin','2015-01-15','Its task number 5', 'fullname');
INSERT INTO employee_tasks VALUES (7, TRUE, 'admin','2015-01-15','Its task number 6', 'fullname');

INSERT INTO customers VALUES (8, 'Beijing', 'Angela', 'China', 'm@m.com', 'Sinopec Group', 'info', '1234','Sinopec Group', 'street', 'zip' );
INSERT INTO customers VALUES (9, 'Arkansas', 'Angela', 'USA', 'm@m.com', 'Wal-Mart Stores, Inc', 'info', '1234','Wal-Mart', 'street', 'zip' );
INSERT INTO customers VALUES (10, 'London', 'Angela', 'England', 'm@m.com', 'Royal Dutch Shell', 'info', '1234','Royal Dutch Shell', 'street', 'zip' );
INSERT INTO customers VALUES (11, 'Texas', 'Angela', 'USA', 'm@m.com', 'ExxonMobil', 'info', '1234','ExxonMobil', 'street', 'zip' );
INSERT INTO customers VALUES (12, 'London', 'Angela', 'China', 'm@m.com', 'BP', 'info', '1234','BP', 'street', 'zip' );

INSERT INTO deals VALUES (13, '2015-01-16', 'BP', '2015-01-30', 'Its description for deal 1', 'admin', 1000.00, 12 );
INSERT INTO deals VALUES (14, '2015-01-01', 'BP', '2015-01-29', 'Its description for deal 2', 'admin', 5000.00, 12 );
INSERT INTO deals VALUES (15, '2015-01-20', 'BP', '2015-01-28', 'Its description for deal 3', 'admin', 2000.00, 12 );
INSERT INTO deals VALUES (16, '2015-01-10', 'BP', '2015-01-30', 'Its description for deal 4', 'admin', 3000.00, 12 );
INSERT INTO deals VALUES (17, '2015-01-02', 'BP', '2015-01-30', 'Its description for deal 5', 'tester', 4000.00, 12 );
INSERT INTO deals VALUES (18, '2015-01-02', 'Wal-Mart', '2015-01-30', 'Its description for deal 6', 'tester', 3000.55, 9 );
INSERT INTO deals VALUES (19, '2015-01-02', 'Wal-Mart', '2015-01-27', 'Its description for deal 7', 'admin', 2000.77, 9);
INSERT INTO deals VALUES (20, '2015-01-02', 'Wal-Mart', '2015-01-28', 'Its description for deal 8', 'admin', 1000.13, 9 );
INSERT INTO deals VALUES (21, '2015-01-02', 'Sinopec Group', '2015-01-30', 'Its description for deal 9', 'tester', 1500.00, 8 );