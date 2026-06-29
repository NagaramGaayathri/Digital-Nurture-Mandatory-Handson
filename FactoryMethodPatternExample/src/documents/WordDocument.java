package documents;

public class WordDocument implements Document {
    private String fileName;

    public WordDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[Word] Opening document: " + fileName + ".docx");
    }

    @Override
    public void save() {
        System.out.println("[Word] Saving document: " + fileName + ".docx");
    }

    @Override
    public void close() {
        System.out.println("[Word] Closing document: " + fileName + ".docx");
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Word Document (.docx)";
    }
}
