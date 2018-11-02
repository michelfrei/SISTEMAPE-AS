
package Controller;

import View.Menu;
import java.awt.Frame;

public class Main {


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setExtendedState(Frame.MAXIMIZED_BOTH);
        
    }
    
}
