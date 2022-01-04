import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

//Vad vi behöver göra: Fix this: can't get shuffeled array, remove the cards which is same (elimated), restart game, which player is active (player1, player2). 
//Choose winner by checking the points

public class BoardView implements Runnable {
    static JButton[] buttons;

    int openCount = 0; // Opened Card Count : 0, 1, 2
    int buttonIndexSave1 = 0; // First Opened Card index : 0-15
    int buttonIndexSave2 = 0; // Second Opened card index : 0-15
    Timer timer;
    int successCount = 0;
    ImageIcon[] IconList = new ImageIcon[16];

    // The method to get button's Index
    public int getbuttonIndex(JButton btn) {
        int index = 0;
        for (int i = 0; i < 16; i++) {
            if (buttons[i] == btn) {
                index = i;
            }
        }
        return index;
    }

    // Timer, flip back the cards.
    public void flipIt() {
        // Timer 1 second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCount = 0;
                buttons[buttonIndexSave1].setIcon(null);
                buttons[buttonIndexSave2].setIcon(null);
                timer.stop();
            }

        });
        timer.start();
    }

    // creat imgicon
    String[] images = {
            "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
            "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png",
            "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
            "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png",
    };

    String[] names = {
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16"
    };

    /*
    // Shuffle 2 
    public void mixCard() {
        Random rand = new Random();
        for(int i=0; i<1000; i++) { 
            int random = rand.nextInt(15)+1; 
            String temp = images[0];
            images[0] = images[random];
            images[random] = temp;
        }
    
        for(int i=0; i<16; i++)
            System.out.println(images[i]);
    }
    */
    // Checking the cards if it's the same.
    // TODO: Problem is we are not using the shuffeled images array.
    public boolean checkCard(int index1, int index2) {
        // same postion 
        if (index1 == index2) {
            System.out.println("index1 == index2");
            return false;
        }
        if (images[index1].equals(images[index2])) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    

    public void run() {
        // Setting the frame and panels.
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

        // Exit game button
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        end_game.addActionListener(al);
        
        // Restarts the game
        ActionListener a2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.repaint();

            }
        };
        new_game.addActionListener(a2);

        buttons = new JButton[16];

        //ImageIcon[] IconList = new ImageIcon[16];
        
    
        //Setting up the image size. 
        for (int i = 0; i < buttons.length; i++) {
            ImageIcon all_images = new ImageIcon(images[i]);
            Image all_imagesIn = all_images.getImage();
            Image all_imagesIn2 = all_imagesIn.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
            ImageIcon all_imagesMain = new ImageIcon(all_imagesIn2);
            IconList[i] = (all_imagesMain);

        }
        
        // suffle 1
        // Changing the array into a list to shuffle.
        List<ImageIcon> ImageList = Arrays.asList(IconList);
        // Shuffle it.
        Collections.shuffle(ImageList);
        // Changing the list into the array back again.
        ImageList.toArray(IconList);
        
        System.out.println(Arrays.toString(IconList));

        
        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new JButton(names[j]);
        }

        // Matching the images to the buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (openCount == 2) {
                        return;
                    }

                    JButton btn = (JButton) e.getSource();
                    int index = getbuttonIndex(btn);
                    btn.setIcon(IconList[index]);

                    openCount++;

                    if (openCount == 1) {
                        buttonIndexSave1 = index;
                        System.out.println(buttonIndexSave1);
                    } else if (openCount == 2) {
                        buttonIndexSave2 = index;
                        System.out.println(buttonIndexSave2);

                        // not sure it's working?
                        boolean getScore = checkCard(buttonIndexSave1, buttonIndexSave2);
                        // same cards 
                        if (getScore == true) {
                            openCount = 0;
                            successCount++;

                            label1.setText(Integer.toString(successCount));

                            if (successCount == 8) {
                                // Todo..
                                // setText : Game Over! The winner is ..
                                // reset game
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
