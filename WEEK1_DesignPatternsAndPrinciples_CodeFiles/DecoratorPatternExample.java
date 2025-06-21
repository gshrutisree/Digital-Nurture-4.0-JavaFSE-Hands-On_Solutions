interface Notifier {
    void send(String s);
}
class EmailNotifier implements Notifier {
    public void send(String s) {
        System.out.println("Email: " + s);
    }
}
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier n) {
        this.notifier = n;
    }
    public void send(String s) {
        notifier.send(s);
    }
}
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier n) {
        super(n);
    }
    public void send(String s) {
        super.send(s);
        System.out.println("SMS: " + s);
    }
}
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier n) {
        super(n);
    }
    public void send(String s) {
        super.send(s);
        System.out.println("Slack: " + s);
    }
}
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier sae = new SMSNotifierDecorator(email);
        Notifier ac = new SlackNotifierDecorator(sae);
        ac.send("You have a new alert!");
    }
}
