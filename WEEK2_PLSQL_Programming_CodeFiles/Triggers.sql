create table customers (customerid number primary key, name varchar2(50),email varchar2(100),lastmodified date);

insert into customers values (1, 'Ravi', 'ravi@email.com', sysdate);
insert into customers values (2, 'Neha', 'neha@email.com', sysdate);

create or replace trigger updatecustomerlastmodified
before update on customers
for each row
begin
  :new.lastmodified := sysdate;
end;
/

update customers set name = 'Ravi Kumar' where customerid = 1;

select * from customers;
create table transactions (transid number primary key,accid number,type varchar2(10),amount number,transdate date);

create table auditlog (logid number generated always as identity primary key,transid number,message varchar2(100),logdate date);

create or replace trigger logtransaction
after insert on transactions
for each row
begin
  insert into auditlog (transid, message, logdate)
  values (:new.transid, 'Transaction recorded for account ' || :new.accid, sysdate);
end;
/

insert into transactions values (101, 1, 'deposit', 2000, sysdate);
select * from auditlog;
create table accounts (accid number primary key,holder varchar2(50),balance number);
insert into accounts values (1, 'Ramesh', 5000);
insert into accounts values (2, 'Sita', 3000);
create or replace trigger checktransactionrules
before insert on transactions
for each row
declare
  acc_bal number;
begin
  select balance into acc_bal from accounts where accid = :new.accid;
  if :new.type = 'withdrawal' and :new.amount > acc_bal then
    raise_application_error(-20001, 'Withdrawal exceeds available balance.');
  end if;
  if :new.type = 'deposit' and :new.amount <= 0 then
    raise_application_error(-20002, 'Deposit amount must be positive.');
  end if;
exception
  when no_data_found then
    raise_application_error(-20003, 'Account does not exist.');
end;
/
insert into transactions values (102, 1, 'withdrawal', 1000, sysdate);
select * from transactions;
select * from accounts;
select * from auditlog;
