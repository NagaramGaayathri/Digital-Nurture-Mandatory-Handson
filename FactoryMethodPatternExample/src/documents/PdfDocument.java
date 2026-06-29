package documents;

public class PdfDocument implements Document {
    private String fileName;

    public PdfDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[PDF] Opening document: " + fileName + ".pdf");
    }

    @Override
    public void save() {
        System.out.println("[PDF] Saving document: " + fileName + ".pdf");
    }

    @Override
    public void close() {
        System.out.println("[PDF] Closing document: " + fileName + ".pdf");
    }

    @Override
    public String getDocumentType() {
        return "Adobe PDF Document (.pdf)";
    }
}