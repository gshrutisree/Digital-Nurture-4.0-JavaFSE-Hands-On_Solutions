create table customers (
  customerid number primary key,
  name varchar2(100),
  dob date,
  balance number,
  lastmodified date
);
create table loans (loanid number primary key,customerid number,loanamount number,interestrate number,startdate date,enddate date,foreign key (customerid) references customers(customerid));
insert into customers values (1, 'John Doe', to_date('1955-05-15', 'yyyy-mm-dd'), 1000, sysdate);
insert into customers values (2, 'Jane Smith', to_date('1990-07-20', 'yyyy-mm-dd'), 1500, sysdate);
insert into customers values (3, 'Kiran Rao', to_date('1940-01-01', 'yyyy-mm-dd'), 2000, sysdate);
insert into loans values (1, 1, 5000, 5, sysdate, add_months(sysdate, 60));
insert into loans values (2, 2, 7000, 6, sysdate, add_months(sysdate, 60));
insert into loans values (3, 3, 6000, 8, sysdate, add_months(sysdate, 60));
commit;
begin
  for rec in (
    select l.loanid, c.dob
    from customers c
    join loans l on c.customerid = l.customerid
  ) loop
    if floor(months_between(sysdate, rec.dob) / 12) > 60 then
      update loans
      set interestrate = interestrate - 1
      where loanid = rec.loanid;
    end if;
  end loop;
  commit;
end;
/
select * from loans;
