package com.company;

import javax.swing.*;
import java.awt.*;

public class OpRow2 extends JPanel {
    JRadioButton blue;
    JRadioButton white;
    JRadioButton black;

    public OpRow2(){
        super();
        setBackground(Color.DARK_GRAY);
        ButtonGroup charGroup = new ButtonGroup();


        blue = new JRadioButton("Blue");
        white = new JRadioButton("White");
        black = new JRadioButton("Black");

        charGroup.add(blue);
        charGroup.add(white);
        charGroup.add(black);

        white.setSelected(true);
        add(blue);
        add(white);
        add(black);


    }

}
