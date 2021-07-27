import java.awt.event.KeyEvent;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public class Paddle2 extends Paddle{
    static final int x = 770;

    public Paddle2 (Game game){this.game = game;}

    public int setX(){
        return Paddle2.x;}

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){yVel = -SPEED;}
        if (e.getKeyCode() == KeyEvent.VK_DOWN){yVel = SPEED;}
    }
}
