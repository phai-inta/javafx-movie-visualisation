package sample.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.LoadXMLModel;
import sample.models.SearchModel;
import sample.views.BarChartView;
import sample.views.LoadXMLView;
import sample.views.SearchView;

public class BarCharController {
    private BarChartView view;

    public BarCharController(Stage stage) {

        this.view.addBackBtnListener(e -> {
            SearchView searchView = new SearchView();
            SearchModel searchModel = new SearchModel();
            SearchController searchController = new SearchController(stage, searchView, searchModel);
            stage.setScene(new Scene(searchView.asParent()));
        });
    }
}