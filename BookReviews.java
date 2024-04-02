import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private String title;
    private int rating;

    public Book(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

class BookAnalyzer {
    private List<Book> books;

    public BookAnalyzer(List<Book> books) {
        this.books = books;
    }

    public void analyzeBooks() {
        int[] ratingRanges = {1, 5, 6, 10};
        int[] ratingCounts = new int[ratingRanges.length - 1];

        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        for (Book book : books) {
            int rating = book.getRating();

            for (int i = 0; i < ratingRanges.length - 1; i++) {
                if (rating >= ratingRanges[i] && rating <= ratingRanges[i + 1]) {
                    ratingCounts[i]++;
                    break;
                }
            }

            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        for (int i = 0; i < ratingCounts.length; i++) {
            System.out.println("Number of books with rating " + (ratingRanges[i] + 1) + " to " + (ratingRanges[i + 1]) + " stars: " + ratingCounts[i]);
        }
        System.out.println("Positive reviews: " + positiveCount);
        System.out.println("Neutral reviews: " + neutralCount);
        System.out.println("Negative reviews: " + negativeCount);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Hamlet", 4));
        books.add(new Book("The Tempest", 6));
        books.add(new Book("Romeo & Juliet", 8));
        books.add(new Book("Macbeth", 9));
        books.add(new Book("The comedy of Errors", 5));

        BookAnalyzer analyzer = new BookAnalyzer(books);
        analyzer.analyzeBooks();
    }
}
