package ui.utility;

import java.awt.Component;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;

/**
 * A class used for modifying the position on swing components.
 * @author javarobots74
 */
public class ComponentPosition {

    public static void centerFrame(Component c){
        GraphicsDevice[] devices = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        DisplayMode mode = devices[0].getDisplayMode();
        int screenWidth = mode.getWidth();
        int screenHeight = mode.getHeight();
         int x = (screenWidth/2) - (c.getWidth() / 2);
        int y = (screenHeight/2) - (c.getHeight() / 2);
        c.setLocation(x, y);
    }

}
