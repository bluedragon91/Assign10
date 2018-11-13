package com.company;

import javax.swing.*;
import java.awt.*;

public class OpRow2 extends JPanel {
    JRadioButton char1;
    JRadioButton char2;
    JRadioButton char3;

    public OpRow2(){
        super();
        setBackground(Color.gray);

        ButtonGroup charGroup = new ButtonGroup();


        char1 = new JRadioButton("Character 1");
        char2 = new JRadioButton("Character 2");
        char3 = new JRadioButton("Character 3");

        charGroup.add(char1);
        charGroup.add(char2);
        charGroup.add(char3);

        add(char1);
        add(char2);
        add(char3);


    }

}
