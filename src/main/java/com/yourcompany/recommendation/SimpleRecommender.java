package src.main.java.com.yourcompany.recommendation;

import java.util.ArrayList;

public class SimpleRecommender implements Recommender {
    private ArrayList<Movie> movies;

    public SimpleRecommender(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public ArrayList<Movie> recommendMovies(String userPreference) {
        ArrayList<Movie> recommended = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(userPreference)) {
                recommended.add(movie);
            }
        }
        return recommended;
    }
}
