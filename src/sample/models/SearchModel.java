package sample.models;

import java.util.*;

public class SearchModel {
    private ArrayList<Movie> movies;
    Hashtable<String, Integer> keywordIndex;

    public SearchModel(ArrayList<Movie> movies, Hashtable<String, Integer> keywordIndex){
        this.movies = movies;
        this.keywordIndex = keywordIndex;
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

    public LinkedHashMap<String, Integer> filteredIndex(ArrayList<Movie> movies, String topString) {
        Hashtable<String, Integer> filteredKeywords = new Hashtable<>();

        for (Movie movie : movies) {
            ArrayList<String> keywords = movie.getKeywords();
            for (String word : keywords) {
                if (keywordIndex.contains(word)) ;
                filteredKeywords.put(word, keywordIndex.get(word));
            }
        }
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        sorted = getTopKeywords(filteredKeywords, topString);
        return sorted;
    }

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
//        System.out.println("======all sorted keywords======");
//        for(Map.Entry<String, Integer> entry: finalSorted.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + "," + "Frequency: " + entry.getValue());
//        }
        return finalSorted;
    }
}