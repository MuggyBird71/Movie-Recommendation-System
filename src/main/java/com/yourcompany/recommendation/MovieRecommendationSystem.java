package src.main.java.com.yourcompany.recommendation;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.print("Enter your favorite genre: ");
        String genre = scanner.nextLine();

        // Specify the path to the CSV file here
        String csvFilePath = "src/main/java/com/yourcompany/recommendation/movies.csv";  // Adjust this path as needed

        MovieFileHandler fileHandler = new MovieFileHandler(csvFilePath);
        ArrayList<Movie> movies = fileHandler.readMovies();

        Recommender recommender = new SimpleRecommender(movies);
        ArrayList<Movie> recommendations = recommender.recommendMovies(genre);

        if (recommendations.isEmpty()) {
            System.out.println("No movies found for the genre: " + genre);
        } else {
            System.out.println("Movies recommended for you:");
            for (Movie movie : recommendations) {
                System.out.println(movie.getTitle());
            }
        }
        scanner.close();
    }
}
