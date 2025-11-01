package spaceinvaders.ui;

import java.awt.*;
import spaceinvaders.model.Bullet;
import spaceinvaders.model.InvaderBox;

public class PaintingActions {

    public PaintingActions() {

    }

    public void drawShooter(Graphics g, SpaceInvadersUI game) {
        Image shooter_image = game.imageSelection.getShooterImage();
        int shooter_height = game.getShooterHeight();
        int shooter_width = game.getShooterWidth();
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Y_Coordinate = game.getHeight() - shooter_height;

        g.drawImage(shooter_image, shooter_X_Coordinate, shooter_Y_Coordinate, shooter_width, shooter_height, game);

    }

    public void drawInvaders(Graphics g, java.util.List<InvaderBox> invaderboxes, Image invaderboxImage,
            SpaceInvadersUI game) {
        for (InvaderBox invaderbox : invaderboxes) {
            g.drawImage(invaderboxImage, invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size, game);
        }
    }

    public void drawBullets(Graphics g, java.util.List<Bullet> bullets) {
        g.setColor(Color.YELLOW);
        for (Bullet bullet : bullets) {
            // Make the bullet into a triangle. Remember where the origin is on the game
            int[] xPoints = { bullet.x, bullet.x - 5, bullet.x + 5 };
            int[] yPoints = { bullet.y, bullet.y + 10, bullet.y + 10 };
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }
}
