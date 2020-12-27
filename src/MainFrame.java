import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements ActionListener {
    public static final int SCREEN_WIDTH = 1800;
    public static final int SCREEN_HEIGHT = 900;

    private JButton startGameButton;
    private JPanel mainPanel;
    JPanel wallpaperPanel;
    private JButton openWallpapersButton;
    private KeyListener keyListener;

    public MainFrame() {
        keyListener = new BatmanKeyListener(this);
        wallpaperPanel = new WallpaperPanel();
        add(mainPanel);

        openWallpapersButton.addActionListener(this);
        wallpaperPanel.addKeyListener(keyListener);

        adjustMainFrameSettings();
    }

    public void adjustMainFrameSettings()
    {
        setTitle( "Batman2D" );
        setBounds( 55, 70, SCREEN_WIDTH, SCREEN_HEIGHT );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openWallpapersButton) {
            setVisible(false);
            remove(mainPanel);
            add(wallpaperPanel);
            repaint();
            setVisible(true);
        }
    }

    public JPanel getWallpaperPanel() {
        return wallpaperPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    /*@Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            setVisible(false);
            remove(wallpaperPanel);
            add(mainPanel);
            setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}

/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frrrame extends JFrame
{
  // constants
  public static final int SCREEN_WIDTH = 1800;
  public static final int SCREEN_HEIGHT = 900;

  // properties
  private JPanel gamePanel;

  // constructors
  public frrrame()
  {
      adjustMainFrameSettings();

      gamePanel = new WallpaperPanel();
      add( gamePanel );

      button1 = new JButton("button1");
      button2 = new JButton("button2");
      button3 = new JButton("button3");

      button1.setAlignmentX(CENTER_ALIGNMENT);
      button2.setAlignmentX(CENTER_ALIGNMENT);
      button3.setAlignmentX(CENTER_ALIGNMENT);

      button1.setSize(100,100);

      add(button1);
      add(button2);
      add(button3);

      button1.setSize(new Dimension(200,200));

  }

public void adjustMainFrameSettings()
        {
        setTitle( "Batman2D-Wallpapers" );
        setBounds( 55, 70, SCREEN_WIDTH, SCREEN_HEIGHT );
        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        }
        }
 */
