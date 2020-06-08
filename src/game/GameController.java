/****************************************************************************************
 *	P.Y. copyright	 			                                                        *
 *	Game Main        		   	                                                        *
 *	Status: progressing        	                                                        *
 *	init -> (shootable)pressed -> released(unshootable) -> shoot ->  (shootable)pressed *
 ***************************************************************************************/
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameController implements Initializable {
    private final double _X = 195;
    private final double _Y = 520;
    private int level = 1;
    private LinkedList<Ball> _balls = new LinkedList<Ball>();
    private double mouseX = 195; // TODO: set default
    private double mouseY = 520;
    private Boolean mousePressing = false;
    private Boolean shooting = false;  // TODO: MAKE SURE THE FUNCTION IN SHOOT HAS FINISHED

    @FXML Pane _field;
    @FXML GridPane _player_plane;
    @FXML ImageView _ball;
    @FXML ImageView _pause;
    @FXML Label _level;
    @FXML Label _suggestion;
    @FXML ImageView _mouse;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000/60),
        (e) -> {
            // mousePressing
            if(mousePressing) {
                _mouse.setLayoutX(mouseX - _mouse.getFitWidth()/2);
                _mouse.setLayoutY(mouseY - _mouse.getFitHeight()/2);
            }
            // Balls
            ArrayList<Ball> tBalls = new ArrayList<Ball>(_balls);
            for(var b: tBalls) {
                b.movePosi(8 * b.getDirX(), 8 * b.getDirY());
                if(b.getPosi_x() > 330 || b.getPosi_x() < 45) {
                    b.revertX();
                }
                if(b.getPosi_y() < 45) {
                    b.revertY();
                }
                if(b.getPosi_y() > 750) {
                    _balls.remove(b); // remove List
                    _field.getChildren().remove(b.imageView); // remove clone
                }
                // TODO: touch block reflect
            }
        }));
        fps.setCycleCount(Timeline.INDEFINITE);
        fps.play();
    }
//****************************************************************************************************
    // TODO: use key WSAD... to decide which point to point is the vector to shoot
    // TODO: _level.layout(173, 9); level > 9, _level.layout(168, 9); level > 99, _level.layout(163, 9)
    @FXML
    public void onPausePressed() throws IOException { // open menu // TODO: open menu at the same stage. Making sure
                                                      // that the data in GameController won't lost'
        Parent menu = FXMLLoader.load(getClass().getResource("ControlMenuScene.fxml"));
        Scene menuScene = new Scene(menu);
        menuScene.getRoot().requestFocus();
        BBTANGENTController.currStage.setScene(menuScene);
    }

    @FXML
    public void shoot() {
        // shoot
        ImageView newIV = new ImageView(_ball.getImage());
        Ball ball = new Ball(newIV, mouseX - _ball.getX(), mouseY - _ball.getY());
        while(true){
            ball.movePosi(8 * ball.getDirX(), 8 * ball.getDirY());
            if (ball.getPosi_x() > 330 || ball.getPosi_y() < 45) {
                ball.revertX();
            }
            if (ball.getPosi_y() < 45) {
                ball.revertY();
            }
            if (ball.getPosi_y() > 750) {
                break;
            }

            try{
                Thread.sleep(1000/60);
            }
            catch(Exception e){
                System.out.println("cannot wait for 1 frame");
                System.exit(0);
            }
        }
        for (int i = Global.num - 1; i > 0; i++) {
            _balls.push(new Ball(newIV, mouseX - _ball.getX(), mouseY - _ball.getY()));
            _field.getChildren().add(newIV);
        }

        // move down blocks


        // TODO: if touch bottom call storeData and end game


        // next level
        mouseX = _X;
        mouseY = _Y;
        level++;
        _level.setText(String.valueOf(level));
        mousePressing = true;
        _mouse.setVisible(true);
    }

    @FXML
    public void onMousePressed(MouseEvent m) {
        System.out.println("Mouse pressed on Grid");
    }

    @FXML
    public void onMouseReleased(MouseEvent m) {
        mousePressing = false;
        _mouse.setVisible(false);
        System.out.println("Mouse released on Pane");
        mouseX = m.getX();
        mouseY = m.getY();
        System.out.println("X:" + mouseX+ " Y:" + mouseY);
    }
//****************************************************************************************************
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