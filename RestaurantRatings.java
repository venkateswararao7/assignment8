import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant {
    private String name;
    private double rating;

    public Restaurant(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

class RatingAnalyzer {
    private List<Restaurant> restaurants;

    public RatingAnalyzer(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void analyzeRatings() {
        int[][] ratingRanges = {{1, 5}, {6, 10}};

        Map<String, Integer> ratingCounts = new HashMap<>();
        Map<String, Double> ratingTotals = new HashMap<>();
        for (int[] range : ratingRanges) {
            ratingCounts.put(range[0] + "-" + range[1], 0);
            ratingTotals.put(range[0] + "-" + range[1], 0.0);
        }

        for (Restaurant restaurant : restaurants) {
            double rating = restaurant.getRating();
            for (int[] range : ratingRanges) {
                if (rating >= range[0] && rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    ratingCounts.put(key, ratingCounts.get(key) + 1);
                    ratingTotals.put(key, ratingTotals.get(key) + rating);
                    break;
                }
            }
        }

        for (String key : ratingCounts.keySet()) {
            int count = ratingCounts.get(key);
            double totalRating = ratingTotals.get(key);
            double averageRating = count == 0 ? 0 : totalRating / count;
            System.out.println("Number of restaurants rated " + key + ": " + count);
            System.out.println("Average rating for restaurants rated " + key + ": " + averageRating);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("The Heritage Grill.", 3.2));
        restaurants.add(new Restaurant("Classic Cuisine Cafe.", 5.9));
        restaurants.add(new Restaurant("Timeless Tastes Tavern.", 6.7));
        restaurants.add(new Restaurant("Vintage Elegance Bistro.", 8.1));
        restaurants.add(new Restaurant("The Traditions Table.", 4.4));

        RatingAnalyzer analyzer = new RatingAnalyzer(restaurants);
        analyzer.analyzeRatings();
    }
}
