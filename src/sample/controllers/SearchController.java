package sample.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.Movie;
import sample.models.SearchModel;
import sample.views.BarChartView;
import sample.views.PieChartView;
import sample.views.SearchView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class SearchController {
    private SearchView view;
    private SearchModel model;
    private ArrayList<Movie> movies;
    private Hashtable<String, Integer> keywordList;

    /**
     * Constructor for Search Controller to connect view and model
     * and set up the event handlers
     * @param stage
     * @param view
     * @param model
     */
    public SearchController(Stage stage, SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;

        this.view.addSearchMovieListener(e -> {
            view.setTxtResult("");
            String keyword = view.getTxtKeyword();
            movies = model.findMovieByKeyword(keyword);
            for(Movie movie : movies){
                view.setTxtResult(view.getTxtResult() + "Title: " + movie.getTitle() + "\n");
                view.setTxtResult(view.getTxtResult() + "Year: " + movie.getYear() + "\n");
                view.setTxtResult(view.getTxtResult() + "Rating: " + movie.getRating() + "\n");
                view.setTxtResult(view.getTxtResult() + "Director: " + movie.getDirectorsNames() + "\n");
                view.setTxtResult(view.getTxtResult() + "Genres: " + String.join(", ", movie.getGenres()) + "\n");
                view.setTxtResult(view.getTxtResult() + "Keywords: " + String.join(", ", movie.getKeywords()) + "\n\n");
            }
        });

        this.view.addBarCharBtnListener(e -> {
            String topString = view.getSelectedFilter(); //get selected top filter
            LinkedHashMap<String, Integer> filteredList = model.getFilteredIndex(movies, topString);
            BarChartView barChartView = new BarChartView(filteredList, topString);
            BarChartController barChartController = new BarChartController(barChartView);
            Stage stage1 = new Stage();
            stage1.setTitle("Bar chart");
            stage1.setScene(new Scene(barChartView.asParent(),800,400));
            stage1.show();
        });

        this.view.addPieCharBtnListener(e -> {
            String topString = view.getSelectedFilter(); //get selected top filter
            LinkedHashMap<String, Integer> filteredList = model.getFilteredIndex(movies, topString);
            PieChartView pieChartView = new PieChartView(filteredList, topString);
            PieChartController pieChartController = new PieChartController(pieChartView);
            Stage stage1 = new Stage();
            stage1.setTitle("Pie chart");
            stage1.setScene(new Scene(pieChartView.asParent(),800,400));
            stage1.show();
        });
    }
}