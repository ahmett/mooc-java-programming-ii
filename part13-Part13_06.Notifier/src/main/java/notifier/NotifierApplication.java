package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        VBox layout = new VBox();

        Button button = new Button("Update");
        TextField textArea = new TextField();
        Label label = new Label();

        layout.getChildren().addAll(textArea, button, label);

        Scene view = new Scene(layout);

        button.setOnAction(actionEvent -> label.setText(textArea.getText()));

        stage.setScene(view);
        stage.setTitle(NotifierApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
