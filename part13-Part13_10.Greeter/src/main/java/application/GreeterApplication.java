package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // First layout -- START
        GridPane firstLayout = new GridPane();
        firstLayout.setVgap(8);
        firstLayout.setAlignment(Pos.CENTER);

        Label label = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button button = new Button("Start");

        firstLayout.add(label, 0, 0);
        firstLayout.add(textField, 0, 1);
        firstLayout.add(button, 0, 2);
        // First layout -- END

        // Second layout -- START
        VBox secondLayout = new VBox();
        secondLayout.setAlignment(Pos.CENTER);

        Label greetingLabel = new Label();

        secondLayout.getChildren().add(greetingLabel);
        // Second layout -- END

        // Views
        Scene firstView = new Scene(firstLayout, 300, 200);
        Scene secondView = new Scene(secondLayout, 300, 200);

        // Events
        button.setOnAction(actionEvent -> {
            greetingLabel.setText("Welcome " + textField.getText() + "!");
            stage.setScene(secondView);
        });

        stage.setScene(firstView);
        stage.setTitle(GreeterApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

}
