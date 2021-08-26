package ticTacToe;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GameInformationView implements GameView {

    private final GameState gameState;

    public GameInformationView(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public Parent getView() {
        Label turnInformation = new Label();

        turnInformation.textProperty().bind(gameState.getStatus());
        turnInformation.setFont(Font.font(40));

        return turnInformation;
    }
}
