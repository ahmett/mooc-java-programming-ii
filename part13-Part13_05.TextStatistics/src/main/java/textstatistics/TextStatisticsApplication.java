package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();

        HBox texts = new HBox();
        texts.getChildren().addAll(new Label("Letters: 0"), new Label("Words: 0"), new Label("The longest word is:"));

        layout.setCenter(textArea);
        layout.setBottom(texts);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.setTitle(TextStatisticsApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
