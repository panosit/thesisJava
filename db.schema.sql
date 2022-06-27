create database sys;
use sys;

CREATE TABLE `user`(
            `username` varchar(50) NOT NULL,
            `password` varchar(100) NOT NULL,
            `enabled` tinyint(1) NOT NULL,
            PRIMARY KEY (`username`)
);

insert into user values('admin','$2a$12$POuiwCEf8a43wa6eut9AA.Sxr7I6NK8U2V.DRBsFO2RS27Qt0KJwi',1);

CREATE TABLE `authorities`(
          `username` varchar(50) NOT NULL,
         `authority` varchar(50) NOT NULL,
        UNIQUE KEY `ix_auth_username` (`username`,`authority`),
        CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
);

insert into authorities values('admin','ROLE_ADMIN');

CREATE TABLE LECTURE(
        LECTURE_ID INT NOT NULL AUTO_INCREMENT,
        date DATE,
        LESSON VARCHAR(40),
        STARTING_HOUR VARCHAR(20),
        ENDING_HOUR VARCHAR(20),
        AMPHITHEATER VARCHAR(30),
        LESSON_TYPE VARCHAR(30),
        PROFESSOR VARCHAR(30),
        PRIMARY KEY(LECTURE_ID)
);

CREATE TABLE STUDENTPOSITION(
        ID INT NOT NULL AUTO_INCREMENT,
        USERNAME VARCHAR(50) NOT NULL,
        LECTURE_ID INT NOT NULL,
        POSITION_NUMBER VARCHAR(10) NOT NULL,
        PRIMARY KEY(ID),
        FOREIGN KEY (USERNAME) REFERENCES USER(USERNAME),
        FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE(LECTURE_ID)
);

CREATE TABLE CovidCase(
        CASE_ID INT NOT NULL AUTO_INCREMENT,
        USERNAME VARCHAR(50) NOT NULL,
        DATE DATE,
        PRIMARY KEY(CASE_ID),
        FOREIGN KEY (USERNAME) REFERENCES USER(USERNAME)
);