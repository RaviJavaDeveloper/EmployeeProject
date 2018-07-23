
mysql> create table employee(id int(10) PRIMARY KEY,uname varchar(30) NOT NULL,password varchar(40) NOT NULL,email varchar(40) NOT NULL UNIQUE,salary int(6),dateofbirth date,joiningdate date NOT NULL,deptname varchar(10));
mysql> insert into employee values(1,'ravi','cGFzc3dvcmQ=','cmF2aUBnbWFpbC5jb20=',1000,'2010-01-01','2010-01-01','developer');