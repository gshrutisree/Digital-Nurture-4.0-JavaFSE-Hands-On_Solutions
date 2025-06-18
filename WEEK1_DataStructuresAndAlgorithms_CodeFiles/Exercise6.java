import java.util.Arrays;
class Book {
    int bookId;
    String title;
    String author;
    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    void print() {
        System.out.println(bookId + ": " + title + " by " + author);
    }
}
class LibrarySystem {
    Book[] b;
    LibrarySystem(Book[] b) {
        this.b = b;
    }
    int linearSearch(String s) {
        for (int i = 0; i < b.length; i++) {
            if (b[i].title.equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }
    int binarySearch(String s) {
        int low = 0, high = b.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = b[mid].title.compareToIgnoreCase(s);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        Book[] arr = {
            new Book(1, "Algorithms", "CLRS"),
            new Book(2, "Data Structures", "Narasimha Karumanchi"),
            new Book(3, "Java Programming", "Herbert Schildt"),
            new Book(4, "Operating Systems", "Galvin")
        };
        Arrays.sort(arr, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
        LibrarySystem lib = new LibrarySystem(arr);
        System.out.println("All Books:");
        for (Book b : arr) b.print();
        String s = "Java Programming";
        int lind = lib.linearSearch(s);
        System.out.println("\nLinear Search Result:");
        System.out.println(lind >= 0 ? "Found: " + arr[lind].title : "Not found");
        int bind = lib.binarySearch(s);
        System.out.println("\nBinary Search Result:");
        System.out.println(bind >= 0 ? "Found: " + arr[bind].title : "Not found");
    }
}
