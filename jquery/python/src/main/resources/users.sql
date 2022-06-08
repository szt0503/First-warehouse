create table users(
   id int primary key,
   smb_id int,
   userCode varchar(15),
   userName varchar(15),
   userPassword varchar(15),
   gender int,
   birthday date,
   phone varchar(15),
   address varchar(30),
   userRole int,userName
   createdBy int,
   creationDate datetime,
   modifyBy int,
   modifyDate datetime,
);
insert into users values (1, 1, '1', 'zhangsan', '123456', 1, '1999-09-08', '15945123685', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (2, 2, '2', 'lisi', '123456', 1, '1999-09-09', '15945123681', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (3, 3, '3', 'wanger', '123456', 1, '1999-09-10', '15945123682', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (4, 4, '4', 'lumiao', '123456', 1, '1999-09-11', '15945123683', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (5, 5, '5', 'zhudi', '123456', 1, '1999-09-12', '15945123684', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (6, 6, '6', 'zhubiao', '123456', 1, '1999-09-13', '15945123686', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (7, 7, '7', 'liwu', '123456', 1, '1999-09-14', '15945123687', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (8, 8, '8', 'jiabaoyu', '123456', 1, '1999-09-15', '15945123688', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (9, 9, '9', 'tangseng', '123456', 1, '1999-09-16', '15945123689', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (10, 10, '10', 'libai', '123456', 1, '1999-09-17', '15945123612', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');
insert into users values (11, 11, '11', 'zhangsan', '123456', 1, '1999-09-18', '159451236813', '内蒙古', 1, 1, '2022-03-09', 1, '2022-03-09');