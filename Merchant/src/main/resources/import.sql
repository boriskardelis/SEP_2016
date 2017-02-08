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

INSERT INTO risk_category (name) VALUES ('Age');
INSERT INTO risk_category (name) VALUES ('Region');
INSERT INTO risk_category (name) VALUES ('Sum insured');
INSERT INTO risk_category (name) VALUES ('Sport');

INSERT INTO risk_category (name) VALUES ('Towing');
INSERT INTO risk_category (name) VALUES ('Repairs');
INSERT INTO risk_category (name) VALUES ('Accommodation');
INSERT INTO risk_category (name) VALUES ('Alternative ride');

INSERT INTO risk_category (name) VALUES ('Surface');
INSERT INTO risk_category (name) VALUES ('Age apartment');
INSERT INTO risk_category (name) VALUES ('Value apartment estimated');
INSERT INTO risk_category (name) VALUES ('Insured disaster');

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
INSERT INTO name_translate (name,language) VALUES ('20km', 1);
INSERT INTO name_translate (name,language) VALUES ('20km', 2);
INSERT INTO name_translate (name,language) VALUES ('100km', 1);
INSERT INTO name_translate (name,language) VALUES ('100km', 2);
INSERT INTO name_translate (name,language) VALUES ('300km', 1);
INSERT INTO name_translate (name,language) VALUES ('300km', 2);
INSERT INTO name_translate (name,language) VALUES ('500 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('500 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('1.500 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('1.500 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('3.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('3.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('7 days', 1);
INSERT INTO name_translate (name,language) VALUES ('7 dana', 2);
INSERT INTO name_translate (name,language) VALUES ('14 days', 1);
INSERT INTO name_translate (name,language) VALUES ('14 dana', 2);
INSERT INTO name_translate (name,language) VALUES ('28 days', 1);
INSERT INTO name_translate (name,language) VALUES ('28 dana', 2);
INSERT INTO name_translate (name,language) VALUES ('Taxi', 1);
INSERT INTO name_translate (name,language) VALUES ('Taksi', 2);
INSERT INTO name_translate (name,language) VALUES ('Van', 1);
INSERT INTO name_translate (name,language) VALUES ('Kombi', 2);
INSERT INTO name_translate (name,language) VALUES ('Truck', 1);
INSERT INTO name_translate (name,language) VALUES ('Kamion', 2);
INSERT INTO name_translate (name,language) VALUES ('to 30m2', 1);
INSERT INTO name_translate (name,language) VALUES ('do 30m2', 2);
INSERT INTO name_translate (name,language) VALUES ('30m2 - 80m2', 1);
INSERT INTO name_translate (name,language) VALUES ('30m2 - 80m2', 2);
INSERT INTO name_translate (name,language) VALUES ('over 80m2', 1);
INSERT INTO name_translate (name,language) VALUES ('preko 80m2', 2);
INSERT INTO name_translate (name,language) VALUES ('to 10 years', 1);
INSERT INTO name_translate (name,language) VALUES ('do 10 godina', 2);
INSERT INTO name_translate (name,language) VALUES ('10 - 20 years', 1);
INSERT INTO name_translate (name,language) VALUES ('10 - 20 godina', 2);
INSERT INTO name_translate (name,language) VALUES ('over 20 years', 1);
INSERT INTO name_translate (name,language) VALUES ('preko20 godina', 2);
INSERT INTO name_translate (name,language) VALUES ('10.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('10.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('40.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('40.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('80.000 EUR', 1);
INSERT INTO name_translate (name,language) VALUES ('80.000 EUR', 2);
INSERT INTO name_translate (name,language) VALUES ('Flood', 1);
INSERT INTO name_translate (name,language) VALUES ('Poplava', 2);
INSERT INTO name_translate (name,language) VALUES ('Fire', 1);
INSERT INTO name_translate (name,language) VALUES ('Požar', 2);
INSERT INTO name_translate (name,language) VALUES ('Thievery', 1);
INSERT INTO name_translate (name,language) VALUES ('Pljačka', 2);

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
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,31);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,32);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,33);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,34);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,35);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (5,36);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,37);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,38);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,39);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,40);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,41);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (6,42);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,43);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,44);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,45);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,46);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,47);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (7,48);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,49);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,50);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,51);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,52);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,53);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (8,54);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,55);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,56);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,57);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,58);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,59);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (9,60);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,61);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,62);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,63);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,64);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,65);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (10,66);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,67);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,68);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,69);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,70);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,71);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (11,72);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,73);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,74);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,75);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,76);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,77);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (12,78);

INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,79);
INSERT INTO risk_subcategory (risk_category, name_translate) VALUES (4,80);

INSERT INTO insurance_type (insurance_name,  insurance) VALUES ( 'Road Insurance', NULL);
INSERT INTO insurance_type (insurance_name, insurance) VALUES ('Home Insurance', NULL);

INSERT INTO pricelist (start_date) VALUES ('2016-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2017-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2015-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2014-10-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2019-3-11 00:00:00');
INSERT INTO pricelist (start_date) VALUES ('2012-11-11 00:00:00');


--Age
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (2, 1, 1);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (3, 1, 2);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (4, 1, 3);
--region
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

INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 40);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 41);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 42);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 43);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 44);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 45);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 46);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 47);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 48);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 49);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 50);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 51);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 52);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 53);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 54);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 55);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 56);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 57);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 58);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 59);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 60);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 61);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 62);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 63);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 64);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 65);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 66);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 67);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 68);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 69);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 70);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 71);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 72);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 73);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 74);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 75);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 76);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 77);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 1, 78);
--bezveze
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 2, 79);
INSERT INTO pricelist_item (coefficient, pricelist, risk_subcategory) VALUES (18, 2, 80);

--INSERT INTO payment (payment_id, merchant_id, merchant_order_id) VALUES (123, 666, 123);
