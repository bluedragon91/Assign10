package com.company;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {

    JButton g1, g2, g3, Back;

    int time;

    public GameMenu(int time){
        super();
        setBackground(Color.darkGray);
        this.time = time;
        g1 = new JButton("Game 1");
        g2 = new JButton("Game 2");
        g3 = new JButton("Game 3");
        Back = new JButton("Back");

        add(g1);
        add(g2);
        add(g3);
        add(Back);


    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawString("Your current time played is "  + time, 500, 300);

    }
}
