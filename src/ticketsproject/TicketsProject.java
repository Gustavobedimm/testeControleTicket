package ticketsproject;

import javax.swing.UIManager;
import visao.Principal;

/**
 *
 * @author gustavobedim
 */
public class TicketsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
            Principal principal = new Principal();
            principal.setVisible(true);
            
    }
    
}
