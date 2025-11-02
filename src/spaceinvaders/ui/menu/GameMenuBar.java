package spaceinvaders.ui.menu;

import javax.swing.*;
import spaceinvaders.media.GameExceptions;
import spaceinvaders.media.ImageSelection;
import spaceinvaders.media.MusicManager;
import spaceinvaders.ui.SpaceInvadersUI;

public class GameMenuBar extends JMenuBar {
    private final ImageSelection imageSelection;
    private final MusicManager musicManager;
    private final SpaceInvadersUI game;
    public GameMenuBar(SpaceInvadersUI game, ImageSelection imageSelection, MusicManager musicManager) {
        this.game = game;
        this.imageSelection = imageSelection;
        this.musicManager = musicManager;
        createMenus();
    }

    private void createMenus() {
        add(createShooterMenu());
        add(createInvaderMenu());
        add(createBulletMenu());
        add(createMusicMenu());
        add(createSpeedMenu());
    }

    private JMenu createShooterMenu() {
        JMenu shooterMenu = new JMenu("Shooter Image");
        shooterMenu.add(createMenuItem("Shooter 1 (default)", 
            () -> imageSelection.setShooterImage("/spaceinvaders/resources/ShooterImage.png")));
        shooterMenu.add(createMenuItem("Shooter 2", 
            () -> imageSelection.setShooterImage("/spaceinvaders/resources/ShooterAlt1.png")));
        shooterMenu.add(createMenuItem("Shooter 3", 
            () -> imageSelection.setShooterImage("/spaceinvaders/resources/ShooterAlt2.png")));
        shooterMenu.addSeparator();
        shooterMenu.add(createMenuItem("Custom URL...", () -> {
            String url = JOptionPane.showInputDialog("Enter image URL:");
            if (url != null && !url.isBlank()) {
                try {
                    imageSelection.setShooterImageFromURL(url);
                } catch (Exception e) {
                    GameExceptions.showErrorDialog("Invalid URL: " + e.getMessage());
                }
            }
        }));
        return shooterMenu;
    }

    private JMenu createSpeedMenu() {
        JMenu speedMenu = new JMenu("Game Speed");

        speedMenu.add(createMenuItem("Slow", () -> game.setGameSpeed(40)));
        speedMenu.add(createMenuItem("Normal", () -> game.setGameSpeed(20)));
        speedMenu.add(createMenuItem("Fast", () -> game.setGameSpeed(10)));
        speedMenu.addSeparator();
        speedMenu.add(createMenuItem("Reset", () -> game.setGameSpeed(20)));
        return speedMenu;
    }

    private JMenu createInvaderMenu() {
        JMenu invaderMenu = new JMenu("Invader Image");
        invaderMenu.add(createMenuItem("Invader 1 (default)", 
            () -> imageSelection.setInvaderImage("/spaceinvaders/resources/InvaderImage.png")));
        invaderMenu.add(createMenuItem("Invader 2", 
            () -> imageSelection.setInvaderImage("/spaceinvaders/resources/InvaderAlt1.png")));
        invaderMenu.add(createMenuItem("Invader 3", 
            () -> imageSelection.setInvaderImage("/spaceinvaders/resources/InvaderAlt2.png")));
        invaderMenu.addSeparator();
        invaderMenu.add(createMenuItem("Custom URL...", () -> {
            String url = JOptionPane.showInputDialog("Enter image URL:");
            if (url != null && !url.isBlank()) {
                try {
                    imageSelection.setInvaderImageFromURL(url);
                } catch (Exception e) {
                    GameExceptions.showErrorDialog("Invalid URL: " + e.getMessage());
                }
            }
        }));
        return invaderMenu;
    }
    
    
    private JMenu createBulletMenu() {
        JMenu bulletMenu = new JMenu("Bullet Type");

        bulletMenu.add(createMenuItem("Triangle", () -> game.currentBulletType = SpaceInvadersUI.BulletType.TRIANGLE));
        bulletMenu.add(createMenuItem("Circle", () -> game.currentBulletType = SpaceInvadersUI.BulletType.CIRCLE));
        bulletMenu.add(createMenuItem("Square", () -> game.currentBulletType = SpaceInvadersUI.BulletType.SQUARE));
        bulletMenu.addSeparator();
        bulletMenu.add(createMenuItem("Custom URL...", () -> {
            String url = JOptionPane.showInputDialog("Enter bullet image URL:");
            if (url != null && !url.isBlank()) {
                try {
                    // For now just show an error since SpaceInvadersUI doesn't yet handle bullet images
                    // Later: call SpaceInvadersUI to update bullet image
                   GameExceptions.showErrorDialog("Custom bullet image not implemented yet");
                } catch (Exception e) {
                   GameExceptions.showErrorDialog("Invalid URL: " + e.getMessage());
                }
            }
        }));

        return bulletMenu;
    }

    private JMenu createMusicMenu() {
        JMenu musicMenu = new JMenu("Music");
        musicMenu.add(createMenuItem("Music 1", () -> musicManager.playMusic("/spaceinvaders/resources/Music1.wav")));
        musicMenu.add(createMenuItem("Music 2", () -> musicManager.playMusic("/spaceinvaders/resources/Music2.wav")));
        musicMenu.add(createMenuItem("Music 3", () -> musicManager.playMusic("/spaceinvaders/resources/Music3.wav")));
        musicMenu.addSeparator();
        musicMenu.add(createMenuItem("Custom URL...", () -> {
            String url = javax.swing.JOptionPane.showInputDialog("Enter music URL:");
            if (url != null && !url.isBlank()) {
                musicManager.playMusic(url);
            }
        }));
        musicMenu.addSeparator();
        musicMenu.add(createMenuItem("Off", () -> musicManager.stopMusic()));
        return musicMenu;
    }

    private JMenuItem createMenuItem(String title, Runnable action) {
        JMenuItem item = new JMenuItem(title);
        item.addActionListener(e -> action.run());
        return item;
    }
}
