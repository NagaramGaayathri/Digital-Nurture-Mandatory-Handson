package factories;

import documents.Document;
import documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String fileName) {
        System.out.println(">>> Factory: Creating a Word Document...");
        return new WordDocument(fileName);
    }
}