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
INSERT INTO customers (customer_id, customer_name, customer_age)
VALUES
(1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha', 50);
INSERT INTO `orders` (order_id, customer_id, order_date, order_total_price)
VALUES
(1, 1, '2006-03-21', NULL),
(2, 2, '2006-03-23', NULL),
(3, 1, '2006-03-16', NULL);
INSERT INTO products (product_id, product_name, product_price)
VALUES
(1, 'May Giat', 3),
(2, 'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat', 1),
(5, 'Bep Dien', 2);
INSERT INTO order_details (order_id, product_id, order_detail_quantity)
VALUES
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);

select order_id, order_date, order_total_price from orders;

select o.order_id, c.customer_id, c.customer_name, o.order_date, p.product_name, p.product_price, o.order_total_price
from customers c inner join orders o on c.customer_id = o.customer_id
inner join order_details od on o.order_id = od.order_id
inner join products p on p.product_id = od.product_id;

select c.customer_id, c.customer_name
from customers c left join orders o on c.customer_id = o.customer_id
where o.customer_id is null;

select o.order_id, c.customer_id, c.customer_name,
o.order_date, p.product_name, p.product_price,od.order_detail_quantity, (od.order_detail_quantity * p.product_price) order_total_price
from customers c inner join orders o on c.customer_id = o.customer_id
inner join order_details od on o.order_id = od.order_id
inner join products p on p.product_id = od.product_id;