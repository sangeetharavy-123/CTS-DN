// Concrete factory for creating PdfDocument objects
class PdfFactory extends DocumentFactory {

    // Override factory method
    public Document createDocument() {

        // Create and return PdfDocument object
        return new PdfDocument();

    }

}