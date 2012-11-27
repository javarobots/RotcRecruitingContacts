
package ui.utility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javarobots
 */
public class SearchKeyListener implements KeyListener {
    
    private AbstractTableModel searchTableModel;
    
    public SearchKeyListener(AbstractTableModel model) {
        this.searchTableModel = model;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //DO nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Typed" + e.getKeyChar());
        System.out.println(((JTextField) e.getComponent()).getText());
    }

}
