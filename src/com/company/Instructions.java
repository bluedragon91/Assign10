package com.company;

import javax.swing.*;
import java.awt.*;

public class Instructions extends JPanel {

    JButton Back;

    public Instructions(){
        super();
        setBackground(Color.darkGray);
        Back = new JButton("Back");
        add(Back);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawString("Game 1: Avoid the zombie and collect as many rations as possible before you're caught!" , 450, 300);


    }
}
