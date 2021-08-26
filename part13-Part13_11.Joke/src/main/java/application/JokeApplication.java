package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 1. Create main layout
        BorderPane layout = new BorderPane();

        // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Create buttons for menu
        Button showQuestion = new Button("Joke");
        Button showAnswer = new Button("Answer");
        Button showExplanation = new Button("Explanation");

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(showQuestion, showAnswer, showExplanation);

        // 1.4. Add menu to top of layout
        layout.setTop(menu);

        // 2. Add subviews and add them to the menu buttons
        // 2.1. Create subview layout
        StackPane questionLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("I don't know");

        // 2.2. Add subviews to button. Pressing the buttons will change the view
        showQuestion.setOnAction((event) -> layout.setCenter(questionLayout));
        showAnswer.setOnAction((event) -> layout.setCenter(answerLayout));
        showExplanation.setOnAction((event) -> layout.setCenter(explanationLayout));

        // 2.3. Set initial view
        layout.setCenter(questionLayout);

        // 3. Create main scene with layout
        Scene scene = new Scene(layout);

        // 4. Show the main scene
        stage.setScene(scene);
        stage.setTitle(JokeApplication.class.getSimpleName());
        stage.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

}
