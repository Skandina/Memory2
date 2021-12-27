import javax.swing.*;
import java.awt.*;


public class Game extends BoardView {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new BoardView());

        /*
        JPanel panel1 = new JPanel();
        panel1.setSize(20, 50);
        panel1.setBackground(Color.pink);
        panel1.setVisible(true);
        BoardView.f.add(panel1);
        */
        
        
        Card card1 = new Card(1);

        //BoardView.addtopanel(card1);


        //System.out.println(card1.GetValue());
    }
}
