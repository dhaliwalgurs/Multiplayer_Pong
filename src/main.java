import javax.swing.*;

/**
 * Created by GDhaliwal on 2018-06-09.
 */
public class main {
    static JFrame frame = new JFrame("Multiplayer Pong Game");

    public static void main (String[] args){
        Game display = new Game();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Game.FRAMEX,Game.FRAMEY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(display);
    }


}
