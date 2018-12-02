
//TODO Implement Game Over
package com.company;

import javax.swing.*;
import java.awt.*;


public class Game2 extends JPanel {

    JButton Back;
    Character player, enemy1, enemy2, ration;
    Color playerColor;
    int score =0;
    public Game2(Character player){
        super();
        enemy1 = new Character(5);
        enemy2 = new Character(5);
        enemy1.x = 0;
        enemy1.y = 0;
        enemy2.x = 1199;
        enemy2.y = 0;
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
        g.drawString("Game2", 500, 300);
        g.drawString("Score: " + score, 20, 575);
        g.setColor(playerColor);
        g.drawRect(player.x, player.y, 10, 10);
        g.setColor(Color.RED);
        g.drawRect(enemy1.x, enemy1.y, 10, 10);
        g.drawRect(enemy2.x, enemy2.y, 10, 10);
        g.setColor(Color.YELLOW);
        g.drawRect(ration.x, ration.y, 8, 8);

    }

    public void setCharacter(Color color){
        playerColor = color;
    }

    public void seekPlayer(){
        if(player.x > enemy1.x){
            enemy1.moveRight();
        }
        else if(player.x < enemy1.x){
            enemy1.moveLeft();
        }
        if(player.y > enemy1.y){
            enemy1.moveDown();
        }
        else if(player.y < enemy1.y){
            enemy1.moveUp();
        }

        if(player.x > enemy2.x){
            enemy2.moveRight();
        }
        else if(player.x < enemy2.x){
            enemy2.moveLeft();
        }
        if(player.y > enemy2.y){
            enemy2.moveDown();
        }
        else if(player.y < enemy2.y){
            enemy2.moveDown();
        }
        repaint();
    }

    public void newRation(){
        ration.x = (int)(Math.random()*1190);
        ration.y = (int)(Math.random()*590);
        repaint();
        score += 10;
    }


}
