package factories;

import documents.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument(String fileName);

    public Document openDocument(String fileName) {
        Document doc = createDocument(fileName);
        doc.open();
        return doc;
    }
}
