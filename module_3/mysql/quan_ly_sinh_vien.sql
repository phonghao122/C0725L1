create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
id int primary key auto_increment,
name varchar(150)
);
create table teacher(
id int primary key auto_increment,
name varchar(150),
age int,
country varchar(100)
);

