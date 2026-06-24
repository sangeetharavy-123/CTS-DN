// Concrete factory for creating ExcelDocument objects
class ExcelFactory extends DocumentFactory {

    // Override factory method
    public Document createDocument() {

        // Create and return ExcelDocument object
        return new ExcelDocument();

    }

}