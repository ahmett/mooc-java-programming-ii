package ticTacToe;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GameBoardView implements GameView {

    private final GameState gameState;

    public GameBoardView(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public Parent getView() {
        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int column = 1;
        int row = 0;

        for (int i = 0; i < 9; i++) {
            gridPane.add(createButton(i), column, row);

            if (column % 3 == 0) {
                column = 1;
                row++;
            } else {
                column++;
            }
        }

        return gridPane;
    }

    private Button createButton(int i) {
        Button button = new Button(" ");

        button.setFont(new Font(40));
        button.setPrefSize(90, 90);

        button.setOnMouseClicked(mouseEvent -> {
            if (gameState.hasWinner() || gameState.isTie()) return;

            button.setText(Character.toString(gameState.getCurrentTurn()));
            gameState.move(i);
            button.setDisable(true);
        });

        return button;
    }
}
