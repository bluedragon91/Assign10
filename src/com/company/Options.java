package com.company;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {

    JButton Back;

    OpRow1 row1;
    OpRow2 row2;

    public Options(){
        super();
        setBackground(Color.darkGray);
        this.setLayout(null);
        row1 = new OpRow1();
        row2 = new OpRow2();
        row1.setBounds(350, 0, 500, 75);
        row2.setBounds(350, 100, 500, 75);

        Back = new JButton("Back");
        Back.setBounds(575,500, 75, 50);
        add(row1);
        add(row2);
        add(Back);

    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if(row1 != null) {
            row1.setBackground(bg);
        }
        if(row2 != null) {
            row2.setBackground(bg);
        }
    }
}
