package com.company;

import javax.swing.*;
import java.awt.*;

public class Game3 extends JPanel {

    JButton Back;

    public Game3(){
        super();
        setBackground(Color.DARK_GRAY);
        Back = new JButton("Back");

        add(Back);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Game3", 500, 300);

    }

    public void setCharacter(int charNum){

    }
}
