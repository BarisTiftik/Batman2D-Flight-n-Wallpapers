import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            boolean checkLeft = ((Batman) object).getBatmanLocation().getX() > -55;
            boolean checkUp = ((Batman) object).getBatmanLocation().getY() > -90;
            boolean checkRight = ((Batman) object).getBatmanLocation().getX() < MainFrame.SCREEN_WIDTH - 210;
            boolean checkDown = ((Batman) object).getBatmanLocation().getY() < MainFrame.SCREEN_HEIGHT - 200;

            if (keyKode == KeyEvent.VK_LEFT && checkLeft)
                ((Batman) object).setVelX(-((Batman) object).getSpeed());
            if (keyKode == KeyEvent.VK_UP && checkUp)
                ((Batman) object).setVelY(-((Batman) object).getSpeed());
            if (keyKode == KeyEvent.VK_RIGHT && checkRight)
                ((Batman) object).setVelX(((Batman) object).getSpeed());
            if (keyKode == KeyEvent.VK_DOWN && checkDown)
                ((Batman) object).setVelY(((Batman) object).getSpeed());

            if (keyKode == KeyEvent.VK_W)
                ((Batman) object).incrementSpeed();
            if (keyKode == KeyEvent.VK_S)
                ((Batman) object).decrementSpeed();
        }
        else if (object instanceof MainFrame) {
            if (keyKode == KeyEvent.VK_ESCAPE) {
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
        int keyKode = e.getKeyCode();
        if (object instanceof Batman) {
            if (keyKode == KeyEvent.VK_LEFT)
                ((Batman) object).setVelX(0);
            if (keyKode == KeyEvent.VK_UP)
                ((Batman) object).setVelY(0);
            if (keyKode == KeyEvent.VK_RIGHT)
                ((Batman) object).setVelX(0);
            if (keyKode == KeyEvent.VK_DOWN)
                ((Batman) object).setVelY(0);
        }
    }
}
