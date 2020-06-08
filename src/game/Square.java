/********************************
 *	P.Y. copyright	 			*
 *	Class inherits Block	   	*
 *	Status: processing	      	*
 ********************************/
package game;

import javafx.scene.control.Button;

public class Square extends Block {

    public Square(Button btn) {
        super(btn);
    }

    @Override
    public void minusNum(Ball b) { // "this" is block  // TODO: ball reboundence
        this.getPosi_y()-b.getPosi_y()==Global.BALL_WIDTH
        b.getPosi_y()-this.getPosi_y()==Global.BLOCK_WIDTH
        this.getPosi_x()-b.getPosi_x()==Global.BALL_WIDTH
        b.getPosi_x()-this.getPosi_x()==Global.BLOCK_WIDTH
        if(Math.abs(b.getPosi_x()-this.getPosi_x()) == 25 || Math.abs(b.getPosi_y() - this.getPosi_y()) == 25) {
            this.num--;
        }
    }
}