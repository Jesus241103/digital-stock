package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

public class Modal {
//FUNCION QUE PERZONALIZA LOS JDIALOG

    //AGREGA UN FONDO OPACO SOBRE EL RESTO DE LAS VENTANAS TRASERAS AL JDIALOG, ESTO PARA AGREGAR UN EFECTO DE POFUNDIDAD Y DESENFOQUE
    public void agregarFondoOpaco(JPanel panel) {
        Window parentWindow = SwingUtilities.getWindowAncestor(panel);
        if (parentWindow instanceof JDialog || parentWindow instanceof JFrame) {
            JPanel fondoOpaco = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(0, 0, 0, 120));
                    g2.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            fondoOpaco.setName("fondoOpaco");
            fondoOpaco.setBounds(0, 0, parentWindow.getWidth(), parentWindow.getHeight());
            fondoOpaco.setOpaque(false);
            ((RootPaneContainer) parentWindow).getLayeredPane().add(fondoOpaco, JLayeredPane.MODAL_LAYER);
            parentWindow.revalidate();
            parentWindow.repaint();
        }
    }
    //AL MOMENTO DE CERRAR EL JDIALOG, EL FONDO OPACO SE ELIMINA, PERMITIENDO QUITAR ESE EFECTO DE PROFUNDIDAD DEL JDIALOG
    public void quitarFondoOpaco(Window parent) {
        if (parent instanceof RootPaneContainer rootPaneContainer) {
            JLayeredPane layeredPane = rootPaneContainer.getLayeredPane();
            for (Component comp : layeredPane.getComponents()) {
                if ("fondoOpaco".equals(comp.getName())) {
                    layeredPane.remove(comp);
                    break;
                }
            }
            layeredPane.revalidate();
            layeredPane.repaint();
        }
    }

    //FUNCION QUE GESTIONA EL CIERRE DE LA VENTANA DEL JDIALOG
    public void cerrarDialogo(JDialog dialog) {
        dialog.dispose();
        Window parentWindow = SwingUtilities.getWindowAncestor(dialog);
        quitarFondoOpaco(parentWindow);
    }
    
}
