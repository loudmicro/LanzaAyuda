/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzaayuda;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/**
 *
 * @author Juanu
 */
public class LanzaAyuda {

    private static JFrame frame;
    private static JPanel panel;
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JMenuItem miLanzarAyuda;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos la ventana
        frame = new JFrame("LanzaAyuda");
        
        //creamos el panel
        panel = new JPanel();
        panel.setSize(300,300);
        
        menuBar = new JMenuBar();
        menu = new JMenu("Ayuda");
        menuBar.add(menu);

        
        miLanzarAyuda = new JMenuItem("Lanzar ayuda");
        //enlazamos con la ayuda
        
        HelpSet hs = obtenFichAyuda();
        HelpBroker hb = hs.createHelpBroker();
        hb.enableHelpOnButton(miLanzarAyuda, "guiaMain", hs);
        hb.setSize(new Dimension(1200,900));
        miLanzarAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0)); hb.enableHelpKey(miLanzarAyuda, "guiaMain", hs);
        
        
        
        menu.add(miLanzarAyuda);
        
        //añadimos el menu al panel
        
        frame.setJMenuBar(menuBar);
        

        frame.add(panel);
        
        frame.setVisible(true);
        frame.setSize(300, 300);

        
    }
    
    public static HelpSet obtenFichAyuda(){
    
        try {
            //ClassLoader cl = LanzaAyuda.class.getClassLoader();
            File file = new File(LanzaAyuda.class.getResource("help/helpset.hs").getFile());
            URL url = file.toURI().toURL();
            HelpSet hs = new HelpSet(null,url);
            return hs;           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Fichero HelpSet no encontrado");
            return  null;
        }
    
    }
    
}
