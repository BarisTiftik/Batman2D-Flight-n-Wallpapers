import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

public class BatmanMouseInputListener implements MouseInputListener {

    private Object object;

    public BatmanMouseInputListener(Object object) {
        this.object = object;
    }

    public void mouseMoved( MouseEvent e )
    {
        if (object instanceof WallpaperPanel)
            ((WallpaperPanel) object).getBatman().setBatmanLocation( e.getX() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getWidth(null) / 2 ),
                    e.getY() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getHeight(null) / 2 ) );
    }

    public void mouseDragged(MouseEvent e)
    {
        if (object instanceof WallpaperPanel)
            ((WallpaperPanel) object).getBatman().setBatmanLocation( e.getX() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getWidth(null) / 2 ),
                    e.getY() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getHeight(null) / 2 ) );
    }

    public void mouseClicked(MouseEvent e) {
        /*if (object instanceof MainFrame) {
            if ( e.getSource() == ((MainFrame) object).getInfoLabel() ) {
                JOptionPane.showMessageDialog(new JFrame(), "gg");
            }
        }*/
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (object instanceof WallpaperPanel) {
                if (((WallpaperPanel) object).getImageIndex() == ((WallpaperPanel) object).getBackgroundImages().length - 1)
                    ((WallpaperPanel) object).resetImageIndex();
                else
                    ((WallpaperPanel) object).incrementImageIndex();
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            if (object instanceof WallpaperPanel) {
                if (((WallpaperPanel) object).getImageIndex() == 0)
                    ((WallpaperPanel) object).resetImageIndex();
                else
                    ((WallpaperPanel) object).decrementImageIndex();
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
