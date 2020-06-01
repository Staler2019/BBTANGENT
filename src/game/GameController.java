/********************************
 *	P.Y. copyright	 			*
 *	Game Main        		   	*
 *	Status: progressing        	*
 ********************************/
package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameController implements Initializable {
    private int level = 1;
    private LinkedList<Ball> _balls = new LinkedList<Ball>();
    @FXML Pane _field;
    @FXML ImageView _ball;
    @FXML ImageView _pause;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000/60),
        (e) -> {
            ArrayList<Ball> tBalls = new ArrayList<Ball>(_balls);
            for(var b: tBalls) {
                b.imageView.setLayoutX(b.imageView.getLayoutX() + b.getDirX());
                b.imageView.setLayoutY(b.imageView.getLayoutY() + b.getDirY());
                if(b.imageView.getLayoutX() > 330 || b.imageView.getLayoutX() < 45) {
                    b.revertX();
                }
                if(b.imageView.getLayoutY() < 45) {
                    b.revertY();
                }
                if(b.imageView.getLayoutY() > 750) {
                    _balls.remove(b); // remove List
                    _field.getChildren().remove(b.imageView); // remove clone
                }
                // TODO: touch block reflect
            }
        }));
        fps.setCycleCount(Timeline.INDEFINITE);
        fps.play();
    }
    // TODO: use key wsad... to decide which point to point is the vector to shoot
    // TODO: _level.layout(173, 9); level > 9, _level.layout(168, 9); level > 99, _level.layout(163, 9)
    @Override
    public void onPausePressed() { // open menu

    }

    @FXML
    public void shoot() {

    }

    private void storePlayData(String playerName) { // TODO: check if score > nowScore
        int score = level;
        File playerData = new File("../../data/playerData.txt");
        // delete file
        if (playerData.delete()) {
            System.out.println("Deleted the file: " + playerData.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
        // recreate file
        try{
            if (playerData.createNewFile()) {
                System.out.println("File created: " + playerData.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // write file
        try {
            FileWriter dataWriter = new FileWriter("../../data/playerData.txt");
            dataWriter.write("highestScorePlayer: " + playerName + "\n");
            dataWriter.write("highestScore: " + score);
            Global.storeHSName(playerName);
            Global.storeHS(score);
            dataWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}