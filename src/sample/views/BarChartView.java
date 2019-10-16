package sample.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BarChartView {
    private GridPane view;
    private Label label;
    private Button backBtn;

    public BarChartView() {
        configureLayout();
        createLayoutControls();
    }

    public Parent asParent(){
        return view;
    }

    private void configureLayout(){
        view = new GridPane();
        view.setPadding(new Insets(10,10,10,10));
        view.setHgap(10);
        view.setVgap(10);
        //view.setAlignment(Pos.CENTER);
    }

    private void createLayoutControls(){

    }
}
