
package ui.utility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author javarobots
 */
public class SearchKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed" + e.getKeyChar());
        System.out.println(((JTextField) e.getComponent()).getText());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //DO nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Do nothing
    }

}
