package com.company;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    int score;
    public GameOver(int score){
        super();
        setLayout(null);
        setBackground(Color.darkGray);
        this.score = score;

    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Game Over", 500, 400);
        g.drawString("Your score was: " + score, 500, 450);
    }
}
