package com.company;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    GroupLayout layout = new GroupLayout(this);
    JButton menuButton1, menuButton2, menuButton3, menuButton4;
    public Menu() {
        super();
        setBackground(Color.blue);
        menuButton1 = new JButton("Game Menu");
        menuButton2 = new JButton("Options");
        menuButton3 = new JButton("Instructions");
        menuButton4 = new JButton("Credits");
        this.setLayout(layout);
        layout.setHorizontalGroup(

                layout.createSequentialGroup()
                .addComponent(menuButton1)
                .addComponent(menuButton2)
                .addComponent(menuButton3)
                .addComponent(menuButton4)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
        );
    }
}
