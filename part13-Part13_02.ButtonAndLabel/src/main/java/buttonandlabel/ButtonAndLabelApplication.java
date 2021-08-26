package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("Button");
        Label label = new Label("Label");

        FlowPane componentGroup = new FlowPane();

        componentGroup.getChildren().addAll(button, label);

        Scene view = new Scene(componentGroup);

        stage.setScene(view);

        stage.setTitle("ButtonAndLabelApplication");
        stage.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
