# Factory Method Pattern in Java

## Overview
This project demonstrates the Factory Method Design Pattern for creating different types of documents such as Word, PDF, and Excel.

## Files
- `Document.java` - Common interface
- `WordDocument.java`, `PdfDocument.java`, `ExcelDocument.java` - Document classes
- `DocumentFactory.java` - Abstract factory class
- `WordFactory.java`, `PdfFactory.java`, `ExcelFactory.java` - Concrete factory classes
- `Main.java` - Test class

## Key Concept
The Factory Method Pattern separates object creation from object usage and makes the code easy to extend.