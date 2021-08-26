package ticTacToe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;
import java.util.Objects;

public class GameState {

    private Character currentTurn;
    private final Character[] fields;
    private final StringProperty status;

    public GameState() {
        this.currentTurn = 'X';
        this.fields = new Character[9];
        this.status = new SimpleStringProperty("Turn: " + currentTurn);
    }

    public Character getCurrentTurn() {
        return currentTurn;
    }

    public StringProperty getStatus() {
        return status;
    }

    public void move(int i) {
        fields[i] = currentTurn;
        currentTurn = currentTurn == 'X' ? 'O' : 'X';

        if (isTie() || hasWinner()) {
            status.set("The end!");
        } else {
            status.set("Turn: " + currentTurn.toString());
        }
    }

    public boolean isTie() {
        if (hasWinner()) {
            return false;
        }

        return Arrays.stream(fields).noneMatch(Objects::isNull);
    }

    public boolean hasWinner() {
        return checkHorizontallyForWinner() || checkVerticallyForWinner() || checkDiagonallyForWinner();
    }

    private boolean checkHorizontallyForWinner() {
        for (int i = 0; i < 9; i += 3) {
            if (fields[i] == null) continue;
            if (fields[i].equals(fields[i+1]) && fields[i].equals(fields[i+2])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkVerticallyForWinner() {
        for (int i = 0; i < 3; i++) {
            if (fields[i] == null) continue;
            if (fields[i].equals(fields[i+3]) && fields[i].equals(fields[i+6])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDiagonallyForWinner() {
        if (fields[0] != null && fields[0].equals(fields[4]) && fields[0].equals(fields[8])) {
            return true;
        }

        return fields[2] != null && fields[2].equals(fields[4]) && fields[2].equals(fields[6]);
    }
}
