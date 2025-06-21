import java.util.*;
interface Observer {
    void update(String s, double p);
}
interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
class StockMarket implements Stock {
    private List<Observer> obs = new ArrayList<>();
    private String s;
    private double p;
    public void setStockPrice(String s, double p) {
        this.s = s;
        this.p = p;
        notifyObservers();
    }
    public void register(Observer o) {
        obs.add(o);
    }
    public void deregister(Observer o) {
        obs.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : obs) {
            o.update(s, p);
        }
    }
}
class MobileApp implements Observer {
    public void update(String s, double p) {
        System.out.println("Mobile App - " + s + ": ₹" + p);
    }
}
class WebApp implements Observer {
    public void update(String s, double p) {
        System.out.println("Web App - " + s + ": ₹" + p);
    }
}
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket m = new StockMarket();
        Observer mob = new MobileApp();
        Observer web = new WebApp();

        m.register(mob);
        m.register(web);

        m.setStockPrice("TCS", 3467.50);
        m.setStockPrice("INFY", 1532.25);
    }
}
