package vista.Util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Tipo;

public class Util {

    public static void initCombo(JComboBox cbx) {

        cbx.removeAllItems();

        for (var tipo : Tipo.values()) {
            cbx.addItem(tipo);
        }

    }

    public static void mensaje(String msg, String title, int tipo) {

        JOptionPane.showMessageDialog(null, msg, title, tipo);

    }
}
