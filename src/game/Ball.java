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

    public Ball(ImageView imageview, double dirX, double dirY) { // x between 45 to 330; y between 45 to 750
        this.imageView = imageview;
        double length = Math.sqrt(Math.pow(dirX, 2) + Math.pow(dirY, 2));
        this.dir_x = dirX / length;
        this.dir_y = dirY / length;
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

    public double getPosi_x(){
        return this.imageView.getLayoutX();
    }

    public double getPosi_y(){
        return this.imageView.getLayoutY();
    }

    public void movePosi_x(double x){
        this.imageView.setLayoutX(this.imageView.getLayoutX() + x);
    }

    public void movePosi_y(double y){
        this.imageView.setLayoutY(this.imageView.getLayoutY() + y);
    }

    public void movePosi(double x, double y){
        this.movePosi_x(x);
        this.movePosi_y(y);
    }
}