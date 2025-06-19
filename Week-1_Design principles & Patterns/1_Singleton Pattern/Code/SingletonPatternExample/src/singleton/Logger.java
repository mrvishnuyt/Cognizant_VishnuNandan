package singleton;

public class Logger {
    private static Logger instance;

    // Private constructor prevents instantiation from other classes
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public method to return the single instance (lazy initialization)
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to simulate logging
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
