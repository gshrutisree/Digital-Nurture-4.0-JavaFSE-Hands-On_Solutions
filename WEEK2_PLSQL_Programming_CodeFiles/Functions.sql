create table customers (customerid number primary key,name varchar2(50),dob date);
insert into customers values (1, 'Neha', to_date('1995-06-24', 'yyyy-mm-dd'));
insert into customers values (2, 'Arjun', to_date('1988-09-15', 'yyyy-mm-dd'));
create or replace function calculateage(dob in date) return number is
  age number;
begin
  age := floor(months_between(sysdate, dob) / 12);
  return age;
end;
/
declare
  age number;
begin
  select calculateage(dob) into age from customers where customerid = 1;
  dbms_output.put_line('Age of customer 1: ' || age);
end;
/
create table loans (loanid number primary key,amount number,interestrate number,duration_years number);

insert into loans values (101, 120000, 10, 2);
create or replace function calculatemonthlyinstallment(loan_amt in number,rate in number,years in number) return number is
  r number := rate / (12 * 100); 
  n number := years * 12;       
  emi number;
begin
  emi := (loan_amt * r * power(1 + r, n)) / (power(1 + r, n) - 1);
  return round(emi, 2);
end;
/
declare
  emi number;
begin
  select calculatemonthlyinstallment(amount, interestrate, duration_years)
  into emi
  from loans
  where loanid = 101;

  dbms_output.put_line('Monthly EMI: ' || emi);
end;
/

create table accounts (accid number primary key,holder varchar2(50),balance number);

insert into accounts values (201, 'Kiran', 9000);
insert into accounts values (202, 'Meera', 2000);

create or replace function hassufficientbalance(acc_id in number,amt in number) return boolean is bal number;
begin select balance into bal from accounts where accid = acc_id;

if bal >= amt then
return true;
else
return false;
end if;

exception when no_data_found then return false;
end;
/
declare
  result boolean;
begin
result := hassufficientbalance(201, 5000);
  if result then
    dbms_output.put_line('Sufficient balance.');
  else
    dbms_output.put_line('Insufficient balance.');
  end if;
end;
/
select * from customers;
select * from loans;
select * from accounts;
