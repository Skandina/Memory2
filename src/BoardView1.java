import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardView1 implements Runnable {

    static Player p1;
    static Player p2;
    static Card[] cards;
    static int counter = 0;

    public void check() {
    
        if(counter == 2) {
            int i1 = -1;
            int i2 = -1;
            
            //Organizing(??)
            for (int j = 0; j < cards.length; j++) {
                // which player turned the same cards? 1= player 1, 2=player 2 && 
                
                if((cards[j].getResolved() == 0) && (cards[j].getStatus())) {
                    if(i1 == -1) i1 = j;
                    else i2 = j;
                }
            }
            
            counter = 0;

            //if the images are same ? 
            if(cards[i1].getImageSorce() == cards[i2].getImageSorce()) {
                
                if (p1.isMyTurn())
                {
                    p1.addScore();
                    System.out.println(p1.addScore());
                } else if (p2.isMyTurn()) {
                    p2.addScore();
                    System.out.println(p2.addScore());
                }

                cards[i1].button.setVisible(false);
                cards[i2].button.setVisible(false);


            } else {
                for (int j = 0; j < cards.length; j++) {
                    cards[j].hideImage();
                }   
                counter = 0;
            }
        }

    }
    
    //giving the button's index (??)
    public int getCardIndex(JButton btn) {
        int index = 0;
        for(int i=0; i<16; i++){
            if (cards[i].button == btn) {
                index = i; 
            }
        }
        return index; 
    }

    public void run() {

        JFrame frame = new JFrame("Memory-game");

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 4, 10, 10));
        gridPanel.setBounds(150, 0, 530, 400); //x,y,width,heigth
        gridPanel.setBackground(Color.blue);

        p1 = new Player("Kevenn", true);
        p2 = new Player("Dinaaa", false);

        JLabel spacer = new JLabel("  ");

        JPanel p1Panel = new JPanel();
        p1Panel.setBounds(0, 0, 150, 200);
        p1Panel.setBackground(Color.blue);
        JLabel p1Name = new JLabel(p1.getName());
        JLabel p1Score = new JLabel("Score: " + p1.getScore());
        p1Name.setFont(new Font("Verdana", 1, 20));
        p1Score.setFont(new Font("Verdana", 1, 15));
        p1Panel.setBorder(new LineBorder(Color.BLACK));
        p1Panel.add(p1Name);
        p1Panel.add(spacer);
        p1Panel.add(p1Score);

        JPanel p2Panel = new JPanel();
        p2Panel.setBounds(0, 200, 150, 200);
        p2Panel.setBackground(Color.yellow);
        JLabel p2Name = new JLabel(p2.getName());
        JLabel p2Score = new JLabel("Score: " + p2.getScore());
        // lägga score till andra line
        p2Name.setFont(new Font("Verdana", 1, 20));
        p2Score.setFont(new Font("Verdana", 1, 15));
        p2Panel.setBorder(new LineBorder(Color.BLACK));
        p2Panel.add(p2Name);
        p2Panel.add(spacer);
        p2Panel.add(p2Score);


        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 400, 700, 60); //x,y,width,heigth
        panel2.setBackground(Color.blue);

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


        // start

        cards = new Card[16];
        //ImageIcon[] imageIcons = new ImageIcon[16];
        //Timer[] timers  = new Timer[16];

        // creat imgicon
        String[] images = {
            "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
            "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png",
            "src/img/fruit01.png", "src/img/fruit02.png", "src/img/fruit03.png", "src/img/fruit04.png",
            "src/img/fruit05.png", "src/img/fruit06.png", "src/img/fruit07.png", "src/img/fruit08.png"
        };

        String[] names = { 
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16" 
        };

        for (int j = 0; j < cards.length; j++) {
            cards[j] = new Card(new JButton(), names[j], images[j]);
        }

        //Changing the array into a list to shuffle. 
        List<Card> cardsList = Arrays.asList(cards);
		//Shuffle it. 
        Collections.shuffle(cardsList);
		//Changing the list into the array back again. 
        cardsList.toArray(cards);

        //Timer timer = new Timer(5000, new ActionListener() {
        //    public void actionPerformed(ActionEvent e) {
        //        cards[0].clearImage();
        //    }
        //});
        //timer.setRepeats(false);

        //Matching the images to the buttons 
        for (int i = 0; i < cards.length; i++) {
              cards[i].setIndex(i);
                cards[i].button.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        //fixa Koden
                        JButton btn = (JButton) e.getSource();
                        //if it's not cards[i].false 
                        if(!(cards[getCardIndex(btn)].getStatus())) {
                            cards[getCardIndex(btn)].showImage();
                            counter++;
                            check();
                        }
                        //timer.start();
                    }
                });
        }

        // end


        for (int i = 0; i < cards.length; i++) {
            gridPanel.add(cards[i].button);
        }

        panel2.add(new_game);
        panel2.add(end_game);

        frame.add(gridPanel);
        frame.add(panel2);
        frame.add(p1Panel);
        frame.add(p2Panel);
        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}