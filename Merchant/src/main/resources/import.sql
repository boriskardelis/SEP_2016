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



INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('to 18', 'do 18', 1);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('18-60', '18-60', 1);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('over 60','preko 60', 1);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Europe','Evropa', 2);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Asia', 'Azija', 2);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('North America', 'Severna Amerika', 2);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('South America', 'Južna Amerika', 2);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Australia', 'Australija', 2);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Africa','Afrika', 2);


INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('10.000 EUR', '10.000 EUR', 3);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('50.000 EUR', '50.000 EUR', 3);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('150.000 EUR', '150.000 EUR', 3);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Rugby', 'Ragbi', 4);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Golf', 'Golf', 4);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Biking', 'Biciklizam', 4);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('20km','20km', 5);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('100km','100km', 5);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('300km', '300km', 5);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('500 EUR', '500 EUR', 6);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('1.500 EUR', '1.500 EUR', 6);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('3.000 EUR', '3.000 EUR', 6);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('7 days', '7 dana', 7);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('14 days', '14 dana', 7);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('28 days', '28 dana', 7);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Taxi', 'Taksi', 8);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Van', 'Kombi', 8);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Truck', 'Kamion', 8);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('to 30m2', 'do 30m2', 9);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('30m2 - 80m2', '30m2 - 80m2', 9);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('over 80m2', 'preko 80m2', 9);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('to 10 years', 'do 10 godina', 10);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('10 - 20 years', '10 - 20 godina', 10);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('over 20 years', 'preko20 godina', 10);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('10.000 EUR', '10.000 EUR', 11);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('40.000 EUR', '40.000 EUR', 11);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('80.000 EUR', '80.000 EUR', 11);

INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Flood', 'Poplava', 12);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Fire', 'Požar', 12);
INSERT INTO risk_subcategory (name, name_serbian, risk_category) VALUES ('Thievery', 'Pljačka', 12);


INSERT INTO insurance_type (insurance_name,  insurance) VALUES ( 'Road Insurance', NULL);
INSERT INTO insurance_type (insurance_name, insurance) VALUES ('Home Insurance', NULL);

INSERT INTO pricelist (start_date) VALUES ('2016-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2017-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2015-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2014-10-11 00:00:00');

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

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (8, 1, 31);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (10, 1, 32);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (11, 1, 33);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (1, 1, 34);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 35);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (5, 1, 36);

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (6, 1, 37);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (12, 1, 38);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 39);


--INSERT INTO payment (payment_id, merchant_id, merchant_order_id) VALUES (123, 666, 123);

INSERT INTO vehicle (registration_number, make, owner_first_name, owner_jmbg, owner_last_name, type,vin_number, year_of_production, insurance_type_id) VALUES ('SO232-JL', 'Ford', 'Pera', '1323241543312', 'Peric', 'Kola', '2132', 2005, 1);



