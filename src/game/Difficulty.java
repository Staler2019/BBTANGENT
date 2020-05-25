package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Difficulty implements Initializable{

    public void turnToGame() throws IOException {
        Parent game = FXMLLoader.load(getClass().getResource("../../assets/fxmls/GameScene.fxml"));
        Scene gameScene = new Scene(game);
        gameScene.getRoot().requestFocus();
        BBTANGENT.currStage.setScene(gameScene);
    }

    @FXML
    public void diff_1Pressed() throws IOException {
        Global.setDifficulty(1);
        turnToGame();
    }

    @FXML
    public void diff_2Pressed() throws IOException {
        Global.setDifficulty(2);
        turnToGame();
    }

    @FXML
    public void diff_3Pressed() throws IOException {
        Global.setDifficulty(3);
        turnToGame();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { // name of pressedThing

    }

}