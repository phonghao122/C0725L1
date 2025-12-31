create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customers(
customer_id int primary key auto_increment,
customer_name varchar(100),
customer_age int
);
create table orders(
order_id int primary key auto_increment,
customer_id int,
order_date date,
order_total_price double,
foreign key(customer_id) references customers(customer_id)
);
create table products(
product_id int primary key auto_increment,
product_name varchar(100),
product_price double
);
create table order_details(
order_id int,
product_id int,
order_detail_quantity int,
foreign key(order_id) references orders(order_id),
foreign key(product_id) references products(product_id),
primary key(product_id,order_id)
);