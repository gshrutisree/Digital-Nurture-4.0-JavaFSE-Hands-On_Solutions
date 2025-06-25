create table customers (customerid number primary key, name varchar2(100), dob date, balance number, lastmodified date);
create table accounts (accountid number primary key, customerid number, accounttype varchar2(20), balance number, lastmodified date, foreign key (customerid) references customers(customerid));
create table transactions (transactionid number primary key, accountid number, transactiondate date, amount number, transactiontype varchar2(10), foreign key (accountid) references accounts(accountid));
create table loans (loanid number primary key, customerid number, loanamount number, interestrate number, startdate date, enddate date, foreign key (customerid) references customers(customerid));
create table employees (employeeid number primary key, name varchar2(100), position varchar2(50), salary number, department varchar2(50), hiredate date);

insert into customers values (1, 'John Doe', to_date('1985-05-15', 'yyyy-mm-dd'), 1000, sysdate);
insert into customers values (2, 'Jane Smith', to_date('1990-07-20', 'yyyy-mm-dd'), 1500, sysdate);
insert into accounts values (1, 1, 'Savings', 1000, sysdate);
insert into accounts values (2, 2, 'Checking', 1500, sysdate);
insert into transactions values (1, 1, sysdate, 200, 'Deposit');
insert into transactions values (2, 2, sysdate, 300, 'Withdrawal');
insert into loans values (1, 1, 5000, 8, sysdate, add_months(sysdate, 60));
insert into loans values (2, 2, 4000, 7, sysdate, add_months(sysdate, 60));
insert into employees values (1, 'Alice Johnson', 'Manager', 70000, 'HR', to_date('2015-06-15', 'yyyy-mm-dd'));
insert into employees values (2, 'Bob Brown', 'Developer', 60000, 'IT', to_date('2017-03-20', 'yyyy-mm-dd'));
commit;

begin
  for rec in (select l.loanid, c.dob from customers c join loans l on c.customerid = l.customerid) loop
    if floor(months_between(sysdate, rec.dob) / 12) > 60 then
      update loans set interestrate = interestrate - 1 where loanid = rec.loanid;
    end if;
  end loop;
  commit;
end;
/
begin
  for rec in (select c.customerid from customers c join accounts a on c.customerid = a.customerid group by c.customerid having sum(a.balance) > 10000) loop
    dbms_output.put_line('Customer ID ' || rec.customerid || ' is promoted to VIP.');
  end loop;
end;
/
begin
  for rec in (select l.loanid, c.name from loans l join customers c on l.customerid = c.customerid where l.enddate <= sysdate + 30) loop
    dbms_output.put_line('Reminder: Loan ID ' || rec.loanid || ' for ' || rec.name || ' is due soon.');
  end loop;
end;
/
select * from loans;
