package com.company;

import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel{
    public Intro() {
        super();
        this.setBackground(Color.darkGray);


    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawString("Welcome to Conner's Assignment 10", 500, 300);
    }
}
