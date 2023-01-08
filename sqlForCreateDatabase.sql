create database if not exists mybatis;
use mybatis;
SELECT DATABASE();
show tables;
drop table if exists records;
CREATE TABLE records(
id int primary key auto_increment,
firstName varchar(20),
lastNAme varchar(20),
email VARCHAR(40),
phone VARCHAR(20)
);

insert into records (firstName, lastName,email,phone)
VALUES
('David','Platt','david.platt@corrie.co.uk','01913478234');
SELECT * FROM records;