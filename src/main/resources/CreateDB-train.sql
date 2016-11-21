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

CREATE TABLE distance(sid1 INT NOT NULL ,
                      sid2 INT NOT NULL ,
                      time INT NOT NULL ,
  PRIMARY KEY (sid1, sid2),
  FOREIGN KEY (sid1) REFERENCES station(sid),
  FOREIGN KEY (sid2) REFERENCES station(sid));

CREATE TABLE train (tid VARCHAR(6) PRIMARY KEY NOT NULL ,
                    stratTime TIME NOT NULL ,
                    endTime TIME NOT NULL ,
                    startSid INT ,
                    endSid INT ,
  FOREIGN KEY (startSid) REFERENCES station(sid),
  FOREIGN KEY (endSid) REFERENCES station(sid));

CREATE TABLE traintime(sid INT NOT NULL ,
                  tid VARCHAR(6) NOT NULL ,
                  arriveTime TIME ,
                  departTime TIME ,
  PRIMARY KEY (sid, tid) ,
  FOREIGN KEY (sid) REFERENCES station(sid) ,
  FOREIGN KEY (tid) REFERENCES train(tid));