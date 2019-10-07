package sample.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class LoadXMLView {
    private GridPane view;
    private Button btnSource;
    private Button btnParse;
    private Button btnContinueToSearch;
    private Label lblSource;
    private HBox hboxSource;
    private HBox hboxParsing;
    private TextArea txtXML;

    public LoadXMLView() {
        configureLayout();
        createLayoutControls();
    }

    public Parent asParent(){
        return view;
    }

    public void setLblSource(String source) {
        lblSource.setText(source);
    }

    public String getTxtXML() {
        return txtXML.getText();
    }

    public void setTxtXML(String txt){
        txtXML.setText(txt);
    }

    private void createLayoutControls(){
        btnSource = new Button("Choose Source");
        lblSource = new Label("");
        btnParse = new Button("Parse XML");
        hboxSource = new HBox(btnSource,lblSource );
        hboxSource.setSpacing(10);
        hboxParsing = new HBox(btnParse);
        hboxParsing.setSpacing(10);
        txtXML = new TextArea();
        btnContinueToSearch = new Button("Continue to search");

        view.addRow(0,hboxSource);
        view.addRow(1,hboxParsing);
        view.addRow(2, txtXML);
        view.addRow(3, btnContinueToSearch);
    }
    private void configureLayout(){
        view = new GridPane();

        view.setPadding(new Insets(10,10,10,10));
        view.setHgap(10);
        view.setVgap(10);
        view.setAlignment(Pos.CENTER);
    }

    public void addChooseFileListener(EventHandler<ActionEvent> listener){
        btnSource.setOnAction(listener);
    }

    public void addParseFileListener(EventHandler<ActionEvent> listener){
        btnParse.setOnAction(listener);
    }

    public void addContinueToSearchListener(EventHandler<ActionEvent> listener){
        btnContinueToSearch.setOnAction(listener);
    }
}
