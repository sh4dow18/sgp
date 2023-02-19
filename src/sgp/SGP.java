package sgp;

import javax.swing.JOptionPane;
import sgp.Views.MainView;
import sgp.database.Database;

public class SGP {
    public static void main(String[] args) {
        if (Database.get_instance().is_on() == true) {
            new MainView().setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "SQL Connection is down", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
