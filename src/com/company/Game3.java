
package com.company;

import java.awt.*;


public class Game3 extends Game2 {
    Character enemy3;
    int score =0;
    public Game3(Character player){
        super(player);
        enemy3 = new Character(5);
        enemy3.x = 599;
        enemy3.y = 0;
        game =3;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setColor(Color.RED);
        g.drawRect(enemy3.x, enemy3.y, 10, 10);

    }

    public void setCharacter(Color color){
        playerColor = color;
    }

    public void seekPlayer(){
       super.seekPlayer();
        //Enemy 3 movement
        if(player.x > enemy3.x){
            enemy3.moveRight();
        }
        else if(player.x < enemy3.x){
            enemy3.moveLeft();
        }
        if(player.y > enemy3.y){
            enemy3.moveDown();
        }
        else if(player.y < enemy3.y){
            enemy3.moveUp();
        }
        repaint();
    }

    public void newRation(){
        super.newRation();
        enemy3.moveSpeed+=2;
    }

}
