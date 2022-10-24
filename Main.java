/*
 * Main Program to initiate the frames
 */

import javax.swing.UIManager;

import Frontend.MainFrame;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
        new MainFrame();
    }
}