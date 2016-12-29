INSERT INTO account (account_number, account_balance) VALUES ('503-0000200103212-03', 1500);
INSERT INTO account (account_number, account_balance) VALUES ('530-0000200103212-03', 20000);
INSERT INTO account (account_number, account_balance) VALUES ('528-0000200103212-03', 300);

INSERT INTO card (month, year, pan, security_code, account) VALUES ('12', '2016', 1234567891, 123, 1);
INSERT INTO card (month, year, pan, security_code, account) VALUES ('11', '2017', 1234567892, 123, 2);
INSERT INTO card (month, year, pan, security_code, account) VALUES ('11', '2018', 1234567893, 123, 3);

INSERT INTO merchant (merchant_id, merchant_password, account_id) values ('chuck', 'norris', 1);
INSERT INTO merchant (merchant_id, merchant_password, account_id) values ('texas', 'ranger', 2);
INSERT INTO merchant (merchant_id, merchant_password, account_id) values ('neki', 'tamo', 3);

--dodati paymentRequest i paymentUrlAndId za testiranje da ne mora svaki put da se popunjava osiguranje

INSERT INTO payment_url_and_id (payment_id, payment_url) values (300, 'http://localhost:7070/payment?paymentId=300');
INSERT INTO payment_url_and_id (payment_id, payment_url) values (500, 'http://localhost:7070/payment?paymentId=500');

--- ovo ne radi
INSERT INTO payment_request (amount, merchant_id, merchant_order_id, merchan_password, payment_url_and_id) values (152, 'chuck', 300, 'norris', 1);
INSERT INTO payment_request (amount, merchant_id, merchant_order_id, merchan_password, payment_url_and_id) values (399, 'chuck', 500, 'norris', 2);