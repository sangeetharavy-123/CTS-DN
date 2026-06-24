class Main {

    public static void main(String[] args) {

        // Create WordFactory object
        DocumentFactory wordFactory = new WordFactory();

        // Use factory to create WordDocument object
        Document word = wordFactory.createDocument();

        // Open Word document
        word.open();


        // Create PdfFactory object
        DocumentFactory pdfFactory = new PdfFactory();

        // Use factory to create PdfDocument object
        Document pdf = pdfFactory.createDocument();

        // Open PDF document
        pdf.open();


        // Create ExcelFactory object
        DocumentFactory excelFactory = new ExcelFactory();

        // Use factory to create ExcelDocument object
        Document excel = excelFactory.createDocument();

        // Open Excel document
        excel.open();

    }

}