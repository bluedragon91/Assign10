package com.company;
import java.awt.*;

public class Game2 extends Game1 {

    Character enemy2;
    int score =0;
    public Game2(Character player){
        super(player);
        enemy2 = new Character(5);
        enemy2.x = 1199;
        enemy2.y = 0;
        game = 2;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setColor(Color.RED);
        g.drawRect(enemy2.x, enemy2.y, 10, 10);

    }


    public void seekPlayer(){
        super.seekPlayer();
        //Enemy 2 movement
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
            enemy2.moveUp();
        }
        repaint();
    }

    @Override
    public void newRation() {
        super.newRation();
        enemy2.moveSpeed++;
    }
}
