package sample.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.awt.*;
import java.util.*;

public class BarChartView {
    private GridPane view;

    public BarChartView(LinkedHashMap<String, Integer> keywordIndex, String topNo) {
        configureLayout();
        createLayoutControls(keywordIndex, topNo);
    }

    private void createLayoutControls(LinkedHashMap<String, Integer> keywordList, String topNo){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Keywords");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Values");

        BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
        bc.setTitle(topNo);

        XYChart.Series chart = new XYChart.Series();
        chart.setName("Co-occuring keyords");

        for(Map.Entry<String, Integer> entry: keywordList.entrySet()) {
            chart.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }

        bc.getData().add(chart);
        view.addRow(0, bc);
    }

    public Parent asParent(){
        return view;
    }

    private void configureLayout(){
        view = new GridPane();
        view.setPadding(new Insets(10,10,10,10));
        view.setHgap(10);
        view.setVgap(10);
        view.setAlignment(Pos.CENTER);
    }
}
