create table customers (customerid number primary key, name varchar2(100), dob date, balance number, lastmodified date);
create table accounts (accountid number primary key, customerid number, accounttype varchar2(20), balance number, lastmodified date, foreign key (customerid) references customers(customerid));
create table employees (employeeid number primary key, name varchar2(100), position varchar2(50), salary number, department varchar2(50), hiredate date);

insert into customers values (1, 'John Doe', to_date('1985-05-15', 'yyyy-mm-dd'), 1000, sysdate);
insert into customers values (2, 'Jane Smith', to_date('1990-07-20', 'yyyy-mm-dd'), 1500, sysdate);
insert into accounts values (1, 1, 'Savings', 1000, sysdate);
insert into accounts values (2, 2, 'Savings', 1500, sysdate);
insert into employees values (1, 'Alice Johnson', 'Manager', 70000, 'HR', to_date('2015-06-15', 'yyyy-mm-dd'));
insert into employees values (2, 'Bob Brown', 'Developer', 60000, 'IT', to_date('2017-03-20', 'yyyy-mm-dd'));
commit;

create or replace procedure processmonthlyinterest is
begin
  update accounts set balance = balance + (balance * 0.01), lastmodified = sysdate where accounttype = 'Savings';
  commit;
  dbms_output.put_line('Monthly interest processed for all savings accounts.');
exception when others then dbms_output.put_line('Error: ' || sqlerrm); rollback;
end;
/
create or replace procedure updateemployeebonus(dept in varchar2, bonus_percent in number) is
begin
  update employees set salary = salary + (salary * bonus_percent / 100) where department = dept;
  if sql%rowcount = 0 then dbms_output.put_line('No employees found in department ' || dept); rollback;
  else commit; dbms_output.put_line('Bonus updated for department ' || dept); end if;
exception when others then dbms_output.put_line('Error: ' || sqlerrm); rollback;
end;
/
create or replace procedure transferfunds(from_acc in number, to_acc in number, amt in number) is from_balance number;
begin
  select balance into from_balance from accounts where accountid = from_acc;
  if from_balance < amt then dbms_output.put_line('Error: Insufficient balance.'); rollback;
  else update accounts set balance = balance - amt, lastmodified = sysdate where accountid = from_acc;
       update accounts set balance = balance + amt, lastmodified = sysdate where accountid = to_acc;
       commit; dbms_output.put_line('Transfer successful.'); end if;
exception when no_data_found then dbms_output.put_line('Error: Invalid account ID.'); rollback;
when others then dbms_output.put_line('Error: ' || sqlerrm); rollback;
end;
/
begin processmonthlyinterest; end;
/
begin updateemployeebonus('IT', 5); updateemployeebonus('SALES', 10); end;
/
begin transferfunds(1, 2, 300); transferfunds(1, 2, 10000); end;
/
select * from accounts;
select * from employees;
