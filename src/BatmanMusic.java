import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.IOException;

public class BatmanMusic {
    // methods
    public void playMusic() throws IOException {
        AudioStream audioStream = new AudioStream(getClass().getClassLoader().getResourceAsStream("TheDarkKnightRises(MainTheme).wav"));
        AudioPlayer.player.start(audioStream);
    }
}
