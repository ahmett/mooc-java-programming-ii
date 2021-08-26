package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        VBox options = new VBox();

        BorderPane monthlySavingsOption = new BorderPane();
        monthlySavingsOption.setPadding(new Insets(15));

        Label monthlySavingsText = new Label("Monthly savings");

        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setValue(25.1);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
//        monthlySavingsSlider.setMajorTickUnit(25);
//        monthlySavingsSlider.setBlockIncrement(25);
//        monthlySavingsSlider.setSnapToTicks(true);
//        monthlySavingsSlider.setMinorTickCount(0);

        Label monthlySavingsSliderValue = new Label("" + monthlySavingsSlider.valueProperty().intValue());

        monthlySavingsOption.setLeft(monthlySavingsText);
        monthlySavingsOption.setCenter(monthlySavingsSlider);
        monthlySavingsOption.setRight(monthlySavingsSliderValue);

        BorderPane yearlyInterestRateOption = new BorderPane();
        yearlyInterestRateOption.setPadding(new Insets(15));

        Label yearlyInterestRateText = new Label("Yearly interest rate");

        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
//        yearlyInterestRateSlider.setMajorTickUnit(1);
//        yearlyInterestRateSlider.setBlockIncrement(1);
//        yearlyInterestRateSlider.setSnapToTicks(true);
//        yearlyInterestRateSlider.setMinorTickCount(0);

        Label yearlyInterestRateSliderValue = new Label("" + yearlyInterestRateSlider.valueProperty().intValue());

        yearlyInterestRateOption.setLeft(yearlyInterestRateText);
        yearlyInterestRateOption.setCenter(yearlyInterestRateSlider);
        yearlyInterestRateOption.setRight(yearlyInterestRateSliderValue);

        options.getChildren().addAll(monthlySavingsOption, yearlyInterestRateOption);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);

        XYChart.Series monthlySavingsSeries = new XYChart.Series();
        XYChart.Series monthlySavingsWithInterestRateSeries = new XYChart.Series();

        lineChart.getData().addAll(monthlySavingsSeries, monthlySavingsWithInterestRateSeries);

//        calculateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, monthlySavingsWithInterestRateSeries);
        monthlySavingsSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            monthlySavingsSliderValue.setText("" + monthlySavingsSlider.valueProperty().intValue());
            calculateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, monthlySavingsWithInterestRateSeries);
        });

//        calculateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, monthlySavingsWithInterestRateSeries);
        yearlyInterestRateSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            yearlyInterestRateSliderValue.setText("" + yearlyInterestRateSlider.valueProperty().intValue());
            calculateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, monthlySavingsWithInterestRateSeries);
        });

        layout.setTop(options);
        layout.setCenter(lineChart);

        Scene view = new Scene(layout, 640, 480);

        stage.setScene(view);
        stage.setTitle(SavingsCalculatorApplication.class.getSimpleName());
        stage.show();
    }

    private void calculateSavings(double monthlySavings, double interestRate, XYChart.Series monthlySavingsSeries, XYChart.Series monthlySavingsWithInterestRateSeries) {
        monthlySavingsSeries.getData().clear();
        monthlySavingsWithInterestRateSeries.getData().clear();

        double currentMonthlySavings = 0;
        double currentInterestRate = 0;

        for (int i = 0; i <= 30; i++) {
            monthlySavingsSeries.getData().add(new XYChart.Data(i, currentMonthlySavings));
            monthlySavingsWithInterestRateSeries.getData().add(new XYChart.Data(i, currentInterestRate));

            currentMonthlySavings += monthlySavings * 12;
            currentInterestRate = (currentInterestRate + monthlySavings * 12) * (1.0 + interestRate / 100.0);
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
