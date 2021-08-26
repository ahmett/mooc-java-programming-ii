package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        Map<String, Map<Integer, Double>> values = parseData();

        values.keySet().forEach(party -> {
            XYChart.Series data = new XYChart.Series();

            data.setName(party);

            values.get(party).forEach((key, value) -> data.getData().add(new XYChart.Data(key, value)));

            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    private static Map<String, Map<Integer, Double>> parseData() {
        Map<String, Map<Integer, Double>> data = new HashMap<>();
        ArrayList<Integer> yearList = new ArrayList<>();

        try {
            AtomicBoolean yearsProcessed = new AtomicBoolean(false);

            Files.lines(Paths.get("partiesdata.tsv")).forEach(line -> {
                String[] parts = line.split("\t");

                if (!yearsProcessed.get()) {
                    for (int i = 1; i < parts.length; i++) {
                        yearList.add(Integer.parseInt(parts[i]));
                    }

                    yearsProcessed.set(true);
                } else {
                    HashMap<Integer, Double> entry = new HashMap<>();
                    String partyName = parts[0];

                    for (int i = 1; i < parts.length; i++) {
                        if (parts[i].equals("-")) continue;

                        int year = yearList.get(i - 1);
                        double percentage = Double.parseDouble(parts[i]);

                        entry.put(year, percentage);
                    }

                    data.put(partyName, entry);
                }

            });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return data;
    }

}
