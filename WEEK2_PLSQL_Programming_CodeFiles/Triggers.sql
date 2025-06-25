create table auditlog (logid number generated always as identity primary key, transactionid number, message varchar2(100), logdate date);

create or replace trigger updatecustomerlastmodified
before update on customers
for each row
begin
  :new.lastmodified := sysdate;
end;
/
create or replace trigger logtransaction
after insert on transactions
for each row
begin
  insert into auditlog (transactionid, message, logdate)
  values (:new.transactionid, 'Transaction recorded for account ' || :new.accountid, sysdate);
end;
/
create or replace trigger checktransactionrules
before insert on transactions
for each row
declare
  acc_bal number;
begin
  select balance into acc_bal from accounts where accountid = :new.accountid;
  if :new.transactiontype = 'Withdrawal' and :new.amount > acc_bal then
    raise_application_error(-20001, 'Withdrawal exceeds available balance.');
  end if;
  if :new.transactiontype = 'Deposit' and :new.amount <= 0 then
    raise_application_error(-20002, 'Deposit amount must be positive.');
  end if;
exception
  when no_data_found then
    raise_application_error(-20003, 'Account does not exist.');
end;
/
update customers set balance = balance + 100 where customerid = 1;
insert into transactions (transactionid, accountid, transactiondate, amount, transactiontype)
values (3, 1, sysdate, 500, 'Deposit');
insert into transactions (transactionid, accountid, transactiondate, amount, transactiontype)
values (4, 2, sysdate, 2000, 'Withdrawal');
select * from customers;
select * from transactions;
select * from auditlog;
