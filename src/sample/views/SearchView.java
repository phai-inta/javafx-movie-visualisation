package sample.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class SearchView {
    private GridPane view;
    private TextArea txtResult;
    private TextField txtKeyword;
    private Label lblForm, lblKeyword, lblVisualise;
    private Button btnSearch, barBtn, pieBtn;
    private ToggleGroup group;
    private Integer selectedNo;
    private RadioButton selectedFilter;

    public SearchView() {
        configureLayout();
        createLayoutControls();
    }

    public String getTxtKeyword() {
        return txtKeyword.getText();
    }

    public String getTxtResult() {
        return txtResult.getText();
    }

    public void setTxtResult(String txt) {
        txtResult.setText(txt);
    }

    public String getSelectedFiler() {
        return selectedFilter.getText();
    }

    private void createLayoutControls(){
        lblForm = new Label("Enter a keyword to search for movies");
        lblKeyword = new Label("Keyword: ");
        lblVisualise = new Label("Please select visualisation options");

        txtKeyword = new TextField();
        txtResult = new TextArea();
        txtResult.setPrefHeight(250);
        txtResult.setPrefWidth(500);

        btnSearch = new Button("Search");
        barBtn = new Button("Bar chart");
        pieBtn = new Button("Pie chart");

        group = new ToggleGroup();
        RadioButton top3 = new RadioButton("Top-3 correlated keywords");
        RadioButton top5 = new RadioButton("Top-5 correlated keywords");
        RadioButton top8 = new RadioButton("Top-8 correlated keywords");
        RadioButton top10 = new RadioButton("Top-10 corrlated keywords");
        top3.setToggleGroup(group);
        top5.setToggleGroup(group);
        top8.setToggleGroup(group);
        top10.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                    selectedFilter = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(top3, top5, top8, top10);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(pieBtn, barBtn);

        view.addRow(0,lblForm);
        view.addRow(1,lblKeyword);
        view.addRow(2, txtKeyword);
        view.addRow(3, btnSearch);
        view.addRow(4, txtResult);
        view.addRow(5, lblVisualise);
        view.addRow(6, vBox);
        view.addRow(7, hBox);
    }

    private void configureLayout(){
        view = new GridPane();
        view.setPadding(new Insets(10,10,10,10));
        view.setHgap(10);
        view.setVgap(10);
        view.setAlignment(Pos.TOP_CENTER);
    }

    public void addSearchMovieListener(EventHandler<ActionEvent> listener){
        btnSearch.setOnAction(listener);
    }

    public Parent asParent(){
        return view;
    }

    public void addBarCharBtnListener(EventHandler<ActionEvent> listener){
        barBtn.setOnAction(listener);
    }

    public void addPieCharBtnListener(EventHandler<ActionEvent> listener){
        pieBtn.setOnAction(listener);
    }
}
