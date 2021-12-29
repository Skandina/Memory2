import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class BoardView implements Runnable {
    static JButton[] buttons;

    public void run() {
        
        JFrame frame = new JFrame("Memory-game");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBounds(150,0,530,400); //x,y,width,heigth
        panel.setBorder(new LineBorder(Color.BLACK));
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

        
        JButton b1=new JButton("Button 1"); 
        JButton b2=new JButton("Button 2"); 
        JButton b3=new JButton("Button 3"); 
        JButton b4=new JButton("Button 4"); 
        JButton b5=new JButton("Button 5"); 
        JButton b6=new JButton("Button 6"); 
        JButton b7=new JButton("Button 7"); 
        JButton b8=new JButton("Button 8"); 
        JButton b9=new JButton("Button 9"); 
        JButton b10=new JButton("Button 10");
        JButton b11=new JButton("Button 11"); 
        JButton b12=new JButton("Button 12"); 
        JButton b13=new JButton("Button 13"); 
        JButton b14=new JButton("Button 14");
        JButton b15=new JButton("Button 15"); 
        JButton b16=new JButton("Button 16"); 

        JButton new_game=new JButton("New");
        JButton end_game=new JButton("End");
        new_game.setBackground(Color.green); 
        end_game.setBackground(Color.red); 
        new_game.setForeground(Color.BLACK);
        end_game.setForeground(Color.BLACK);
        new_game.setPreferredSize(new Dimension(75, 25));
        end_game.setPreferredSize(new Dimension(75, 25));
        new_game.setBorder(new LineBorder(Color.BLACK));
        end_game.setBorder(new LineBorder(Color.BLACK));

        /* 
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow); 

        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);

        b3.setBounds(50,100,80,30);    
        b3.setBackground(Color.yellow);   

        b4.setBounds(100,100,80,30);    
        b4.setBackground(Color.green);  

        b5.setBounds(50,100,80,30);    
        b5.setBackground(Color.yellow); 

        b6.setBounds(100,100,80,30);    
        b6.setBackground(Color.green);

        b7.setBounds(50,100,80,30);    
        b7.setBackground(Color.yellow);   

        b8.setBounds(100,100,80,30);    
        b8.setBackground(Color.green);  

        b9.setBounds(50,100,80,30);    
        b9.setBackground(Color.yellow); 

        b10.setBounds(100,100,80,30);    
        b10.setBackground(Color.green);

        b11.setBounds(50,100,80,30);    
        b11.setBackground(Color.yellow);   

        b12.setBounds(100,100,80,30);    
        b12.setBackground(Color.green);  

        b13.setBounds(50,100,80,30);    
        b13.setBackground(Color.yellow); 

        b14.setBounds(100,100,80,30);    
        b14.setBackground(Color.green);

        b15.setBounds(50,100,80,30);    
        b15.setBackground(Color.yellow);   

        b16.setBounds(100,100,80,30);    
        b16.setBackground(Color.green);  
        */
        //panel.add(banana2);
        for (JButton button : buttons) {
            panel.add(button);
        }
        /*panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);
        panel.add(b16);*/

        panel2.add(new_game);
        panel2.add(end_game);

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
