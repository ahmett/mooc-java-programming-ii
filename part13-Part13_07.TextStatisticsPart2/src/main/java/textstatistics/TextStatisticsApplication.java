package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();

        HBox texts = new HBox();
        texts.setSpacing(25);

        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");

        texts.getChildren().addAll(letters, words, longestWord);

        layout.setCenter(textArea);
        layout.setBottom(texts);

        Scene view = new Scene(layout);

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            letters.setText("Letters: " + newValue.length());

            String[] parts = newValue.split(" ");

            words.setText("Words: " + parts.length);
            longestWord.setText("The longest word is: " + Arrays.stream(parts).max(Comparator.comparing(String::length)).get());
        });

        stage.setScene(view);
        stage.setTitle(TextStatisticsApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}