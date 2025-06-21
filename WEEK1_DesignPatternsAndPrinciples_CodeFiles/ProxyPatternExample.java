interface Image {
    void display();
}
class RealImage implements Image {
    private String s;
    public RealImage(String s) {
        this.s = s;
        loadImageFromServer();
    }
    private void loadImageFromServer() {
        System.out.println("Loading " + s + " from remote server...");
    }
    public void display() {
        System.out.println("Displaying " + s);
    }
}
class ProxyImage implements Image {
    private RealImage realImage;
    private String s;

    public ProxyImage(String s) {
        this.s = s;
    }
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(s); 
        }
        realImage.display();
    }
}
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("cat.jpg");
        image1.display(); 
        image1.display(); 
    }
}
