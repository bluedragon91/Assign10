package com.company;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    JButton menuButton1, menuButton2, menuButton3, menuButton4;
    public Menu() {
        super();
        setBackground(Color.DARK_GRAY);
        menuButton1 = new JButton("Game Menu");
        menuButton2 = new JButton("Options");
        menuButton3 = new JButton("Instructions");
        menuButton4 = new JButton("Credits");
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);
        menuButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton4.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(menuButton1);
        add(menuButton2);
        add(menuButton3);
        add(menuButton4);


    }
}
