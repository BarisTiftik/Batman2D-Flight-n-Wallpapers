import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class BatmanKeyListener implements KeyListener {

    private Object object;

    public BatmanKeyListener(Object object) {
        this.object = object;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyKode = e.getKeyCode();
        if (object instanceof Batman) {
            if (keyKode >= 37 && keyKode <= 40)
                ((Batman) object).addVelocity(keyKode - 37); // 37, 38, 39, 40 is respectively LEFT, UP, RIGHT, DOWN

            if (keyKode == KeyEvent.VK_W)
                ((Batman) object).incrementSpeed();
            else if (keyKode == KeyEvent.VK_S)
                ((Batman) object).decrementSpeed();
        }
        else if (object instanceof MainFrame) {
            if (keyKode == KeyEvent.VK_BACK_SPACE) {
                if (((MainFrame) object).getFlightPanel().isDisplayable()) {
                    ((MainFrame) object).setVisible(false);
                    ((MainFrame) object).remove(((MainFrame) object).getFlightPanel());
                    ((MainFrame) object).add(((MainFrame) object).getMainPanel());
                    ((MainFrame) object).setVisible(true);
                }
                else if (((MainFrame) object).getMainPanel().isDisplayable())
                    System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (object instanceof Batman)
            ((Batman) object).stop();
    }
}
