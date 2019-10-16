package sample.controllers;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.models.LoadXMLModel;
import sample.models.Movie;
import sample.models.SearchModel;
import sample.views.LoadXMLView;
import sample.views.SearchView;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

public class LoadXMLController {
    private LoadXMLView view;
    private LoadXMLModel model;
    private Stage stage;
    File selectedFile = new File("");
    private ArrayList<Movie> movies;

    public LoadXMLController(Stage stage, LoadXMLView view, LoadXMLModel model) {
        this.view = view;
        this.model = model;

        this.view.addChooseFileListener(e -> {
            FileChooser file = new FileChooser();
            file.setTitle("Open File");
            selectedFile = file.showOpenDialog(stage);
            view.setLblSource(selectedFile.getName());
        });
        this.view.addParseFileListener(e -> {
            movies = model.parseXMLFile(selectedFile);
            view.setTxtXML("");
            for(Movie movie : movies){
                view.setTxtXML(view.getTxtXML() + "Title: " + movie.getTitle() + "\n");
                view.setTxtXML(view.getTxtXML() + "Year: " + movie.getYear() + "\n");
                view.setTxtXML(view.getTxtXML() + "Rating: " + movie.getRating() + "\n");
                view.setTxtXML(view.getTxtXML() + "Director: " + movie.getDirectorsNames() + "\n");
                view.setTxtXML(view.getTxtXML() + "Genres: " + String.join(", ", movie.getGenres()) + "\n");
                view.setTxtXML(view.getTxtXML() + "Keywords: " + String.join(", ", movie.getKeywords()) + "\n\n");
            }
        });
        this.view.addContinueToSearchListener( e -> {
            Hashtable<String, Integer> keywordList = model.createKeywordIndex(movies);
            SearchView searchView = new SearchView();
            SearchModel searchModel = new SearchModel(movies, keywordList);
            SearchController searchController = new SearchController(stage, searchView, searchModel);
            stage.setTitle("Movie Search");
            stage.setScene(new Scene(searchView.asParent(),600,600));
        });
    }
}
