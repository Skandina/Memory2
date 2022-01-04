import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Sorry if I deleted too many uncommented codes, I edited a lot and wanted to reorganize so deleted them randomly. 
//so make sure to copy and paste from your old project before you pull if you keep your code that I removed

public class BoardView implements Runnable {
    static JButton[] buttons;
    /*
    int buttonIndexSave1 = 0; // First Opened Card index : 0-15
    int buttonIndexSave2 = 0; // Second Opened card index : 0-15 
    Timer timer;
    int tryCount = 0; // Try count
    int successCount = 0; 
    */

    public int getbuttonIndex(JButton btn) {
        int index = 0;
        for(int i=0; i<16; i++){
            if (buttons[i] == btn) {
                index = i; 
            }
        }
        return index; 
    }

    public void run() {

        JFrame frame = new JFrame("Memory-game");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(150, 0, 530, 400); //x,y,width,heigth
        panel.setBackground(Color.blue);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 400, 700, 60); //x,y,width,heigth
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

        buttons = new JButton[16];

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

        ImageIcon[] imageIcons = new ImageIcon[16];
        for (int i = 0; i < imageIcons.length; i++) {
            Image image = ((new ImageIcon(images[i])).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
            imageIcons[i] = new ImageIcon(image);
        }

        //Changing the array into a list to shuffle. 
        List<ImageIcon> imageList = Arrays.asList(imageIcons);
		//Shuffle it. 
        Collections.shuffle(imageList);
		//Changing the list into the array back again. 
        imageList.toArray(imageIcons);

        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new JButton(names[j]);
        }

        //Matching the images to the buttons 
        for (int i = 0; i < buttons.length; i++) {

            buttons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    
                    JButton btn = (JButton) e.getSource();
                    btn.setIcon(imageIcons[getbuttonIndex(btn)]);
                }
            });
        }

        //Timer timer = new Timer(5000, new ActionListener() {
        //    public void actionPerformed(ActionEvent e) {

        //    }
        //});

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