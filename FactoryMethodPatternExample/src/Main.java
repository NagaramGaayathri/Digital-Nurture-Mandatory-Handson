import documents.Document;
import factories.DocumentFactory;
import factories.WordDocumentFactory;
import factories.PdfDocumentFactory;
import factories.ExcelDocumentFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   Document Management System Demo      ");
        System.out.println("========================================\n");

        System.out.println("--- Creating Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("ProjectReport");
        System.out.println("Type: " + wordDoc.getDocumentType());
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        System.out.println();

        System.out.println("--- Creating PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("UserManual");
        System.out.println("Type: " + pdfDoc.getDocumentType());
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        System.out.println();

        System.out.println("--- Creating Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("SalesData");
        System.out.println("Type: " + excelDoc.getDocumentType());
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\n========================================");
        System.out.println("            Demo Complete               ");
        System.out.println("========================================");
    }
}