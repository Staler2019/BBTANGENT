// P.Y. copyright
package game;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application implements Initializable {
    // writing fxml setting
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(".fxml")); // TODO: making .fxml
        primaryStage.setTitle("BBTANGENT Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void shoot() {

    }

    // end writing fxml setting
    public static void main(String[] args) {
        launch(args);
    }
}