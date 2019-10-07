package sample.controllers;

import sample.models.Movie;
import sample.models.SearchModel;
import sample.views.SearchView;

import java.util.ArrayList;

public class SearchController {
    private SearchView view;
    private SearchModel model;

    public SearchController(SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;

        this.view.addSearchMovieListener(e -> {
            view.setTxtResult("");
            String keyword = view.getTxtKeyword();
            ArrayList<Movie> results = model.findMovieByKeyword(keyword);
            for(Movie movie : results){
                view.setTxtResult(view.getTxtResult() + "Title: " + movie.getTitle() + "\n");
                view.setTxtResult(view.getTxtResult() + "Year: " + movie.getYear() + "\n");
                view.setTxtResult(view.getTxtResult() + "Rating: " + movie.getRating() + "\n");
                view.setTxtResult(view.getTxtResult() + "Director: " + movie.getDirectorsNames() + "\n");
                view.setTxtResult(view.getTxtResult() + "Genres: " + String.join(", ", movie.getGenres()) + "\n");
                view.setTxtResult(view.getTxtResult() + "Keywords: " + String.join(", ", movie.getKeywords()) + "\n\n");
            }
        });
    }
}
