
package ui.utility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import ui.contactform.RotcContactsController;
import ui.contactform.SearchTableModel;

/**
 *
 * @author javarobots
 */
public class SearchKeyListener implements KeyListener {
    
    private AbstractTableModel searchTableModel;
    private RotcContactsController controller;
    
    public SearchKeyListener(AbstractTableModel model, RotcContactsController controller) {
        this.searchTableModel = model;
        this.controller = controller;
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
        ResultSet result = controller.getModel().getQueries().contactSearch(((JTextField)e.getComponent()).getText());
        if (result != null){
            ((SearchTableModel)searchTableModel).updateData(result);
        } else {
            ((SearchTableModel)searchTableModel).clearData();
        }
    }

}
