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
}
