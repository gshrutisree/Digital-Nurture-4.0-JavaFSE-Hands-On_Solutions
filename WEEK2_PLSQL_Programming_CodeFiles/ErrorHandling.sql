begin execute immediate 'drop table accounts'; execute immediate 'drop table employees'; execute immediate 'drop table customers'; exception when others then null; end;
/

create table customers (customerid number primary key, name varchar2(100), dob date, balance number, lastmodified date);
create table accounts (accountid number primary key, customerid number, accounttype varchar2(20), balance number, lastmodified date, foreign key (customerid) references customers(customerid));
create table employees (employeeid number primary key, name varchar2(100), position varchar2(50), salary number, department varchar2(50), hiredate date);

insert into customers values (1, 'John Doe', to_date('1985-05-15', 'yyyy-mm-dd'), 1000, sysdate);
insert into customers values (2, 'Jane Smith', to_date('1990-07-20', 'yyyy-mm-dd'), 1500, sysdate);
insert into accounts values (1, 1, 'Savings', 1000, sysdate);
insert into accounts values (2, 2, 'Checking', 1500, sysdate);
insert into employees values (1, 'Alice Johnson', 'Manager', 70000, 'HR', to_date('2015-06-15', 'yyyy-mm-dd'));
insert into employees values (2, 'Bob Brown', 'Developer', 60000, 'IT', to_date('2017-03-20', 'yyyy-mm-dd'));
commit;

create or replace procedure safetransferfunds(from_acc in number, to_acc in number, amount in number) is from_balance number; begin select balance into from_balance from accounts where accountid = from_acc; if from_balance < amount then dbms_output.put_line('Error: Insufficient funds in source account.'); rollback; else update accounts set balance = balance - amount, lastmodified = sysdate where accountid = from_acc; update accounts set balance = balance + amount, lastmodified = sysdate where accountid = to_acc; commit; dbms_output.put_line('Transfer completed successfully.'); end if; exception when no_data_found then dbms_output.put_line('Error: One of the account IDs is invalid.'); rollback; when others then dbms_output.put_line('Transfer failed: ' || sqlerrm); rollback; end;
/

create or replace procedure updatesalary(emp_id in number, percent in number) is begin update employees set salary = salary + (salary * percent / 100) where employeeid = emp_id; if sql%rowcount = 0 then dbms_output.put_line('Error: Employee not found.'); rollback; else commit; dbms_output.put_line('Salary updated successfully.'); end if; exception when others then dbms_output.put_line('Update failed: ' || sqlerrm); rollback; end;
/

create or replace procedure addnewcustomer(cust_id in number, name in varchar2, dob in date, balance in number) is begin insert into customers (customerid, name, dob, balance, lastmodified) values (cust_id, name, dob, balance, sysdate); commit; dbms_output.put_line('New customer added successfully.'); exception when dup_val_on_index then dbms_output.put_line('Error: Customer ID already exists.'); rollback; when others then dbms_output.put_line('Insert failed: ' || sqlerrm); rollback; end;
/
begin safetransferfunds(1, 2, 300); safetransferfunds(1, 2, 5000); end;
/
begin updatesalary(1, 10); updatesalary(999, 10); end;
/
begin addnewcustomer(3, 'Meera Rao', to_date('1995-03-10', 'yyyy-mm-dd'), 2000); addnewcustomer(1, 'Duplicate John', to_date('1990-01-01', 'yyyy-mm-dd'), 500); end;
/
select * from accounts;
select * from employees;
select * from customers;
