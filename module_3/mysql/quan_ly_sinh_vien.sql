create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table james(
 username varchar(50) primary key,
 `password` varchar(50)
 );
 
  create table classes(
  id int primary key auto_increment,
 `name` varchar(50)
 );
create table students(
  id int primary key auto_increment,
 `name` varchar(50),
 birthday date,
 gender boolean,
 email varchar(50),
 score float,
 username varchar(50),
 class_id int,
 foreign key(username) references james(username),
 foreign key(class_id) references classes(id)
 );
   create table phones(
    phone_number varchar(20) primary key,
    student_id int,
	foreign key(student_id) references students(id)
 );
 
 create table instructors(
  id int primary key auto_increment,
 `name` varchar(50),
 birthday date,
 salary float
 );
 
  create table instructor_class(
  class_id int,
  instructor_id int,
  primary key(class_id,instructor_id),
  start_day date,
  end_day date,
  foreign key(class_id) references classes(id),
  foreign key(instructor_id) references instructors(id)
 );
 
insert into classes (name) values ('c1121g1'), ('c1221g1'),('a0821i1'),('a0921i1');

insert into james(`username`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into james(`username`,`password`)
 values('chau','12345');
 
insert into instructors(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructors(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);


 
 insert into students(`name`,birthday, gender,`score`, class_id,`username`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');

  insert into students(`name`,birthday, gender,`score`, class_id) 
 values ('nguyen van a','1981-12-12',1,8,null),('tran van b','1981-12-12',1,5,null);
 
--   insert into student(`name`,birthday, gender,`point`, class_id,`username`) 
--  values ('nguyen minh hai chau','1981-12-12',1,8,null,'chau');
 insert into phones(phone_number,student_id) 
 values('0905973141',1),('0905973142',1),
 ('0905973143',2),('0905973144',2),
 ('090597345',3),('0905973146',4),
 ('0905973147',5),('0905973148',6),
 ('0905973149',7),('0905973150',8),
 ('0905973151',9),('0905973152',10);
 
 insert into instructor_class(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

select * from students s where s.`name` like 'h%';
update students
set class_id = 2
where name like '%hung';

select * from students
order by score desc, name asc;

