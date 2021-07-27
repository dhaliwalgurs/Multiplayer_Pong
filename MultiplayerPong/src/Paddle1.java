import java.awt.event.KeyEvent;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public class Paddle1 extends Paddle{
    static final int x = 10;

    public Paddle1 (Game game){this.game = game;}

    public int setX(){
        return Paddle1.x;}

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W){yVel = -SPEED;}
        if (e.getKeyCode() == KeyEvent.VK_S){yVel = SPEED;}
    }
}
