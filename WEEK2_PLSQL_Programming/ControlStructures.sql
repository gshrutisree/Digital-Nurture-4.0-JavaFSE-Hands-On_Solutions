create table customers (
  customerid number primary key,
  name varchar2(100),
  dob date
);

create table loans (loanid number primary key,customerid number,loanamount number,interestrate number, startdate date,enddate date, foreign key (customerid) references customers(customerid));
insert into customers values (1, 'Ram', to_date('1998-10-15', 'yyyy-mm-dd'));
insert into customers values (2, 'Jayanth', to_date('1980-11-20', 'yyyy-mm-dd'));
insert into customers values (3, 'Sita', to_date('1997-04-01', 'yyyy-mm-dd'));
insert into loans values (1, 1, 5000, 8, to_date('2021-04-01', 'yyyy-mm-dd'), to_date('2025-07-10', 'yyyy-mm-dd'));
insert into loans values (2, 2, 4000, 7, to_date('2021-05-01', 'yyyy-mm-dd'), to_date('2025-07-15', 'yyyy-mm-dd'));
insert into loans values (3, 3, 6000, 9, to_date('2021-06-01', 'yyyy-mm-dd'), to_date('2025-07-20', 'yyyy-mm-dd'));
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
