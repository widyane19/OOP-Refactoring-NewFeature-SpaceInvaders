package spaceinvaders.media;


import java.io.InputStream;
import javax.sound.sampled.*;

public class MusicManager {

    private Clip clip;
    private boolean isPlaying = false;

    public void playMusic(String resourcePath) {
        // Stop current music if any
        stopMusic();

        try {
            // Load audio file from resources folder
            InputStream audioSrc = getClass().getResourceAsStream(resourcePath);
            if (audioSrc == null) {
                System.out.println("Music file not found: " + resourcePath);
                return;
            }

            InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // loop indefinitely
            clip.start();

            isPlaying = true;

        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public void stopMusic() {
        if (clip != null && isPlaying) {
            clip.stop();
            clip.close();
            isPlaying = false;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
