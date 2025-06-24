begin
  execute immediate 'drop table SavingsAccounts';
  execute immediate 'drop table Employees';
  execute immediate 'drop table Accounts';
exception
  when others then null;
end;
/
create table savingsaccounts (accno number primary key,holdername varchar2(50),balance number);
insert into savingsaccounts values (1001, 'Amit', 10000);
insert into savingsaccounts values (1002, 'Priya', 15000);
create or replace procedure processmonthlyinterest is
begin
  update savingsaccounts
  set balance = balance + (balance * 0.01);
  commit;
  dbms_output.put_line('Monthly interest processed for all savings accounts.');
exception
  when others then
    dbms_output.put_line('Error: ' || sqlerrm);
    rollback;
end;
/
create table employees (empid number primary key,name varchar2(50),department varchar2(30),salary number);
insert into employees values (1, 'Ravi', 'HR', 40000);
insert into employees values (2, 'Anita', 'IT', 60000);
insert into employees values (3, 'Kiran', 'IT', 55000);
create or replace procedure updateemployeebonus(dept in varchar2,bonus_percent in number) is
begin
  update employees
  set salary = salary + (salary * bonus_percent / 100)
  where department = dept;

  if sql%rowcount = 0 then
    dbms_output.put_line('No employees found in department ' || dept);
    rollback;
  else
    commit;
    dbms_output.put_line('Bonus updated for department ' || dept);
  end if;
exception
  when others then
    dbms_output.put_line('Error: ' || sqlerrm);
    rollback;
end;
/
create table accounts (accid number primary key,holder varchar2(50),balance number);

insert into accounts values (1, 'Ramesh', 8000);
insert into accounts values (2, 'Suresh', 4000);

create or replace procedure transferfunds(from_acc in number,to_acc in number,amt in number) is
  from_balance number;
begin
  select balance into from_balance from accounts where accid = from_acc;

  if from_balance < amt then
    dbms_output.put_line('Error: Insufficient balance.');
    rollback;
  else
    update accounts set balance = balance - amt where accid = from_acc;
    update accounts set balance = balance + amt where accid = to_acc;
    commit;
    dbms_output.put_line('Transfer successful.');
  end if;
exception
  when no_data_found then
    dbms_output.put_line('Error: Invalid account ID.');
    rollback;
  when others then
    dbms_output.put_line('Error: ' || sqlerrm);
    rollback;
end;
/

begin
  processmonthlyinterest;
end;
/

begin
  updateemployeebonus('IT', 5); 
  updateemployeebonus('SALES', 10); 
end;
/

begin
  transferfunds(1, 2, 3000); 
  transferfunds(1, 2, 10000); 
end;
/
select * from savingsaccounts;
select * from employees;
select * from accounts;
