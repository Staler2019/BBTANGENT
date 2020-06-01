/********************************
 *	P.Y. copyright	 			*
 *	Class Ball        		   	*
 *	Status: finished        	*
 ********************************/
package game;

import javafx.scene.image.ImageView;

public class Ball {
    private double dir_x, dir_y;
    public ImageView imageView;

    public Ball(ImageView image) { // x between 45 to 330; y between 45 to 750
        this.imageView = image;
    }

    public void setDirection(double x, double y) {
        this.dir_x = x;
        this.dir_y = y;
    }

    public double getDirX() {
        return this.dir_x;
    }

    public double getDirY() {
        return this.dir_y;
    }

    public double revertX() {
        this.dir_x *= (-1);
        return this.dir_x;
    }

    public double revertY() {
        this.dir_y *= (-1);
        return this.dir_y;
    }
}