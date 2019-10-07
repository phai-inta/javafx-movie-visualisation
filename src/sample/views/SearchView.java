package sample.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class SearchView {
    private GridPane view;
    private Label lblForm;
    private Label lblKeyword;
    private TextField txtKeyword;
    private Button btnSearch;
    private TextArea txtResult;

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

    private void createLayoutControls(){
        lblForm = new Label("Enter a keyword to search for movies");
        lblKeyword = new Label("Keyword: ");
        txtKeyword = new TextField();
        btnSearch = new Button("Search");
        txtResult = new TextArea();

        view.addRow(0,lblForm);
        view.addRow(1,lblKeyword);
        view.addRow(2, txtKeyword);
        view.addRow(3, btnSearch);
        view.addRow(4, txtResult);
    }

    private void configureLayout(){
        view = new GridPane();

        view.setPadding(new Insets(10,10,10,10));
        view.setHgap(10);
        view.setVgap(10);
        view.setAlignment(Pos.CENTER);
    }

    public void addSearchMovieListener(EventHandler<ActionEvent> listener){
        btnSearch.setOnAction(listener);
    }

    public Parent asParent(){
        return view;
    }
}
