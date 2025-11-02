package spaceinvaders;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import spaceinvaders.ui.SpaceInvadersUI;
import spaceinvaders.ui.menu.GameMenuBar;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders with Images");
            SpaceInvadersUI game = new SpaceInvadersUI();
            frame.add(game);
            GameMenuBar menuBar = new GameMenuBar(game.imageSelection, game.musicManager);
            frame.setJMenuBar(menuBar);//was: new GameMenuBar(game.imageSelection, game.musicManager)

            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
        });
    }
}
