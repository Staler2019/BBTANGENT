/********************************
 *	P.Y. copyright	 			*
 *	Game Main        		   	*
 ********************************/
package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Game implements Initializable {
    private int level = 1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @Override
    public void onPausePressed() { // open menu?

    }

    public void shoot() {

    }

    private void storePlayData(String playerName) {
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