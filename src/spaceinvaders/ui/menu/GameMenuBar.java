package spaceinvaders.ui.menu;

import javax.swing.*;
import java.awt.event.*;
import spaceinvaders.media.ImageSelection;
import spaceinvaders.media.GameExceptions;

public class GameMenuBar extends JMenuBar {
    private final ImageSelection imageSelection;

    public GameMenuBar(ImageSelection imageSelection) {
        this.imageSelection = imageSelection;
        createMenus();
    }

    private void createMenus() {
        add(createShooterMenu());
        add(createInvaderMenu());
        add(createBulletMenu());
        add(createMusicMenu());
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

    // Placeholder for now
    private JMenu createBulletMenu() {
        return new JMenu("Bullet Type");
    }

    private JMenu createMusicMenu() {
        return new JMenu("Music");
    }

    private JMenuItem createMenuItem(String title, Runnable action) {
        JMenuItem item = new JMenuItem(title);
        item.addActionListener(e -> action.run());
        return item;
    }
}
