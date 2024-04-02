import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;
    
    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }
    
    public String getRating() {
        return rating;
    }
    
    public double getRatingValue() {
        return ratingValue;
    }
}

class MovieAnalyzer {
    private List<Movie> movies;
    
    public MovieAnalyzer(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void analyzeMovies() {
        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> movieAverages = new HashMap<>();
        
        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();
            
            movieCounts.put(rating, movieCounts.getOrDefault(rating, 0) + 1);
            
            movieAverages.put(rating, movieAverages.getOrDefault(rating, 0.0) + ratingValue);
        }
        
        for (String rating : movieAverages.keySet()) {
            double sum = movieAverages.get(rating);
            int count = movieCounts.get(rating);
            double average = sum / count;
            movieAverages.put(rating, average);
        }
        
        for (String rating : movieCounts.keySet()) {
            System.out.println("Number of movies rated " + rating + ": " + movieCounts.get(rating));
            System.out.println("Average rating for movies rated " + rating + ": " + movieAverages.get(rating));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("FirstMovie", "PG-13", 4.8));
        movies.add(new Movie("SecondMovie", "PG", 2.7));
        movies.add(new Movie("ThirdMovie", "R", 3.8));
        movies.add(new Movie("FourthMovie", "PG-13", 4.9));
        movies.add(new Movie("FifthMovie", "R", 2.4));
        
        MovieAnalyzer analyzer = new MovieAnalyzer(movies);
        analyzer.analyzeMovies();
    }
}
