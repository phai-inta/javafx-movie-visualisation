package sample.models;

import java.util.ArrayList;

/**
 * POJO class for a Movie that matches with the XML format
 */
public class Movie {
    private String title;
    private int year;
    private float rating;
    private ArrayList<Person> directors;
    private ArrayList<String> genres;
    private ArrayList<String> keywords;

    public Movie(String title, int year, float rating, ArrayList<Person> directors, ArrayList<String> genres, ArrayList<String> keywords) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.directors = directors;
        this.genres = genres;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<Person> getDirectors() {
        return directors;
    }

    public String getDirectorsNames(){
        String directorsNames = "";
        for(Person person: directors){
            directorsNames += person.getName() + ", ";
        }
        return directorsNames.substring(0, directorsNames.length() - 2);
    }

    public void setDirectors(ArrayList<Person> directors) {
        this.directors = directors;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
