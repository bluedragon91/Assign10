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
        g.drawString("[Sorry no instructions yet my dood, we don't even have games yet]" , 50, 475);
        g.drawString("[There'll be instructions here eventually... maybe]" , 50, 490);


    }
}
