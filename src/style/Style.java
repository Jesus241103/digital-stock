package style;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Style {

    //APLICA EL LOOK AND FEEL A TODOS LOS COMPONENTES
    //Y COLOCA LA CABECERA DE TODAS LAS TABLAS COLOR AZUL
    public void Style() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.put("TableHeader.background", new Color(0, 0, 153));
            UIManager.put("TableHeader.foreground", Color.WHITE);
            UIManager.put("Table.gridColor", Color.WHITE);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger("AppLogger").log(Level.SEVERE, null, ex);
        }
    }

}
