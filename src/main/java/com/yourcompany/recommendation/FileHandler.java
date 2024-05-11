package src.main.java.com.yourcompany.recommendation;

import java.util.ArrayList;

public abstract class FileHandler {
    protected String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    public abstract ArrayList<Movie> readMovies();
    public abstract void writeMovies(ArrayList<Movie> movies);
}
