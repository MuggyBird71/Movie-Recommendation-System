package src.main.java.com.yourcompany.recommendation;

import java.io.*;
import java.util.ArrayList;

public class MovieFileHandler extends FileHandler {
    
    public MovieFileHandler(String filename) {
        super(filename);
    }

    @Override
    public ArrayList<Movie> readMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("File does not exist: " + filename);
            return movies;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    movies.add(new Movie(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + filename);
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public void writeMovies(ArrayList<Movie> movies) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (Movie movie : movies) {
                writer.println(movie.getTitle() + "," + movie.getGenre());
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + filename);
            e.printStackTrace();
        }
    }
}
