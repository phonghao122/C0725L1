drop database if exists fean_food;
create database fean_food;
use fean_food;

-- ========== BẢNG USERS (Tài khoản đăng nhập) ==========
create table users(
    username varchar(50) primary key,
    `password` varchar(255) not null,
    `role` enum('customer', 'admin') not null default 'customer',
    is_active bit default 1,
    created_at timestamp default current_timestamp
);

-- ========== BẢNG CUSTOMERS ==========
create table customers (
    customer_id int primary key auto_increment,
    name varchar(100) not null,
    gender enum('male', 'female', 'other'),
    dob date,
    email varchar(100) unique not null,
    phone varchar(20),
    username varchar(50),
    created_at timestamp default current_timestamp,
    foreign key (username) references users(username)
);

-- ========== QUẢN LÝ SẢN PHẨM ==========
create table categories(
    id int primary key auto_increment,
    name varchar(50) not null
);

create table products(
    id int primary key auto_increment,
    name varchar(100) not null,
    price decimal(10,2) not null check (price >= 0),
    description text,
    img varchar(255),
    is_available bit default 1,
    category_id int not null,
    created_at timestamp default current_timestamp,
    foreign key (category_id) references categories(id)
);

-- ========== KHUYẾN MÃI ==========
create table sales(
    id int primary key auto_increment,
    name varchar(100) not null,
    discount_type enum('PERCENT', 'AMOUNT') not null,
    discount_value decimal(10,2) not null check (discount_value >= 0),
    start_date date not null,
    end_date date not null,
    is_active bit default 1,
    check (end_date >= start_date)
);

create table sales_products(
    sale_id int,
    product_id int,
    quantity int,
    primary key (sale_id, product_id),
    foreign key (sale_id) references sales(id) on delete cascade,
    foreign key (product_id) references products(id)
);

-- ========== THANH TOÁN & GIAO HÀNG ==========
create table payment_methods(
    id int primary key auto_increment,
    name varchar(100) not null,
    is_active bit default 1
);

create table delivery_informations(
    id int primary key auto_increment,
    customer_id int not null,
    phone varchar(20) not null,
    address text not null,
    is_default bit default 0,
    foreign key (customer_id) references customers(customer_id) on delete cascade
);

-- ========== ĐƠN HÀNG ==========
create table orders(
    id int primary key auto_increment,
    order_date datetime default current_timestamp,
    customer_id int not null,
    delivery_information_id int not null,
    payment_method_id int not null,
    order_status enum('pending', 'confirmed', 'preparing', 'ready', 'completed', 'cancelled') default 'pending',
    total_amount decimal(10,2) not null,
    note text,
    
    foreign key (customer_id) references customers(customer_id),
    foreign key (delivery_information_id) references delivery_informations(id),
    foreign key (payment_method_id) references payment_methods(id)
);

-- ========== CHI TIẾT ĐƠN HÀNG ==========
create table order_details(
    order_id int,
    product_id int,
    quantity int not null check (quantity > 0),
    unit_price decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    
    primary key (order_id, product_id),
    foreign key (order_id) references orders(id) on delete cascade,
    foreign key (product_id) references products(id)
);

-- Insert Users
insert into users (username, `password`, role) values 
('customer1', '$2a$10$hash1',  'customer'),
('customer2', '$2a$10$hash2',  'customer'),
('admin', '$2a$10$hashadmin', 'admin');

-- Insert Customers
insert into customers ( name, gender, dob,email, phone, username) values 
('Nguyễn Văn A', 'male', '1995-05-15','customer1@email.com', '0901234567', 'customer1'),
('Trần Thị B', 'female', '1998-08-20', 'customer2@email.com', '0907654321', 'customer2'),
('Trần Thị C', 'male', '1998-08-20', 'admin@email.com', '0907654311', 'admin');

-- Insert Categories
insert into categories (name) values 
('Burger'),
('Gà rán'),
('Khoai tây chiên'),
('Đồ uống');

-- Insert Products
insert into products (name, price, description, img, is_available, category_id) values 
('Burger Bò Phô Mai', 45000, 'Burger bò nướng + phô mai cheddar', 'burger_beef.jpg', 1, 1),
('Burger Gà Giòn', 40000, 'Burger gà giòn + rau xà lách', 'burger_chicken.jpg', 1, 1),
('Gà Rán 2 Miếng', 70000, 'Gà giòn truyền thống - 2 miếng', 'fried_chicken.jpg', 1, 2),
('Khoai Tây Chiên (M)', 25000, 'Khoai tây chiên giòn', 'fries.jpg', 1, 3),
('Pepsi (M)', 15000, 'Nước ngọt Pepsi', 'pepsi.jpg', 1, 4),
('Coca Cola (M)', 15000, 'Nước ngọt Coca', 'coca.jpg', 1, 4);

-- Insert Payment Methods
insert into payment_methods (name, is_active) values 
('Tiền mặt (COD)', 1),
('Chuyển khoản ngân hàng', 1),
('Ví MoMo', 1);

-- Insert Delivery Informations
insert into delivery_informations (customer_id, phone, address, is_default) values 
(1, '0901234567', '123 Lê Lợi, Quận 1, TP.HCM', 1),
(2, '0907654321', '789 Trần Hưng Đạo, Quận 5, TP.HCM', 1);

-- Insert Sales
insert into sales (name, discount_type, discount_value, start_date, end_date, is_active) values 
('Flash Sale Burger', 'PERCENT', 30, '2025-01-20', '2025-01-31', 1),
('Giảm Giá Đồ Uống', 'AMOUNT', 5000, '2025-01-15', '2025-02-15', 1);

-- Insert Sales Products
insert into sales_products (sale_id, product_id, quantity) values 
(1, 1,20), (1, 2,10),
(2, 5,50), (2, 6, 30);

-- Insert Sample Order
insert into orders (customer_id, delivery_information_id, payment_method_id, order_status, total_amount, note) values 
(1, 1, 1, 'completed', 135000, 'Giao nhanh giúp em');

-- Insert Order Details
insert into order_details (order_id, product_id, quantity, unit_price, subtotal) values 
(1, 1, 2, 45000, 90000),  -- 2 Burger Bò
(1, 5, 3, 15000, 45000);  -- 3 Pepsi