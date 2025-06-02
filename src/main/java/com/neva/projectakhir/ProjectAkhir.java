package com.neva.projectakhir;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
/**
 *
 * @author Rimba Nevada
 */
public class ProjectAkhir {

    public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        }
        
        catch(UnsupportedLookAndFeelException ex){
            System.err.println("Failed to load theme");
        }
        SwingUtilities.invokeLater(() -> {
            new HomePanel().setVisible(true);
        });
    }
}