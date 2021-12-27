import javax.swing.*;
import java.awt.*;


public class BoardView implements Runnable {

    public void run() {
        JFrame frame = new JFrame("Memory-game");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.blue);
        panel1.setSize(300,300);
        frame.add(panel1, BorderLayout.CENTER);

        
        frame.pack();
        frame.setSize(650, 500);
        frame.setVisible(true);

    }

    /*
    public void addtopanel(Card test){
        this.s.add(test);
        s.revalidate();
    }ww
    */
        





    
}
