package com.company;


public class Character {

    int x;
    int y;

    public Character(){
        x = 550;
        y = 250;

    }

    public void moveUp(){
        this.y -= 4;
    }

    public void moveLeft(){
        this.x -= 4;
    }
    public void moveDown(){
        this.y += 4;
    }
    public void moveRight(){
        this.x += 4;
    }

    public void resetPos(){
        x = 550;
        y = 250;
    }
}
