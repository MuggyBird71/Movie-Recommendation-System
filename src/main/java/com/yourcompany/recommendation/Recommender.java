package src.main.java.com.yourcompany.recommendation;

import java.util.ArrayList;

public interface Recommender {
    ArrayList<Movie> recommendMovies(String userPreference);
}
