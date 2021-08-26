package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // First layout
        BorderPane firstLayout = new BorderPane();

        Button firstButton = new Button("To the second view!");

        firstLayout.setTop(new Label("First view!"));
        firstLayout.setCenter(firstButton);

        // Second layout
        VBox secondLayout = new VBox();

        Button secondButton = new Button("To the third view!");

        secondLayout.getChildren().addAll(secondButton, new Label("Second view!"));

        // Third layout
        GridPane thirdLayout = new GridPane();

        Button thirdButton = new Button("To the first view!");

        thirdLayout.add(new Label("Third view!"), 0, 0);
        thirdLayout.add(thirdButton, 1, 1);

        // Views
        Scene firstView = new Scene(firstLayout);
        Scene secondView = new Scene(secondLayout);
        Scene thirdView = new Scene(thirdLayout);

        // Events
        firstButton.setOnAction(actionEvent -> stage.setScene(secondView));
        secondButton.setOnAction(actionEvent -> stage.setScene(thirdView));
        thirdButton.setOnAction(actionEvent -> stage.setScene(firstView));

        stage.setScene(firstView);
        stage.setTitle(MultipleViews.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
