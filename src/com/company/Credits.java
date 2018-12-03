package com.company;

import javax.swing.*;
import java.awt.*;

public class Credits extends JPanel {

    JButton Back;
    public Credits(){
        super();
        setBackground(Color.darkGray);
        setLayout(null);
        Back = new JButton("Back");
        Back.setBounds(500, 500, 75, 50);
        add(Back);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Made by Conner Smith for IST 240", 500, 300);

    }
}
