package com.company;

import javax.swing.*;
import java.awt.*;

public class Game2 extends JPanel {

    JButton Back;
    Character player;
    Color playerColor;
    public Game2(Character player){
        super();
        this.player = player;
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Back = new JButton("Back");

        Back.setBounds(500,150,100,50);
        add(Back);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Game2", 500, 300);
        g.setColor(playerColor);
        g.drawRect(player.x, player.y, 10, 10);


    }

    public void setCharacter(Color color){
        playerColor = color;
    }
}
