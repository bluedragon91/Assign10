package com.company;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {

    JButton Back;

    public Options(){
        super();
        setBackground(Color.darkGray);
        Back = new JButton("Back");

        add(Back);

    }
}
