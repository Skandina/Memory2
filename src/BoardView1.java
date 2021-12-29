import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.border.LineBorder;


public class BoardView1 implements Runnable {

    public void run() {
        
        JFrame frame = new JFrame("Memory-game");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBounds(150,0,530,400); //x,y,width,heigth
        panel.setBackground(Color.blue);  
       
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,400,700,60); //x,y,width,heigth
        panel2.setBackground(Color.blue);  

        JPanel panel3 = new JPanel();
        panel3.setBounds(0,0,150,200);
        panel3.setBackground(Color.blue); 
        JLabel label1 = new JLabel("Player 1");
        label1.setFont(new Font("Verdana",1,20));
        panel3.setBorder(new LineBorder(Color.BLACK));
        panel3.add(label1); 

        JPanel panel4 = new JPanel();
        panel4.setBounds(0,200,150,200);
        panel4.setBackground(Color.yellow);  
        JLabel label2 = new JLabel("Player 2");
        label2.setFont(new Font("Verdana",1,20));
        panel4.setBorder(new LineBorder(Color.BLACK));
        panel4.add(label2);

        // TODO:
        ImageIcon apple = new ImageIcon("src/img/fruit01.png");
        Image appleIn = apple.getImage();
        Image appleInA = appleIn.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        final ImageIcon banana2 = new ImageIcon(appleInA);

        JButton b1=new JButton(banana2); 

        b1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                if (e.getSource() == b1){
                    //Göra här
                    
                    
                    JOptionPane.showMessageDialog(null, "test");
                }
            }  
        });  

        /*
        b1.addActionListener(this);
            
        public void actionPerformed(ActionEvent e) {
            //b1 = new JButton(banana2);
            banana2.setVisible(true)
        }
       */

        panel.add(b1);
                frame.add(panel); 
                frame.add(panel2); 
                frame.add(panel3);
                frame.add(panel4);
                frame.setSize(700,500);    
                frame.setLayout(null);    
                frame.setVisible(true);  
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }

}
