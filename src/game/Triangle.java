/********************************
 *	P.Y. copyright	 			*
 *	Class inherits Block        *
 *	Status: processing          *
 ********************************/
package game;

import javafx.scene.control.Button;

public class Triangle extends Block {

    private byte direction; // from 1 to 4

    public Triangle(Button btn) {
        super(btn);
        this.direction = (byte)(Math.random()*4 + 1);
    }

    @Override
    public void minusNum(Ball b) { //TODO: implement triangle's minusNum'
        switch(this.direction){
            // "<"
            case 2:
                if(Math.abs(b.getPosi_x()-this.getPosi_x()) == 25 || Math.abs(b.getPosi_y() - this.getPosi_y()) == 25) {
                    this.num--;
                }
            case 3:

            // ">"
            case 1:
            case 4:

            default:
                System.out.println("direction in triangle is wrong");
                break;
        }

    }
}