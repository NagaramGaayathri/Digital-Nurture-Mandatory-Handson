package factories;

import documents.Document;
import documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String fileName) {
        System.out.println(">>> Factory: Creating a PDF Document...");
        return new PdfDocument(fileName);
    }
}