package factories;

import documents.Document;
import documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String fileName) {
        System.out.println(">>> Factory: Creating an Excel Document...");
        return new ExcelDocument(fileName);
    }
}