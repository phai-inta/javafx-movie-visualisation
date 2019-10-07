package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sample.controllers.LoadXMLController;
import sample.models.LoadXMLModel;
import sample.views.LoadXMLView;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        LoadXMLView loadXMLView = new LoadXMLView();
        LoadXMLModel loadXMLModel = new LoadXMLModel();
        LoadXMLController loadXMLController = new LoadXMLController(stage, loadXMLView, loadXMLModel);

        Scene scene = new Scene(loadXMLView.asParent(),450,300);
        stage.setScene(scene);
        stage.setTitle("IMDB XML File Parsing System");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
