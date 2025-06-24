create table accounts (accountid number primary key,holdername varchar2(50),balance number);
insert into accounts values (1, 'Alice', 1000);
insert into accounts values (2, 'Bob', 500);
create table employees (
  empid number primary key, name varchar2(50),salary number);

insert into employees values (101, 'John', 30000);
insert into employees values (102, 'Jane', 35000);

create table customers (
  customerid  number primary key,
  name        varchar2(50),
  email       varchar2(100)
);

insert into customers values (201, 'Rahul', 'rahul@email.com');
commit;

create or replace procedure safetransferfunds(
  fromacc in number,
  toacc   in number,
  amount  in number
) is
from_balance number;
begin
  select balance into from_balance
  from accounts
  where accountid = fromacc;
  if from_balance < amount then
    dbms_output.put_line('Error: Insufficient funds in source account.');
    rollback;
  else
    update accounts set balance = balance - amount where accountid = fromacc;
    update accounts set balance = balance + amount where accountid = toacc;

    commit;
    dbms_output.put_line('Transfer completed successfully.');
  end if;
exception
  when no_data_found then
    dbms_output.put_line('Error: One of the account IDs is invalid.');
    rollback;
  when others then
    dbms_output.put_line('Transfer failed: ' || sqlerrm);
    rollback;
end;
/
create or replace procedure updatesalary(
  emp_id  in number,
  percent in number
) is
begin
  update employees
  set salary = salary + (salary * percent / 100)
  where empid = emp_id;

  if sql%rowcount = 0 then
    dbms_output.put_line('Error: Employee not found.');
    rollback;
  else
    commit;
    dbms_output.put_line('Salary updated successfully.');
  end if;
exception
  when others then
    dbms_output.put_line('Update failed:' || sqlerrm);
    rollback;
end;
/
create or replace procedure addnewcustomer(cust_id in number,name in varchar2,email in varchar2) is
begin
  insert into customers (customerid, name, email)
  values (cust_id, name, email);
  commit;
  dbms_output.put_line('New customer added successfully');
exception when dup_val_on_index then dbms_output.put_line('Error: Customer ID already exists');
rollback;
when others then dbms_output.put_line('Insert failed:' || sqlerrm);
rollback;
end;
/
begin safetransferfunds(1, 2, 300); 
safetransferfunds(1, 2, 1000);
end;
/
begin
updatesalary(101, 10);
updatesalary(999, 10);
end;
/
begin
addnewcustomer(202, 'Meera', 'meera@email.com');
addnewcustomer(201, 'Duplicate', 'dup@email.com');
end;
/
select * from accounts;
select * from employees;
select * from customers;
