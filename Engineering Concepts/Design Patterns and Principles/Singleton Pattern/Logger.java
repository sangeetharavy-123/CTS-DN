class Logger {

    // Single instance of Logger (static so it belongs to class)
    private static Logger obj;

    // Private constructor prevents object creation using "new"
    private Logger() {
        System.out.println("Logger object created");
    }

    // Global access point to get the single instance
    public static Logger getInstance() {

        // Create object only once
        if (obj == null) {
            obj = new Logger();
        }

        return obj;
    }

    // Sample logging method
    public void display() {
        System.out.println("Logging message...");
    }
}