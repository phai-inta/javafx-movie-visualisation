package sample.models;

import java.util.*;

public class SearchModel {
    private ArrayList<Movie> movies;
    Hashtable<String, Integer> keywordIndex;

    public SearchModel(ArrayList<Movie> movies, Hashtable<String, Integer> keywordIndex){
        this.movies = movies;
        this.keywordIndex = keywordIndex;
    }

    /**
     * Find all movies that have the keyword
     * @param keyword
     */
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

    /**
     * Get the top keywords index
     * @param movies
     * @param topString
     */
    public LinkedHashMap<String, Integer> getFilteredIndex(ArrayList<Movie> movies, String topString) {
        Hashtable<String, Integer> filteredKeywords = new Hashtable<>();

        for (Movie movie : movies) {
            ArrayList<String> keywords = movie.getKeywords();
            for (String word : keywords) {
                if (keywordIndex.contains(word)) ;
                filteredKeywords.put(word, keywordIndex.get(word));
            }
        }
        LinkedHashMap<String, Integer> sorted = getTopKeywords(filteredKeywords, topString);
        return sorted;
    }

    /**
     * Sort the index by frequencies
     * @param filteredKeywords
     * @param topString
     * @reference https://stackoverflow.com/questions/7170871/iterating-through-a-linkedhashmap-in-reverse-order
     */
    public LinkedHashMap<String, Integer> getTopKeywords(Hashtable<String, Integer> filteredKeywords, String topString) {
        int topNo;
        if (topString.contains("3")) {
            topNo = 3;
        } else if (topString.contains("5")) {
            topNo = 5;
        } else if (topString.contains("8")) {
            topNo = 8;
        } else {
            topNo = 10;
        }
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> finalSorted = sorted;
        filteredKeywords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topNo)
                .forEachOrdered(x -> finalSorted.put(x.getKey(), x.getValue()));
        return finalSorted;
    }
}