import javax.swing.*;
import java.awt.*;


public class BoardView implements Runnable {

    static JPanel s;

    public void BoardViewContents() {
        JFrame f = new JFrame("Memory-game");
        f.setSize(650, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        s.setSize(80,40);
        s.setVisible(true);
        f.add(s);
        f.setVisible(true);
        f.setVisible(true);
    }

    public void run() {
        BoardViewContents();
    }

    /*
    public void addtopanel(Card test){
        this.s.add(test);
        s.revalidate();
    }ww
    */
        





    
}
