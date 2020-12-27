import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class WallpaperPanel extends JPanel implements MouseInputListener, ActionListener
{
   // properties
   private final int IMAGE_COUNT = 11;

   private Batman batman;
   private Image[] backgroundImages;
   private int imageIndex;
   private Timer timer;

   private KeyListener keyListener;
   
   // constructors
   public WallpaperPanel()
   {       
      batman = new Batman();
      backgroundImages = new Image[IMAGE_COUNT];
      imageIndex = 0;
      keyListener = new BatmanKeyListener(batman);

      for (int i = 0; i < backgroundImages.length; i++)
          backgroundImages[i] = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("GothamCity" + (i+1) + ".jpg"));

      timer = new Timer( 1, this );
      timer.start();

      addKeyListener(keyListener);
      addMouseListener( this );
      addMouseMotionListener(this);
      
      setFocusable( true ); // very important line
   }

   // methods
   public void paintComponent( Graphics g)
   {    
      super.paintComponent(g);

      g.drawImage(backgroundImages[imageIndex], 0, 0, MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT, null);

      g.drawImage( batman.getBatmanImage(), batman.getBatmanLocation().x, batman.getBatmanLocation().y,
                  batman.getBatmanImage().getWidth(null), batman.getBatmanImage().getHeight(null), null );
   }
   
   public void actionPerformed( ActionEvent e )
   {
      batman.move();
      repaint();
   }

   public void mouseMoved( MouseEvent e )
   {
      batman.setBatmanLocation( e.getX() - ( batman.getBatmanImage().getWidth(null) / 2 ),
              e.getY() - ( batman.getBatmanImage().getHeight(null) / 2 ) );
   }

   public void mouseDragged(MouseEvent e)
   {
      batman.setBatmanLocation( e.getX() - ( batman.getBatmanImage().getWidth(null) / 2 ),
              e.getY() - ( batman.getBatmanImage().getHeight(null) / 2 ) );
   }

   public void mouseClicked(MouseEvent e) {
   }

   public void mousePressed(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         if (imageIndex == backgroundImages.length - 1)
            imageIndex = 0;
         else
            imageIndex++;
      }
      else if (e.getButton() == MouseEvent.BUTTON3) {
         if (imageIndex == 0)
            imageIndex = backgroundImages.length - 1;
         else
            imageIndex--;
      }
   }

   public void mouseReleased(MouseEvent e) {

   }

   public void mouseEntered(MouseEvent e) {

   }

   public void mouseExited(MouseEvent e) {

   }
}


