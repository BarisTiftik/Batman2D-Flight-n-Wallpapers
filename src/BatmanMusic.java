import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BatmanMusic {
    // methods
    public void playMusic() throws IOException {
        FileInputStream music = new FileInputStream("C:/Users/TULPAR/IdeaProjects/Batman2D-Flight-&-Wallpapers/res/TheDarkKnightRises(MainTheme).wav");
        AudioStream audioStream = new AudioStream(music);
        AudioPlayer.player.start(audioStream);
    }
}
