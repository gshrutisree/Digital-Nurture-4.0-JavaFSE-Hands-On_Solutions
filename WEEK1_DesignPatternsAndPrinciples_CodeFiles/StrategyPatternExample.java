interface PaymentStrategy {
    void pay(int amt);
}
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amt) {
        System.out.println("Paid ₹" + amt + " using Credit Card");
    }
}
class UpiPayment implements PaymentStrategy {
    public void pay(int amt) {
        System.out.println("Paid ₹" + amt + " using UPI");
    }
}
class PaymentContext {
    private PaymentStrategy ps;
    public PaymentContext(PaymentStrategy ps) {
        this.ps = ps;
    }
    public void makePayment(int amt) {
        ps.pay(amt);
    }
}
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy ccd = new CreditCardPayment();
        PaymentContext c1 = new PaymentContext(ccd);
        c1.makePayment(500);
        PaymentStrategy upi = new UpiPayment();
        PaymentContext c2 = new PaymentContext(upi);
        c2.makePayment(250);
    }
}
