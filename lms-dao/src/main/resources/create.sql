drop database if exists lms;
create database lms;
use lms;

create table t_stu
{
    id int primary key auto_increment,
    username varchar (200), not null unique,
    pwd varchar (200),
    age int
}engine=Innodb charset utf8;