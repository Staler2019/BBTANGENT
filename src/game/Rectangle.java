/********************************
 *	P.Y. copyright	 			*
 *	Class inherits Block	   	*
 ********************************/
package game;

public class Rectangle extends Block {

    public void minusNum(Ball b) {  // done rectangle hit by ball   // TODO: ball reboundence
        int hitCount = 0;
        if(Math.abs(b.getPosi_x()-this.posi_x) == 25  || Math.abs(b.getPosi_y()-this.posi_y) == 25){
            hitCount++;
        }
        this.num -= hitCount;
    }
}