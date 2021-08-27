select user(), database();

show tables;

desc title;
desc department;
desc employee;

insert into title values(1, '사장');
insert into title values(2, '부장');

update title set tname = '과장' where tno = 2;
select * from title;
delete from title where tno = 2;

insert into department values(1, '기획', 10);
insert into employee values (4377,'이성래', 1, null, 4500000, 1);

select tno,tname from title;
select deptno, deptname, floor from department;
select empno, empname, title, manager, salary, dno from employee;