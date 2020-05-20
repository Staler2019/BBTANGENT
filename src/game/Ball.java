// P.Y. copyright
package game;

public class Ball {
    private int num;
    private double dir_x, dir_y;
    private double posi_x, posi_y;

    public Ball(){
        posi_x = ; // TODO: initialize position
        posi_y = (double)Global.getButtom(); //
        num = 1;
    }

    public int getNum(){return this.num;}
    public double getDir_x(){return this.dir_x;}
    public double getDir_y(){return this.dir_y;}
    public double revDir_x(){
        this.dir_x*=(-1);
        return this.dir_x;
    }
    public double revDir_y(){
        this.dir_y*=(-1);
        return this.dir_y;
    }
    public int getPosi_x(){return(int)this.posi_x;}
    public int getPosi_y(){return (int)this.posi_y;}
}