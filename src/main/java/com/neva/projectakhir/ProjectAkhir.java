/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.neva.projectakhir;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Rimba Nevada
 */
public class ProjectAkhir {

    public static void main(String[] args) {
       try { 
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
       }
}
