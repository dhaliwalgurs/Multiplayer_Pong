import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public abstract class Paddle {
    // FIELDS
    // CONSTANTS
    static final int WIDTH = 10;
    static final int HEIGHT = 80;
    static final int SPEED = 6;
    // variables
    int x = 10;
    int y = 30;
    int xVel = 0;
    int yVel = 0;
    int prevX = 0;
    int prevY = 0;
    // imported objects
    public Game game;

    // NO CLASS CONSTUCTOR

    // METHODS/FUNCTIONS for abstract Paddle
    public int setX(){return x;}

    public void move(){
        prevX = setX();
        prevY = y;

        if(setX() + xVel > 0 && setX() + xVel < Game.FRAMEX){x += xVel;}
        if(y + yVel > 0 && y + yVel < Game.FRAMEY - HEIGHT*1.4){y += yVel;}
    }

    public void keyReleased (KeyEvent e){
        yVel = 0;
        xVel = 0;
    }

    public Rectangle bounds() {return new Rectangle(setX(),y,WIDTH,HEIGHT);}
    public Rectangle topPaddle() {return new Rectangle(setX() + WIDTH/2,y,1,1);}
    public Rectangle bottomPaddle() {return new Rectangle(setX() + WIDTH/2,y + HEIGHT,1,1);}
    public Rectangle rightPaddle() {return new Rectangle(setX() + WIDTH,y,1,HEIGHT);}
    public Rectangle leftPaddle() {return new Rectangle(setX(),y,1,HEIGHT);}

    public void paint(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(setX(),y,WIDTH,HEIGHT);
    }
}

