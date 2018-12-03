package com.company;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel{
    int score;
    public GameOver(int score){
        super();
        this.setBackground(Color.darkGray);
        this.score = score;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawString("Game Over", 500, 300);
        g.drawString("Your score was: " + score, 500, 350);
    }
}
