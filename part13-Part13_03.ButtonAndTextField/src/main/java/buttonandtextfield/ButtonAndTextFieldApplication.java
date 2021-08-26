package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("Button");
        TextField textField = new TextField("TextField");

        FlowPane componentGroup = new FlowPane();

        componentGroup.getChildren().addAll(button, textField);

        Scene scene = new Scene(componentGroup);

        stage.setScene(scene);

        stage.setTitle(ButtonAndTextFieldApplication.class.getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
