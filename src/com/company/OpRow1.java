package com.company;

import javax.swing.*;
import java.awt.*;

public class OpRow1 extends JPanel {
    JRadioButton black;
    JRadioButton dGray;
    JRadioButton gray;
    JRadioButton white;

    public OpRow1(){
        super();
        setBackground(Color.DARK_GRAY);
        ButtonGroup colorGroup = new ButtonGroup();
        black = new JRadioButton("Black");
        dGray = new JRadioButton("Dark Gray");
        gray = new JRadioButton("Gray");
        white = new JRadioButton("Whtie");

        colorGroup.add(black);
        colorGroup.add(dGray);
        colorGroup.add(gray);
        colorGroup.add(white);

        dGray.setSelected(true);
        add(black);
        add(dGray);
        add(gray);
        add(white);


    }

}
