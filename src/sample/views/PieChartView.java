package sample.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class PieChartView {
    private GridPane view;

    public PieChartView(LinkedHashMap<String, Integer> keywordIndex, String topNo) {
        configureLayout();
        createLayoutControls(keywordIndex, topNo);
    }

    private void createLayoutControls(LinkedHashMap<String, Integer> keywordList, String topNo) {
        final Label caption = new Label("");
        PieChart pieChart = new PieChart();
        pieChart.setTitle(topNo);
        for(Map.Entry<String, Integer> entry: keywordList.entrySet()) {
            pieChart.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        view.addRow(0, pieChart);
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
