/********************************
 *	P.Y. copyright	 			*
 *	Abstract Class Block        *
 *	Status: finished            *
 ********************************/
package game;

import javafx.scene.control.Button;

public abstract class Block {   // blocks: rectangle|| doing, triangle|| plaining, 1/4circle|| plaining

    protected int num;
    protected Button button; // size 50x50 pixel // TODO: color implement in button's style'

    public Block(Button btn) {
        this.button = btn;
        this.num = (int)(Math.random()*3) + Global.level - 1;
        if(this.num <= 0) {
            this.num = 1;
        }
    }

    public int getNum() {return this.num;}

    // get before move block to next level
    public double getPosi_x() {return this.button.getLayoutX();}

    public double getPosi_y() {return this.button.getLayoutY();}

    // move downward directly without using setPosi
    public void nextLevel() {this.button.setLayoutY(this.button.getLayoutY()-50);}

    // done rectangle hit by ball   // TODO: ball reboundence
    public abstract void minusNum(Ball b);
}