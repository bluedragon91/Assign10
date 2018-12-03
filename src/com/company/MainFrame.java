package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainFrame(){
        super("Conner's Final Project");
        MacLayoutSetup();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
    }
    public void MacLayoutSetup() {
        // On some MACs it might be necessary to have the statement below
        //for the background color of the button to appear
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
