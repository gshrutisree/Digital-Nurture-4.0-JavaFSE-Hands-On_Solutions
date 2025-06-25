create or replace function calculateage(dob in date) return number is
  age number;
begin
  age := floor(months_between(sysdate, dob) / 12);
  return age;
end;
/
create or replace function calculatemonthlyinstallment(
  loanamount in number,
  interestrate in number,
  duration_years in number
) return number is
  monthly_rate number;
  total_months number;
  installment number;
begin
  monthly_rate := interestrate / 1200;
  total_months := duration_years * 12;
  installment := loanamount * monthly_rate / (1 - power(1 + monthly_rate, -total_months));
  return round(installment, 2);
end;
/
create or replace function hassufficientbalance(accid in number, amt in number) return boolean is
  acc_balance number;
begin
  select balance into acc_balance from accounts where accountid = accid;
  return acc_balance >= amt;
exception
  when no_data_found then
    return false;
  when others then
    return false;
end;
/
select calculateage(to_date('1990-07-20', 'yyyy-mm-dd')) as age from dual;
select calculatemonthlyinstallment(5000, 5, 5) as monthly_installment from dual;
select hassufficientbalance(1, 500) as has_funds from dual;
