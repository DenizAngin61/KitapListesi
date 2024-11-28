import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    private String name;
    private int pageCount;
    private String author;
    private String publishDate;

    // Constructor
    public Book(String name, int pageCount, String author, String publishDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publishDate = publishDate;
    }

    // Getter methodları
    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', pageCount=" + pageCount +
                ", author='" + author + "', publishDate='" + publishDate + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Kitap nesnelerini oluşturma
        List<Book> books = new ArrayList<>();
        books.add(new Book("Kitap1", 150, "Yazar1", "2001"));
        books.add(new Book("Kitap2", 95, "Yazar2", "2002"));
        books.add(new Book("Kitap3", 200, "Yazar3", "2003"));
        books.add(new Book("Kitap4", 120, "Yazar4", "2004"));
        books.add(new Book("Kitap5", 80, "Yazar5", "2005"));
        books.add(new Book("Kitap6", 60, "Yazar6", "2006"));
        books.add(new Book("Kitap7", 300, "Yazar7", "2007"));
        books.add(new Book("Kitap8", 110, "Yazar8", "2008"));
        books.add(new Book("Kitap9", 55, "Yazar9", "2009"));
        books.add(new Book("Kitap10", 180, "Yazar10", "2010"));

        // Kitap ismi ve yazar ismi eşleştiren bir Map oluşturma
        Map<String, String> bookAuthorMap = books.stream()
                .collect(Collectors.toMap(
                        Book::getName,
                        Book::getAuthor,
                        (existing, replacement) -> existing, // Çakışma durumunda eski değeri koru
                        java.util.LinkedHashMap::new // LinkedHashMap kullan
                ));

        // Map'i yazdırma
        System.out.println("Kitap ismi ve yazar eşleşmeleri:");
        bookAuthorMap.forEach((book, author) -> System.out.println(book + " - " + author));

        // 100'den fazla sayfa sayısına sahip kitapları filtreleme
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getPageCount() > 100)
                .toList();

        // Filtrelenmiş listeyi yazdırma
        System.out.println("\n100'den fazla sayfa sayısına sahip kitaplar:");
        filteredBooks.forEach(System.out::println);
    }
}
