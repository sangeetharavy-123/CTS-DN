// Concrete factory for creating WordDocument objects
class WordFactory extends DocumentFactory {

    // Override factory method
    public Document createDocument() {

        // Create and return WordDocument object
        return new WordDocument();

    }

}