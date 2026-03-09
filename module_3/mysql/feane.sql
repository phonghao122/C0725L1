drop database if exists fean_food;
create database fean_food;
use fean_food;

-- ========== BẢNG USERS (Tài khoản đăng nhập) ==========
create table users(
    username varchar(50) primary key,
    `password` varchar(255) not null,
    `role` enum('USER', 'ADMIN') not null default 'USER',
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


-- ========== THANH TOÁN & GIAO HÀNG ==========
create table payment_methods(
    id int primary key auto_increment,
    name varchar(100) not null,
    is_active bit default 1
);

create table delivery_informations(
    id int primary key auto_increment,
    customer_id int not null,
    `name` varchar(100),
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
    address_id int not null,
    payment_method_id int not null,
    sales_id int not null,
    order_status enum('PENDING', 'CONFIRMED', 'PREPARING', 'READY', 'COMPLETED', 'CANCELLED') default 'PENDING',
    total_amount decimal(10,2) not null,
    note text,
    foreign key (customer_id) references customers(customer_id),
    foreign key (payment_method_id) references payment_methods(id),
    foreign key (address_id) references delivery_informations(id),
    foreign key (sales_id) references sales(id)
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

-- ========== CHI TIẾT GIỎ HÀNG ==========
create table cart_items (
    id int primary key auto_increment,
    customer_id int not null,
    product_id int not null,
    quantity int not null default 1 check (quantity > 0),
    added_at timestamp default current_timestamp,
    foreign key (customer_id) references customers(customer_id) on delete cascade,
    foreign key (product_id) references products(id) on delete cascade,
    unique key uq_cart (customer_id, product_id)
);

insert into users(username, `password`, `role`)
values
('admin', 'admin123', 'ADMIN'),
('khach01', '123456', 'USER'),
('khach02', '123456', 'USER');

insert into customers(name, gender, dob, email, phone, username)
values
('Nguyễn Văn A', 'male', '2000-05-12', 'a@gmail.com', '0901111111', 'khach01'),
('Trần Thị B', 'female', '2001-08-20', 'b@gmail.com', '0902222222', 'khach02');


insert into categories(name)
values
('Gà rán'),
('Hamburger'),
('Khoai tây & Ăn kèm'),
('Nước uống');

insert into products(name, price, description, img, category_id)
values
-- Gà rán
('Gà rán giòn cay', 35000, 'Gà rán cay giòn', 'ga_gion_cay.jpg', 1),
('Gà rán truyền thống', 33000, 'Gà rán vị truyền thống', 'ga_truyen_thong.jpg', 1),

-- Hamburger
('Hamburger bò', 45000, 'Burger bò phô mai', 'burger_bo.jpg', 2),
('Hamburger gà', 42000, 'Burger gà giòn', 'burger_ga.jpg', 2),

-- Ăn kèm
('Khoai tây chiên', 25000, 'Khoai tây chiên giòn', 'khoai_tay.jpg', 3),

-- Nước uống
('Coca Cola', 15000, 'Nước ngọt Coca', 'coca.jpg', 4),
('Pepsi', 15000, 'Nước ngọt Pepsi', 'pepsi.jpg', 4);

insert into sales(name, discount_type, discount_value, start_date, end_date)
values
('Giảm 10%', 'PERCENT', 10, '2026-01-01', '2026-12-31'),
('Giảm 20.000đ', 'AMOUNT', 20000, '2026-01-01', '2026-06-30');

insert into payment_methods(name)
values
('Tiền mặt'),
('Chuyển khoản'),
('Ví điện tử');

insert into delivery_informations(customer_id, `name`, phone, address, is_default)
values
(1, 'Nguyễn Văn A', '0901111111', '123 Lê Lợi, Quận 1, TP.HCM', 1),
(2, 'Trần Thị B', '0902222222', '456 Nguyễn Trãi, Quận 5, TP.HCM', 1);

insert into orders(customer_id, address_id, payment_method_id, sales_id, total_amount)
values
(1, 1, 1, 1, 113000),
(2, 2, 2, 2, 83000);


-- Đơn hàng 1
insert into order_details(order_id, product_id, quantity, unit_price, subtotal)
values
(1, 1, 2, 35000, 70000),
(1, 5, 1, 25000, 25000),
(1, 6, 1, 15000, 15000);

-- Đơn hàng 2
insert into order_details(order_id, product_id, quantity, unit_price, subtotal)
values
(2, 3, 1, 45000, 45000),
(2, 7, 1, 15000, 15000),
(2, 5, 1, 25000, 25000);

select * from users where username = 'admin';

select * from users where username = 'khach01';

DELIMITER $$

-- ========== 1. Tìm kiếm sản phẩm theo CATEGORY ==========
CREATE PROCEDURE sp_search_products_by_category(
    IN p_category_id INT
)
BEGIN
    SELECT 
        p.id,
        p.name,
        p.price,
        p.description,
        p.img,
        p.is_available,
        p.category_id,
        c.name AS category_name,
        p.created_at
    FROM products p
    INNER JOIN categories c ON p.category_id = c.id
    WHERE p.category_id = p_category_id
        AND p.is_available = 1
    ORDER BY p.created_at DESC;
END$$

-- ========== 2. Tìm kiếm sản phẩm theo TÊN ==========
CREATE PROCEDURE sp_search_products_by_name(
    IN p_product_name VARCHAR(100)
)
BEGIN
    SELECT 
        p.id,
        p.name,
        p.price,
        p.description,
        p.img,
        p.is_available,
        p.category_id,
        c.name AS category_name,
        p.created_at
    FROM products p
    INNER JOIN categories c ON p.category_id = c.id
    WHERE p.name LIKE CONCAT('%', p_product_name, '%')
        AND p.is_available = 1
    ORDER BY p.created_at DESC;
END$$

DELIMITER ;

-- ===== Tìm theo CATEGORY =====
-- Tìm tất cả sản phẩm Gà rán (category_id = 1)
CALL sp_search_products_by_category(1);

-- Tìm tất cả sản phẩm Hamburger (category_id = 2)
CALL sp_search_products_by_category(2);

-- Tìm tất cả sản phẩm Khoai tây & Ăn kèm (category_id = 3)
CALL sp_search_products_by_category(3);

-- Tìm tất cả Nước uống (category_id = 4)
CALL sp_search_products_by_category(4);


-- ===== Tìm theo TÊN =====
-- Tìm sản phẩm có chữ "gà"
CALL sp_search_products_by_name('gà');

-- Tìm sản phẩm có chữ "burger"
CALL sp_search_products_by_name('burger');

-- Tìm sản phẩm có chữ "khoai"
CALL sp_search_products_by_name('khoai');

-- Tìm sản phẩm có chữ "coca"
CALL sp_search_products_by_name('coca');

-- Tìm sản phẩm có chữ "rán"
CALL sp_search_products_by_name('rán');

select * from products
