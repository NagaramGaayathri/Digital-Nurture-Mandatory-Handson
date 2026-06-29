package documents;

public class ExcelDocument implements Document {
    private String fileName;

    public ExcelDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[Excel] Opening spreadsheet: " + fileName + ".xlsx");
    }

    @Override
    public void save() {
        System.out.println("[Excel] Saving spreadsheet: " + fileName + ".xlsx");
    }

    @Override
    public void close() {
        System.out.println("[Excel] Closing spreadsheet: " + fileName + ".xlsx");
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Excel Spreadsheet (.xlsx)";
    }
}