drop database if exists school_db;
create database school_db;
use school_db;
create table student(
   roll int primary key,
   name varchar(20),
   marks int
);
insert into student values(1,'Rohit',90);
commit;
select * from student;