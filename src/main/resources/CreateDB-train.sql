CREATE DATABASE train;

USE train;

CREATE TABLE user (uid INT AUTO_INCREMENT PRIMARY KEY ,
                   username VARCHAR(30) NOT NULL UNIQUE KEY ,
                   password VARCHAR(20) NOT NULL ,
                   name VARCHAR(30) NOT NULL ,
                   IDType ENUM('1', '2', '3', '4') DEFAULT '1',
                   ID VARCHAR(18) NOT NULL ,
                   email VARCHAR(30),
                   telephone VARCHAR(20) NOT NULL ,
                   Passenger ENUM('1', '2', '3', '4') DEFAULT '1');

CREATE TABLE station (sid INT PRIMARY KEY AUTO_INCREMENT ,
                      sname VARCHAR(30) NOT NULL ,
                      province VARCHAR(30) NOT NULL ,
                      city VARCHAR(30) NOT NULL ,
                      latitude NUMERIC(12,5) ,
                      longitude NUMERIC(12,5));