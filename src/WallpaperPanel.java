import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class WallpaperPanel extends JPanel implements ActionListener {
   // properties
   private final int IMAGE_COUNT = 11;

   private Batman batman;
   private Image[] backgroundImages;
   private int imageIndex;
   private Timer timer;

   private KeyListener keyListener;
   private MouseInputListener mouseInputListener;
   
   // constructors
   public WallpaperPanel() {
      batman = new Batman();
      backgroundImages = new Image[IMAGE_COUNT];
      imageIndex = 0;
      keyListener = new BatmanKeyListener(batman);
      mouseInputListener = new BatmanMouseInputListener(this);

      for (int i = 0; i < backgroundImages.length; i++)
          backgroundImages[i] = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("GothamCity" + (i+1) + ".jpg"));

      timer = new Timer( 1, this );
      timer.start();

      addKeyListener(keyListener);
      addMouseListener( mouseInputListener );
      addMouseMotionListener(mouseInputListener);
      
      setFocusable( true ); // very important line
   }

   // methods
   @Override
   public void paintComponent( Graphics g) {
      super.paintComponent(g);

      g.drawImage(backgroundImages[imageIndex], 0, 0, MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT, null);

      g.drawImage( batman.getBatmanImage(), batman.getBatmanLocation().x, batman.getBatmanLocation().y,
                  batman.getBatmanImage().getWidth(null), batman.getBatmanImage().getHeight(null), null );
   }

   @Override
   public void actionPerformed( ActionEvent e ) {
      batman.move();
      repaint();
   }

   public Batman getBatman() {
      return batman;
   }

   public int getImageIndex() {
      return imageIndex;
   }

   public void resetImageIndex() {
      if (imageIndex == backgroundImages.length - 1)
         imageIndex = 0;
      else if (imageIndex == 0)
         imageIndex = backgroundImages.length - 1;
   }

   public void incrementImageIndex() {
      imageIndex++;
   }

   public void decrementImageIndex() {
      imageIndex--;
   }

   public Image[] getBackgroundImages() {
      return backgroundImages;
   }
}


