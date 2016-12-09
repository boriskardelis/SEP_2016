--DROP TABLE age;
--CREATE TABLE age (age_id VARCHAR(20), age_risk_value VARCHAR(20));
--
--insert into age(AGE_ID, AGE_RISK_VALUE) values (1,2.1);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (2,2.4);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (3,2.5);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (4,1.1);

--DROP TABLE date_category;
--CREATE TABLE date_category (date_category_id INTEGER, end_date DATE, start_date DATE);

INSERT INTO date_category (date_category_id, end_date, start_date) VALUES (1, '2017-10-11 00:00:00', '2014-10-11 00:00:00');
INSERT INTO date_category (date_category_id, end_date, start_date) VALUES (2, '2016-10-11 00:00:00', '2013-10-11 00:00:00');

INSERT INTO risk_category (risk_category_id, name, date_category) VALUES (1, 'age', 1);
INSERT INTO risk_category (risk_category_id, name, date_category) VALUES (2, 'region', 2);

INSERT INTO risk_subcategory (risk_subcategory_id, coefficient, name, risk_category) VALUES (1, 2, 'to 18', 1);
INSERT INTO risk_subcategory (risk_subcategory_id, coefficient, name, risk_category) VALUES (2, 4, '18-36', 1);
INSERT INTO risk_subcategory (risk_subcategory_id, coefficient, name, risk_category) VALUES (3, 6, 'from 36', 1);

INSERT INTO risk_subcategory (risk_subcategory_id, coefficient, name, risk_category) VALUES (4, 1, 'Europe', 2);
INSERT INTO risk_subcategory (risk_subcategory_id, coefficient, name, risk_category) VALUES (5, 3, 'Asia', 2);
