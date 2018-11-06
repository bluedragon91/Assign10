package com.company;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {

    JButton Back;
    JRadioButton black, dGray, gray, white;

    public Options(){
        super();
        setBackground(Color.darkGray);
        Back = new JButton("Back");
        black = new JRadioButton("Black");
        dGray = new JRadioButton("Dark Gray");
        gray = new JRadioButton("Gray");
        white = new JRadioButton("Whtie");

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(black);
        colorGroup.add(dGray);
        colorGroup.add(gray);
        colorGroup.add(white);

        add(black);
        add(dGray);
        add(gray);
        add(white);

        add(Back);

    }
}
