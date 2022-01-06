
//git push origin master --force
//Vad vi behöver göra:  Fix this: remove the cards which is same (elimated), restart game, which player is active (player1, player2). 
//Choose winner by checking the points. 
import javax.swing.SwingUtilities;

public class Game extends BoardView {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new BoardView1());

    };
}