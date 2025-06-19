interface Document {
    void open();
}
class WordDoc implements Document {
    public void open() {
        System.out.println("Opening Word Doc");
    }
}
class PdfDoc implements Document {
    public void open() {
        System.out.println("Opening Pdf Doc");
    }
}
class ExcelDoc implements Document {
    public void open() {
        System.out.println("Opening Excel Doc");
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}
class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDoc();
    }
}
class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDoc();
    }
}
class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDoc();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
