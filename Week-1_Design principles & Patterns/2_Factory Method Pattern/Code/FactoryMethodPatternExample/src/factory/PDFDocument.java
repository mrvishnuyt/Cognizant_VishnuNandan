package factory;

public class PDFDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }
}
