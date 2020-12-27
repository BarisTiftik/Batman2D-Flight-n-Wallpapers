import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BatmanKeyListener implements KeyListener {

    Object object;

    public BatmanKeyListener(Object object) {
        if (object instanceof Batman)
            this.object = (Batman)object;
        else if (object instanceof MainFrame)
            this.object = (MainFrame)object;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyKode = e.getKeyCode();
        if (object instanceof Batman) {
            if (keyKode >= 37 && keyKode <= 40)
                ((Batman) object).speedUp(keyKode - 37); // 37, 38, 39, 40 is respectively LEFT, UP, RIGHT, DOWN
        }
        else if (object instanceof MainFrame) {
            if (keyKode == KeyEvent.VK_BACK_SPACE) {
                ((MainFrame)object).setVisible(false);
                ((MainFrame)object).remove(((MainFrame) object).getWallpaperPanel());
                ((MainFrame)object).add(((MainFrame) object).getMainPanel());
                ((MainFrame)object).setVisible(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (object instanceof Batman)
            ((Batman) object).stop();
    }
}
