create or replace package body customermanagement as
  procedure addcustomer(cid number, name varchar2, dob date, balance number) is
  begin
    insert into customers values (cid, name, dob, balance, sysdate);
  end;

  procedure updatecustomer(cid number, name varchar2) is
  begin
    update customers set name = name, lastmodified = sysdate where customerid = cid;
  end;

  function getbalance(cid number) return number is
    bal number;
  begin
    select balance into bal from customers where customerid = cid;
    return bal;
  end;
end;
/

create or replace package employeemanagement as
  procedure hire(empid number, name varchar2, pos varchar2, sal number, dept varchar2, hdate date);
  procedure updateemp(empid number, sal number);
  function annualsalary(empid number) return number;
end;
/
create or replace package body employeemanagement as
  procedure hire(empid number, name varchar2, pos varchar2, sal number, dept varchar2, hdate date) is
  begin
    insert into employees values (empid, name, pos, sal, dept, hdate);
  end;

  procedure updateemp(empid number, sal number) is
  begin
    update employees set salary = sal where employeeid = empid;
  end;

  function annualsalary(empid number) return number is
    total number;
  begin
    select salary * 12 into total from employees where employeeid = empid;
    return total;
  end;
end;
/

create or replace package accountoperations as
  procedure openacc(aid number, cid number, atype varchar2, bal number);
  procedure closeacc(aid number);
  function totalbalance(cid number) return number;
end;
/
create or replace package body accountoperations as
  procedure openacc(aid number, cid number, atype varchar2, bal number) is
  begin
    insert into accounts values (aid, cid, atype, bal, sysdate);
  end;

  procedure closeacc(aid number) is
  begin
    delete from accounts where accountid = aid;
  end;

  function totalbalance(cid number) return number is
    total number;
  begin
    select sum(balance) into total from accounts where customerid = cid;
    return total;
  end;
end;
/
