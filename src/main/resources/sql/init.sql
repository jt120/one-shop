drop database IF EXISTS itat_shop;
create database itat_shop;
GRANT ALL ON itat_shop.* TO 'itat'@'localhost' IDENTIFIED BY 'itat123';
FLUSH PRIVILEGES;
use itat_shop;
set names utf8;
create table t_user(
	id int(11) primary key auto_increment,
	username varchar(100),
	password varchar(100),
	nickname varchar(100),
	type int(5)
);
create table t_address(
	id int(11) primary key auto_increment,
	name varchar(255),
	phone varchar(100),
	postcode varchar(100),
	user_id int(11)
# 	CONSTRAINT FOREIGN KEY(user_id) REFERENCES t_user(id)
);
CREATE TABLE t_category (
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100)
);
CREATE TABLE t_product (
  id    INT(11) PRIMARY KEY AUTO_INCREMENT,
  name  VARCHAR(100),
  price DOUBLE,
  intro TEXT,
  img   VARCHAR(100),
  stock INT(10),
  status INT(2),
  c_id  INT(10)
#   CONSTRAINT FOREIGN KEY (c_id) REFERENCES t_category (id)
);
create table t_orders(
	id int(11) primary key auto_increment,
	buy_date datetime,
	pay_date datetime,
	confirm_date datetime,
	status int(5),
	user_id int(11),
	address_id int(11),
	price double
# 	CONSTRAINT FOREIGN KEY(user_id) REFERENCES t_user(id),
# 	CONSTRAINT FOREIGN KEY(address_id) REFERENCES t_address(id)
);
create table t_cart_product(
	id int(11) primary key auto_increment,
	number int(10),
	price double,
	o_id int(11),
	p_id int(11)
# 	CONSTRAINT FOREIGN KEY(o_id) REFERENCES t_orders(id),
# 	CONSTRAINT FOREIGN KEY(p_id) REFERENCES t_product(id)
);

create table t_product_orders(
	id int(11) primary key auto_increment,
	product_id int(10),
	orders_id int(10)
# 	CONSTRAINT FOREIGN KEY(product_id) REFERENCES t_product(id),
# 	CONSTRAINT FOREIGN KEY(orders_id) REFERENCES t_orders(id)
);
insert into t_user values(null,'admin','admin','超级管理员',1);
