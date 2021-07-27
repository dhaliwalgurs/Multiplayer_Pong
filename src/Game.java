import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public class Game extends JPanel implements ActionListener,KeyListener {
    // FIELDS
    // CONSTANTS
    static final int FRAMEX = 800;
    static final int FRAMEY = 400;
    // variables
    Timer t;
    // imported objects
    Ball ball = new Ball (this);
    Paddle1 paddle1 = new Paddle1(this);
    Paddle2 paddle2 = new Paddle2(this);

    // CLASS CONSTRUCTOR
    public Game(){
        t = new Timer (10,this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
    }

    // METHODS/FUNCTIONS
    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        paddle1.move();
        paddle2.move();

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle1.keyPressed(e);
        paddle2.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle1.keyReleased(e);
        paddle2.keyReleased(e);
    }

    private void paintBackground(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,FRAMEX,FRAMEY);
    }

    private void paintNet(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(FRAMEX/2,0,5,FRAMEY);
    }

    private void paintScore (Graphics2D s1, Graphics2D s2){
        String score1 = Integer.toString(ball.score1);
        String score2 = Integer.toString(ball.score2);

        s1.setColor(Color.WHITE);
        s2.setColor(Color.WHITE);

        s1.setFont(new Font ("TimesRoman", Font.PLAIN, 50));
        s2.setFont(new Font ("TimesRoman", Font.PLAIN, 50));

        s1.drawString(score1, 30, FRAMEY/10);
        s2.drawString(score2, FRAMEX-70, FRAMEY/10);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        paintBackground(g2d);
        paintNet(g2d);
        ball.paint(g2d);
        paddle1.paint(g2d);
        paddle2.paint(g2d);
        paintScore(g2d,g2d);

    }

}
