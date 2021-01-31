import java.awt.*;

public class Batman {
   // properties
   private Point location;
   private Point velocity;
   private Image batmanImage;
   private int speed;

   // constructors
   public Batman() {
      speed = 20;
      
      location = new Point();
      velocity = new Point();

      batmanImage = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("batman2.png"));
   }
   
   // methods
   public void incrementSpeed() {
      if( speed <= 30 )
         speed = speed + 5;
   }

   public void decrementSpeed() {
      if( speed >= 5 )
         speed = speed - 5;
   }

   // move method
   public void move() {
      location.translate( velocity.x, velocity.y );

      if (location.x <= -55)
         velocity.x = 0;
      if (location.y <= -90)
         velocity.y = 0;
      if (location.x >= MainFrame.SCREEN_WIDTH - 210)
         velocity.x = 0;
      if (location.y >= MainFrame.SCREEN_HEIGHT - 200)
         velocity.y = 0;
   }

   // get methods
   public int getSpeed() {
      return speed;
   }

   public Image getBatmanImage() {
      return batmanImage;
   }
   
   public Point getBatmanLocation() {
      return location;
   }

   // set methods   
   public void setBatmanLocation( int newX, int newY ) {
      location.setLocation( newX, newY );
   }

   public void setVelX(int x) {
      velocity.x = x;
   }

   public void setVelY(int y) {
      velocity.y = y;
   }
}
