import java.io.IOException;

public class Launcher {
   public static void main( String[] args ) throws IOException {
      BatmanFlight batmanFlight = new BatmanFlight();
      BatmanMusic batmanMusic = new BatmanMusic();

      batmanFlight.startFlight();
      batmanMusic.playMusic();
   }
}