package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1. Create the game state
        GameState gameState = new GameState();

        // 2. Create the subviews
        GameInformationView gameInformationView = new GameInformationView(gameState);
        GameBoardView gameBoardView = new GameBoardView(gameState);

        // 3. Create the higher-level layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        // 4. Add subviews to the layout
        layout.setTop(gameInformationView.getView());
        layout.setCenter(gameBoardView.getView());

        // 5. Create the main view and add the layout
        Scene view = new Scene(layout);

        // 6. Show the application
        stage.setResizable(false);
        stage.setScene(view);
        stage.setTitle(TicTacToeApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
