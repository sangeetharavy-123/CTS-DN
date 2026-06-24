class Main {

    public static void main(String[] args) {

        // First call → object is created
        Logger log1 = Logger.getInstance();

        // Second call → same object is returned
        Logger log2 = Logger.getInstance();

        // Method calls
        log1.display();
        log2.display();

        // Check if both references point to same object
        if (log1 == log2) {
            System.out.println("Only one Logger instance is created.");
        } else {
            System.out.println("Multiple Logger instances are created.");
        }
    }
}