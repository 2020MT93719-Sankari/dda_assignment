drop database if exists DDA_ASSIGN;
create database DDA_ASSIGN;

USE DDA_ASSIGN;

CREATE TABLE `plan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `amount` int NOT NULL,
  `validity_days` int NOT NULL,
  `type` varchar(10)  NOT NULL,
 `data` int,
  PRIMARY KEY (`id`));
  
 CREATE TABLE `state_country` (
   `pin_code` varchar(255) NOT NULL,
   `city` varchar(255) DEFAULT NULL,
   `state` varchar(255) DEFAULT NULL,
   `country` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`pin_code`));

  CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `pin_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pin_code`) REFERENCES `state_country` (`pin_code`));
  
CREATE TABLE `customer_plans` (
`customer_id` bigint,
`plan_id` bigint,
`subscribed_on` date,
`expire_on` date,
`data_remaining` double,
  PRIMARY KEY (`customer_id`, `plan_id`),
  FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`));
  
  
insert into plan (amount, name, validity_days, type)
values(80, "landline_recharge1", 49, "landline"), (160, "landline_recharge2", 98, "landline");
insert into plan (amount, name, validity_days, type, data)
values(100, "31Days_Pack", 31, "mobile",46.5), (5, "1GB_Data", 10, "data",1), (175, "64Days_Pack", 64, "mobile",92), (10, "2.5GB_Data", 15, "data",2.5);;

insert into state_country(pin_code, city, country, state)
values ("600100", "Kanchipuram", "India", "TamilNadu"),("400090", "Mumbai", "India", "Maharashtra"),("263001", "Nainital", "India", "Uattarakhand");

insert into customer(email_id, name, street_name, pin_code) 
values ("test@123.com" , "Pranav", "AnaikaraiSteet", "600100"),("frodo@123.com" , "Frodo", "Carter Road", "600100"),
("samwise@123.com" , "Samwise", "Khurpatal", "263001");

insert into customer_plans(customer_id, plan_id, subscribed_on, expire_on) values (1,1, "2022-02-20", "2022-04-10"), (3,1, "2020-02-20", "2022-06-10");
insert into customer_plans(customer_id, plan_id, subscribed_on, expire_on, data_remaining) 
values (1,2, "2022-04-01", "2022-05-01", 20),
(2,1, "2021-04-01", "2022-05-01", 20),(2,3, "2022-04-11", "2022-04-16", 0.5), (1,4, "2022-01-01", "2022-04-03", 0), (1,4, "2022-01-01", "2022-04-03", 0);

DELIMITER &&
CREATE PROCEDURE GET_CUSTOMER_PLAN_COUNT ()
BEGIN
    select customer_id, plan_id, count(*) as count from customer_plans group by plan_id order by plan_id;
END &&

call GET_CUSTOMER_PLAN_COUNT();
