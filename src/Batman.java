import java.awt.*;

public class Batman 
{  
   // properties
   private Point[] vectors;
   private Point location;
   private Point velocity;
   private Image batmanImage;
   private int speed;

   // constructors
   public Batman()
   {          
      speed = 25;
      
      location = new Point();
      velocity = new Point();
      
      vectors = new Point[]{ new Point( -speed, 0 ), new Point( 0, -speed ), new Point( speed, 0 ), new Point( 0, speed ) };
         
      constructBatmanImage();                    
   }
   
   // methods   
   public void constructBatmanImage() {
      batmanImage = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("batman2.png"));
   }
   
   // get methods
   public Image getBatmanImage()
   {
      return batmanImage;
   }
   
   public Point getBatmanLocation()
   {
      return location;
   }
   
   // move method  
   public void move()
   {
      location.translate( velocity.x, velocity.y );
   }
   
   // set methods   
   public void setBatmanLocation( int newX, int newY )
   {
      location.setLocation( newX, newY );
   }
   
   public void speedUp(int d)
   {      
      velocity.setLocation( vectors[d] );
   }
   
   public void stop() 
   {
      velocity.setLocation( 0, 0);
   }
}
