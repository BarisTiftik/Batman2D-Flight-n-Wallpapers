import java.io.IOException;

public class Launcher
{  
   public static void main( String[] args ) throws IOException {
      BatmanGame bg = new BatmanGame();
      BatmanMusic bm = new BatmanMusic();

      bg.openGame();
      bm.playMusic();
   }
}