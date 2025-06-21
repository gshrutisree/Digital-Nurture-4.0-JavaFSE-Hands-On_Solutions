interface PaymentProcessor {
    void processPayment(double amt);
}
class GatewayA {
    void printTransaction(double amt) {
        System.out.println("Processing ₹" + amt + " through Gateway A");
    }
}
class GatewayB {
    void printpay(double amt) {
        System.out.println("Processing ₹" + amt + " through Gateway B");
    }
}
class GatewayAAdapter implements PaymentProcessor {
    private GatewayA ga = new GatewayA();
    
    public void processPayment(double amt) {
        ga.printTransaction(amt);
    }
}
class GatewayBAdapter implements PaymentProcessor {
    private GatewayB gb = new GatewayB();
    public void processPayment(double amt) {
        gb.printpay(amt);
    }
}
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor processorA = new GatewayAAdapter();
        processorA.processPayment(1200.00);

        PaymentProcessor processorB = new GatewayBAdapter();
        processorB.processPayment(2500.00);
    }
}
