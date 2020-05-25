/********************************
 *	P.Y. copyright	 			*
 *	Game Loader        		   	*
 ********************************/
package game;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BBTANGENT extends Application implements Initializable {
    public static Stage currStage;
    public static Scene startScene;

    @FXML

    @Override
    public void start(Stage primaryStage) throws Exception {
        currStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../../assets/fxmls/StartScene.fxml"));
        startScene = new Scene(root);

        currStage.setTitle("BBTANGENT");
        currStage.setScene(startScene);
        currStage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    public void onStartPressed() throws IOException { // select difficulty
        Parent diff = FXMLLoader.load(getClass().getResource("../../assets/fxmls/DifficultyScene.fxml"));
        Scene diffScene = new Scene(diff);
        diffScene.getRoot().requestFocus();
        currStage.setScene(diffScene);
    }

    @FXML
    public void onInfoPressed() {

    }

    public static void main(String[] args) {
        // readPlayHistory();
        try {
            File playerData = new File("../../data/playerData.txt");
            // check if created
            if (playerData.createNewFile()) {
                System.out.println("File created: " + playerData.getName());
            } else {
                System.out.println("File already exists.");
                // read data
                Scanner dataReader = new Scanner(playerData);
                String a = dataReader.nextLine();
                if (!a.equals("")) {
                    Global.storeHSName(a.split(" ")[1]);
                    a = dataReader.nextLine();
                    Global.storeHS(Integer.valueOf(a.split(" ")[1]));
                }
                dataReader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        launch(args);
    }

}