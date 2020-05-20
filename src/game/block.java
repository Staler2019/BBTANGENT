// P.Y. copyright
package game;

public abstract class Block {   // blocks: rectangle|| doing, triangle|| plaining, 1/4circle|| plaining

    protected int num;
    protected int posi_x, posi_y; // size 50x50 pixel
    // private int color;          // TODO: represent remain of num

    public Block() {    // TODO: make new level blocks visible

    }

    public int getNum() {return this.num;}

    // get before move block to next level
    public int getPosi_x() {return this.posi_x;}

    public int getPosi_y() {return this.posi_y;}

    // move downward directly without using setPosi
    public void nextLevel() {this.posi_y-=50;}

    public static void generateBlock() {

    }

    // done rectangle hit by ball   // TODO: ball reboundence
    public abstract void minusNum(Ball b);
}