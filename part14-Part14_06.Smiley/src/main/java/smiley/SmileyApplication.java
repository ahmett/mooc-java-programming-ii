package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Canvas paintingCanvas = new Canvas(400,400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        painter.setFill(Color.BLACK);

        // Left eye
        painter.fillRect(100, 80, 50, 50);
        // Right eye
        painter.fillRect(250, 80, 50, 50);
        // Mouth
        painter.fillRect(100, 250, 200, 50);
        // Mouth left
        painter.fillRect(50, 200, 50, 50);
        // Mouth right
        painter.fillRect(300, 200, 50, 50);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        Scene view = new Scene(paintingLayout);

        stage.setScene(view);
        stage.setTitle(SmileyApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
