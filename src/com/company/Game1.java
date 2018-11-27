//TODO Implement score
//TODO Implement Game Over
package com.company;

import javax.swing.*;
import java.awt.*;


public class Game1 extends JPanel {

    JButton Back;
    Character player, enemy, ration;
    Color playerColor;
    int score =0;
    public Game1(Character player){
        super();
        enemy = new Character(5);
        enemy.x = 0;
        enemy.y = 0;
        this.player = player;
        ration = new Character(0);
        ration.x = 560;
        ration.y = 250;
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Back = new JButton("Back");

        Back.setBounds(500,150,100,50);
        add(Back);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Game1", 500, 300);
        g.drawString("Score: " + score, 20, 575);
        g.setColor(playerColor);
        g.drawRect(player.x, player.y, 10, 10);
        g.setColor(Color.RED);
        g.drawRect(enemy.x, enemy.y, 10, 10);
        g.setColor(Color.YELLOW);
        g.drawRect(ration.x, ration.y, 8, 8);

    }

    public void setCharacter(Color color){
        playerColor = color;
    }

    public void seekPlayer(){
        if(player.x > enemy.x){
            enemy.moveRight();
        }
        else if(player.x < enemy.x){
            enemy.moveLeft();
        }
        if(player.y > enemy.y){
            enemy.moveDown();
        }
        else if(player.y < enemy.y){
            enemy.moveUp();
        }
        repaint();
    }

    public void newRation(){
        ration.x = (int)(Math.random()*1190);
        ration.y = (int)(Math.random()*590);
        enemy.moveSpeed++;
        repaint();
        score += 10;
    }


}
