// P.Y. copyright
package game;

public class Global {

    private static int level = 1;
    private static int difficulty = 1;
    private static int buttom = ;  // TODO: find buttom pixel for y

    public static int getLevel() {return level;}
    public static void addLevel() {level++;}
    public static int getDifficulty() {return difficulty;}
    public static void setDifficulty(int dif) {difficulty = dif;}
    public static int getButtom() {return buttom;}
}