class Logger {
    private static Logger ins;

    private Logger() {
        System.out.println("Logger Initialized");
    }

    public static Logger getInstance() {
        if (ins == null) {
            ins = new Logger();
        }
        return ins;
    }

    public void log(String s) {
        System.out.println("Log: " + s);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        l1.log("First Message");
        Logger l2 = Logger.getInstance();
        l2.log("Second Message");

        if (l1 == l2) {
            System.out.println("Same Instance");
        } else {
            System.out.println("Not Same Instance");
        }
    }
}
