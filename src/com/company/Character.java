package com.company;


public class Character {

    int x;
    int y;
    int currentGame;
    int moveSpeed;

    public Character(int moveSpeed){
        this.moveSpeed = moveSpeed;
        x = 550;
        y = 250;
        currentGame = 0;

    }

    public void moveUp(){
        this.y -= moveSpeed;
    }

    public void moveLeft(){
        this.x -= moveSpeed;
    }
    public void moveDown(){
        this.y += moveSpeed;
    }
    public void moveRight(){
        this.x += moveSpeed;
    }

    public void resetPos(){
        x = 550;
        y = 250;
    }
    public void setCurrentGame(int view){
        currentGame = view;
    }

    public void setMoveSpeed(int setSpeed){
        moveSpeed = setSpeed;
    }
}
