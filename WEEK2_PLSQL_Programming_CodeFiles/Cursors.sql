begin
  for r in ( select c.name, t.transactiondate, t.amount, t.transactiontype
    from customers c join accounts a on c.customerid = a.customerid
    join transactions t on a.accountid = t.accountid where extract(month from t.transactiondate) = extract(month from sysdate)
    and extract(year from t.transactiondate) = extract(year from sysdate)
  ) loop
    dbms_output.put_line('Customer: ' || r.name || ', Date: ' || r.transactiondate || ', Amount: ' || r.amount || ', Type: ' || r.transactiontype);
  end loop;
end;
/
declare
  cursor fee_cursor is select accountid, balance from accounts;
  fee number := 100;
begin
  for rec in fee_cursor loop
    update accounts set balance = balance - fee, lastmodified = sysdate where accountid = rec.accountid;
  end loop;
  commit;
  dbms_output.put_line('Annual fee applied to all accounts.');
end;
/

declare
  cursor loan_cursor is select loanid, loanamount, interestrate from loans;
begin
  for l in loan_cursor loop
    if l.loanamount > 6000 then
      update loans set interestrate = interestrate + 0.5 where loanid = l.loanid;
    end if;
  end loop;
  commit;
  dbms_output.put_line('Loan interest rates updated as per new policy.');
end;
/