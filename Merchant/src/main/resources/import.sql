--DROP TABLE age;
--CREATE TABLE age (age_id VARCHAR(20), age_risk_value VARCHAR(20));
--
--insert into age(AGE_ID, AGE_RISK_VALUE) values (1,2.1);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (2,2.4);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (3,2.5);
--insert into age(AGE_ID, AGE_RISK_VALUE) values (4,1.1);

--DROP TABLE date_category;
--CREATE TABLE date_category (date_category_id INTEGER, end_date DATE, start_date DATE);

--INSERT INTO date_category (end_date, start_date) VALUES ('2017-10-11 00:00:00', '2014-10-11 00:00:00');
--INSERT INTO date_category (end_date, start_date) VALUES ('2016-10-11 00:00:00', '2013-10-11 00:00:00');

INSERT INTO risk_category (name) VALUES ('age');
INSERT INTO risk_category (name) VALUES ('region');
INSERT INTO risk_category (name) VALUES ('sumTo');
INSERT INTO risk_category (name) VALUES ('sport');

INSERT INTO risk_category (name) VALUES ('towing');
INSERT INTO risk_category (name) VALUES ('repairs');
INSERT INTO risk_category (name) VALUES ('accommodation');
INSERT INTO risk_category (name) VALUES ('alternativeRide');

INSERT INTO risk_category (name) VALUES ('surface');
INSERT INTO risk_category (name) VALUES ('ageApartment');
INSERT INTO risk_category (name) VALUES ('valueApartment');
INSERT INTO risk_category (name) VALUES ('disaster');

INSERT INTO language (language_name) VALUES ('English');
INSERT INTO language (language_name) VALUES ('Serbian');

INSERT INTO name_translate (name,language) VALUES ('to 18', 1);
INSERT INTO name_translate (name,language) VALUES ('do 18', 2);
INSERT INTO name_translate (name,language) VALUES ('18-60', 1);
INSERT INTO name_translate (name,language) VALUES ('18-60', 2);
INSERT INTO name_translate (name,language) VALUES ('over 60', 1);
INSERT INTO name_translate (name,language) VALUES ('preko 60', 2);
INSERT INTO name_translate (name,language) VALUES ('Europe', 1);
INSERT INTO name_translate (name,language) VALUES ('Evropa', 2);
INSERT INTO name_translate (name,language) VALUES ('Asia', 1);
INSERT INTO name_translate (name,language) VALUES ('Azija', 2);
INSERT INTO name_translate (name,language) VALUES ('North America', 1);
INSERT INTO name_translate (name,language) VALUES ('Severna Amerika', 2);
INSERT INTO name_translate (name,language) VALUES ('South America', 1);
INSERT INTO name_translate (name,language) VALUES ('Južna Amerika', 2);
INSERT INTO name_translate (name,language) VALUES ('Australia', 1);
INSERT INTO name_translate (name,language) VALUES ('Australija', 2);
INSERT INTO name_translate (name,language) VALUES ('Africa', 1);
INSERT INTO name_translate (name,language) VALUES ('Afrika', 2);
INSERT INTO name_translate (name,language) VALUES ('10.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('10.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('30.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('30.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('50.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('50.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('Rugby', 1);
INSERT INTO name_translate (name,language) VALUES ('Ragbi', 2);
INSERT INTO name_translate (name,language) VALUES ('Golf', 1);
INSERT INTO name_translate (name,language) VALUES ('Golf', 2);
INSERT INTO name_translate (name,language) VALUES ('Biking', 1);
INSERT INTO name_translate (name,language) VALUES ('Biciklizam', 2);

INSERT INTO name_translate (name,language) VALUES ('BEZVEZE', 1);
INSERT INTO name_translate (name,language) VALUES ('BEZVEZE2', 1);


INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,1);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,2);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,3);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,4);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,5);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (1,6);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,7);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,8);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,9);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,10);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,11);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,12);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,13);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,14);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,15);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,16);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,17);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (2,18);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,19);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,20);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,21);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,22);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,23);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (3,24);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,25);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,26);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,27);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,28);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,29);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,30);

INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,31);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,32);

INSERT INTO insurance_type (insurance_name,  insurance) VALUES ( 'Road Insurance', NULL);
INSERT INTO insurance_type (insurance_name, insurance) VALUES ('Home Insurance', NULL);

INSERT INTO pricelist (start_date) VALUES ('2016-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2017-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2015-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2014-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2019-3-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2012-11-11 00:00:00');



INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (2, 1, 1);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 2);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 3);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (1, 1, 4);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 5);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (5, 1, 6);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (10, 1, 7);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (5, 1, 8);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 9);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (2, 1, 10);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 11);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (6, 1, 12);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (10, 1, 13);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (14, 1, 14);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 15);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 16);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (8, 1, 17);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (12, 1, 18);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 19);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (6, 1, 20);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (9, 1, 21);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (7, 1, 22);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (14, 1, 23);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (21, 1, 24);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (5, 1, 25);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (10, 1, 26);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (15, 1, 27);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (2, 1, 28);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 29);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (7, 1, 30);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (2, 2, 31);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 2, 32);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 3, 3);

--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (8, 1, 31);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (10, 1, 32);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (11, 1, 33);
--
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (1, 1, 34);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 35);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (5, 1, 36);
--
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (6, 1, 37);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (12, 1, 38);
--INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 39);






--INSERT INTO payment (payment_id, merchant_id, merchant_order_id) VALUES (123, 666, 123);

INSERT INTO vehicle (registration_number, make, owner_first_name, owner_jmbg, owner_last_name, type,vin_number, year_of_production, insurance_type_id) VALUES ('SO232-JL', 'Ford', 'Pera', '1323241543312', 'Peric', 'Kola', '2132', 2005, 1);