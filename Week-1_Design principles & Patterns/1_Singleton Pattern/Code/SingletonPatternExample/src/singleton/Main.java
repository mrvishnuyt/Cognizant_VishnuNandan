package singleton;

public class Main {
    public static void main(String[] args) {
        // Access Logger via getInstance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger
        logger1.log("First log message");
        logger2.log("Second log message");

        // Test if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton verified).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }
    }
}
