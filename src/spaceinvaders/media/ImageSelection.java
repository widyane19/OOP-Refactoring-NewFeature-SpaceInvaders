package spaceinvaders.media;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;

public class ImageSelection {
    private Image shooterImage;
    private Image invaderImage;

    public Image getShooterImage() {
        return shooterImage;
    }

    public Image getInvaderImage() {
        return invaderImage;
    }

    public void setGameImages() {
        shooterImage = loadImage("shooter", "/spaceinvaders/resources/ShooterImage.png");
        invaderImage = loadImage("invader", "/spaceinvaders/resources/InvaderImage.png");
    }

    private static Image loadImage(String imageType, String defaultResourcePath) {
        // Phase 2 note: we removed user popups and now just load defaults.
        String imageUrl = null;

        // If no URL provided or not used, load the default resource
        try {
            return ImageIO.read(ImageSelection.class.getResource(defaultResourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load default " + imageType + " image: " + e.getMessage());
        }

        return null;
    }
    public void setShooterImage(String resourcePath) {
        try {
            shooterImage = ImageIO.read(ImageSelection.class.getResource(resourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load shooter image: " + e.getMessage());
        }
    }
    public void setShooterImageFromURL(String url) throws IOException {
        try {
            shooterImage = ImageIO.read(new URI(url).toURL());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public void setInvaderImage(String resourcePath) {
        try {
            invaderImage = ImageIO.read(ImageSelection.class.getResource(resourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load invader image: " + e.getMessage());
        }
    }

    public void setInvaderImageFromURL(String url) throws IOException {
        try {
            invaderImage = ImageIO.read(new URI(url).toURL());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }   
}



