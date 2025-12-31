create database if not exists erd_sang_table;
use erd_sang_table;
create table suppliers(
id int primary key auto_increment,
`name` varchar(100),
address varchar(200)
);
create table phones(
phone_number varchar(12) primary key,
supplier_id int,
foreign key (supplier_id) references suppliers(id)
);
create table orders(
id int primary key auto_increment,
order_date date
);
create table materials(
id int primary key auto_increment,
`name` varchar(100)
);
create table materials_orders(
material_id int,
order_id int,
foreign key(material_id) references materials(id),
foreign key(order_id) references orders(id),
primary key(material_id,order_id)
);
create table sales_receipts(
id int primary key auto_increment,
sales_date date
);
create table sales_receipts_materials(
material_id int,
sales_receipt_id int,
price double,
quantity int,
foreign key(material_id) references materials(id),
foreign key(sales_receipt_id) references sales_receipts(id),
primary key(material_id,sales_receipt_id)
);
create table import_receipts(
id int primary key auto_increment,
import_date date
);
create table import_receipts_materials(
material_id int,
import_receipt_id int,
price double,
quantity int,
foreign key(material_id) references materials(id),
foreign key(import_receipt_id) references import_receipts(id),
primary key(material_id,import_receipt_id)
);
