package com.company;

import javax.swing.*;
import java.awt.*;

public class Game1 extends JPanel {

    JButton Back;

    public Game1(){
        super();
        setBackground(Color.DARK_GRAY);
        Back = new JButton("Back");

        add(Back);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Game1", 500, 300);

    }

}
