import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class BoardView1 implements Runnable {
    static JButton[] buttons;

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

        //creat imgicon 
        String[] images = {
            "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
            "src/img/fruit05.png","src/img/fruit06.png","src/img/fruit07.png","src/img/fruit08.png" 
        };
        
        buttons = new JButton[16];
        String[] names = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16"};
        

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
        
            for (int i = 0; i < buttons.length; i++) {
                int index = (int) (Math.random() * (images.length - 1));
                ImageIcon banana = new ImageIcon(images[index]);
                Image bananaIm = banana.getImage();
                Image bananaIm2 = bananaIm.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
                ImageIcon banana2 = new ImageIcon(bananaIm2);
    
            for(int j = 0; j < buttons.length; j++){
                buttons[i] = new JButton(names[j]);
                buttons[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JButton btn = (JButton)e.getSource();
                        btn.setIcon((Icon) banana2);
                    }  
                });
            }
        }


        

      
        for (JButton button : buttons) {
            panel.add(button);
        }


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
