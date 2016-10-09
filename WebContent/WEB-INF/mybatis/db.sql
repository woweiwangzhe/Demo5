drop table user_table;

create table user_table(
	id int UNSIGNED not null primary key AUTO_INCREMENT,
	username varchar(32) not null,
	age int default 0,
	sex int default 0,
	address varchar(128)
)AUTO_INCREMENT = 1000;
