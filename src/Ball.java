import java.awt.*;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public class Ball {
    // FIELDS
    // CONSTANTS
    static final int DIAMETER = 30;
    static final double SLOWEDPERCENT = 0.9975;
    static final double MINSPEED = 6;
    static final double MAXSPEED = 15;
    // variables
    double x = 30;
    double y = 30;
    double xVel = MINSPEED;
    double yVel = MINSPEED;
    double prevX = 0;
    double prevY = 0;
    int score1 = 0;
    int score2 = 0;
    // improted objects
    public Game game;

    // CLASS CONSTRUCTOR
    public Ball (Game game){this.game = game;}

    // METHODS/FUNCTIONS
    public void move(){
        prevX = x;
        prevY = y;

        slow();
        handlePaddleCollision();
        handleWallCollision();

        x += xVel;
        y += yVel;
    }

    public void slow(){
        if (Math.abs(xVel) > MAXSPEED){xVel *= SLOWEDPERCENT;}
        if (Math.abs(yVel) > MAXSPEED){yVel *= SLOWEDPERCENT;}
        if (Math.abs(xVel) > MINSPEED){xVel *= SLOWEDPERCENT;}
        if (Math.abs(yVel) > MINSPEED){yVel *= SLOWEDPERCENT;}
    }

    public Rectangle getBounds(){
        return new Rectangle ((int) x, (int) y, DIAMETER, DIAMETER);
    }

    public void handlePaddleCollision(){
        int xVel_P1 = game.paddle1.xVel;
        int yVel_P1 = game.paddle1.yVel;
        int xVel_P2 = game.paddle2.xVel;
        int yVel_P2 = game.paddle2.yVel;

        if (game.paddle1.bounds().intersects(getBounds())){
            if(game.paddle1.topPaddle().intersects(getBounds())){
                y += yVel_P1;
                yVel = -1 * (Math.abs(yVel) + Math.abs(yVel_P1));
            }
            if(game.paddle1.bottomPaddle().intersects(getBounds())){
                y += yVel_P1;
                yVel = Math.abs(yVel) + Math.abs(yVel_P1);
            }
            if(game.paddle1.rightPaddle().intersects(getBounds())){
                x += xVel_P1;
                xVel = Math.abs(xVel) + Math.abs(xVel_P1);
                yVel = -1 * (yVel_P1/1.5) + yVel;
            }
            if(game.paddle1.leftPaddle().intersects(getBounds())){
                x += xVel_P1;
                xVel = -1 * (Math.abs(xVel) + Math.abs(xVel_P1));
                yVel = -1 * (yVel_P1/1.5) + yVel;
            }
        }

        if (game.paddle2.bounds().intersects(getBounds())){
            if(game.paddle2.topPaddle().intersects(getBounds())){
                y += yVel_P2;
                yVel = -1 * (Math.abs(yVel) + Math.abs(yVel_P2));
            }
            if(game.paddle2.bottomPaddle().intersects(getBounds())){
                y += yVel_P2;
                yVel = Math.abs(yVel) + Math.abs(yVel_P2);
            }
            if(game.paddle2.rightPaddle().intersects(getBounds())){
                x += xVel_P2;
                xVel = Math.abs(xVel) + Math.abs(xVel_P2);
                yVel = -1 * (yVel_P2/1.5) + yVel;
            }
            if(game.paddle2.leftPaddle().intersects(getBounds())){
                x += xVel_P2;
                xVel = -1 * (Math.abs(xVel) + Math.abs(xVel_P2));
                yVel = -1 * (yVel_P2/1.5) + yVel;
            }
        }

    }

    public void handleWallCollision(){
        if (x + xVel < 0 && xVel < 0){x = 0; xVel *= -1;score2 += 1;}
        if (y + yVel < 0 && yVel < 0){y = 0; yVel *= -1;}
        if (x + xVel > Game.FRAMEX*0.96 && xVel > 0){x = Game.FRAMEX*0.96; xVel *= -1;score1 += 1;}
        if (y + yVel > Game.FRAMEY*0.84 && yVel > 0){y = Game.FRAMEY*0.84; yVel *= -1;}
    }

    public void paint(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
    }
}
