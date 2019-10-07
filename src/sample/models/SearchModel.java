package sample.models;

import java.util.ArrayList;
import java.util.Hashtable;

public class SearchModel {
    private ArrayList<Movie> movies;

    public SearchModel(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> findMovieByKeyword(String keyword){
        ArrayList<Movie> result = new ArrayList<>();
        for(Movie movie : movies){
            ArrayList<String> keywords = movie.getKeywords();
            if(keywords.contains(keyword)){
                result.add(movie);
            }
        }
        return result;
    }
}
