import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardView implements Runnable {
    static JButton[] buttons;
    
    int openCount = 0; // Opened Card Count : 0, 1, 2 
    int buttonIndexSave1 = 0; // First Opened Card index : 0-15
    int buttonIndexSave2 = 0; // Second Opened card index : 0-15 
    Timer timer;
    int successCount = 0; 
    

    //The method to get button's Index
    public int getbuttonIndex(JButton btn) {
        int index = 0;
        for(int i=0; i<16; i++){
            if (buttons[i] == btn) {
                index = i; 
            }
        }
        return index; 
    }

    //The method to flip the cards back after 2 cards have shown with timer.
    public void flipIt() {
        //Timer 1Second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openCount = 0; 
                buttons[buttonIndexSave1].setIcon(null);
                buttons[buttonIndexSave2].setIcon(null);
                timer.stop();
            }

        });
        timer.start();
    }

    //The method to check if the cards are same cards or not. 
    public boolean checkCard(int index1, int index2){
        if(index1 == index2) {
            return false;
        }
        //System.out.println(images[index1]);
        //System.out.println(images[index2]);

        if(images[index1].equals(images[index2])){
            return true;

        } else {
            return false;
        }
    }
        public void Restart() {
            timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("Timer");
                }
            });
            timer.start();
        }
            // creat imgicon
        String[] images = {
                "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
                "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png",
                "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
                "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png"
        };
       
    public void run() {

        //Setting the frame and panels. 
        JFrame frame = new JFrame("Memory-game");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(150, 0, 530, 400); // x,y,width,heigth
        panel.setBackground(Color.blue);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 400, 700, 60); // x,y,width,heigth
        panel2.setBackground(Color.blue);

        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 0, 150, 200);
        panel3.setBackground(Color.blue);

        JLabel label1 = new JLabel("Player 1");
        label1.setFont(new Font("Verdana", 1, 20));
        panel3.setBorder(new LineBorder(Color.BLACK));
        panel3.add(label1);

        JPanel panel4 = new JPanel();
        panel4.setBounds(0, 200, 150, 200);
        panel4.setBackground(Color.yellow);
        JLabel label2 = new JLabel("Player 2");
        label2.setFont(new Font("Verdana", 1, 20));
        panel4.setBorder(new LineBorder(Color.BLACK));
        panel4.add(label2);

        //Setting the buttons for 16 cards and new/exit.
        buttons = new JButton[16];
        String[] names = { 
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16" 
        };

        JButton new_game = new JButton("New");
        JButton end_game = new JButton("End");
        new_game.setBackground(Color.green);
        end_game.setBackground(Color.red);
        new_game.setForeground(Color.BLACK);
        end_game.setForeground(Color.BLACK);
        new_game.setPreferredSize(new Dimension(75, 25));
        end_game.setPreferredSize(new Dimension(75, 25));
        new_game.setBorder(new LineBorder(Color.BLACK));
        end_game.setBorder(new LineBorder(Color.BLACK));

        //Exit game button
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        };
        end_game.addActionListener(al);

        //New game button 
        //To do.. 

        //Creating ImageIcon and set up the proper size.
        ImageIcon[] IconList = new ImageIcon[16];

        for (int i = 0; i < buttons.length; i++) {
        ImageIcon banana = new ImageIcon(images[i]);
        Image bananaIm = banana.getImage();
        Image bananaIm2 = bananaIm.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); 
        ImageIcon banana2 = new ImageIcon(bananaIm2);
        IconList[i] = (banana2);
        }

        //Changing the array into a list to shuffle. 
        List<ImageIcon> ImageList = Arrays.asList(IconList);
		//Shuffle it. 
        Collections.shuffle(ImageList);
		//Changing the list into the array back again. 
        ImageList.toArray(IconList);

        for (int j = 0; j < buttons.length; j++) {
                buttons[j] = new JButton(names[j]);
        }

        //Matching the images to the buttons 
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                if(openCount == 2) {
                    return;
                }

                JButton btn = (JButton) e.getSource();
                int index = getbuttonIndex(btn);
                btn.setIcon(IconList[index]);

                openCount++;

                //Have an issue here in 'index', have to get the image's name and compare 
                if(openCount == 1){
                    buttonIndexSave1 = index;

                } else if(openCount == 2){
                    buttonIndexSave2 = index;

                System.out.println(buttonIndexSave1);
                System.out.println(buttonIndexSave2);

                    //not sure it's working?
                    boolean getScore = checkCard(buttonIndexSave1, buttonIndexSave2);
                    if ( getScore == true ) {
                        openCount = 0;
                        successCount++;

                        label1.setText(Integer.toString(successCount));
                        
                        if(successCount == 8){
                            //Todo.. 
                            //setText : Game Over! The winner is ..
                            //reset game  
                        }

                    } else {
                        flipIt();
                    }
                }
                
                }
                
            });
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
        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
