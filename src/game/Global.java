/********************************
 *	P.Y. copyright	 			*
 *	Global Manager        		*
 ********************************/
package game;

public class Global {

    //private static int level = 1;
    public static int difficulty = 1;
    //public static int buttom = ;  // const
    private static int highestScore = 0; // read a file
    private static String highestScoreName = "";

    //public static int getLevel() {return level;}
    //public static void addLevel() {level++;}
    public static int getDifficulty() {return difficulty;}
    public static void setDifficulty(int dif) {difficulty = dif;}
    //public static int getButtom() {return buttom;}
    public static void storeHSName(String name) {highestScoreName = name;}
    public static String getHSName() {return highestScoreName;}
    public static void storeHS(int score) {highestScore = score;}
    public static int getHS() {return highestScore;}
}