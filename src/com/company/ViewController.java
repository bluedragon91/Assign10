package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewController implements ActionListener, KeyListener {


    int time = 0;
    int score = 0;
    Character player = new Character();
    Intro intro = new Intro();
    Menu menu = new Menu();
    MainFrame frame = new MainFrame();
    GameMenu gameMenu = new GameMenu(time, score, player);
    Options options = new Options();
    Credits credit = new Credits();
    Instructions instruc = new Instructions();
    Game1 g1 = new Game1(player);
    Game2 g2 = new Game2(player);
    Game3 g3 = new Game3(player);
    Timer timer;
    int timerDelay = 1000;



    public ViewController() {
        frame.add(intro);
        intro.updateUI();
        try {
            Thread.sleep(4000);
        }
        catch(Exception e){
            System.out.println("I have no idea if this will work and If you're here that's a no");
        }
        frame.remove(intro);
        frame.add(menu);
        menu.GamesButton.addActionListener(this);
        menu.InstructionButton.addActionListener(this);
        menu.OptionsButton.addActionListener(this);
        menu.Credits.addActionListener(this);
        menu.updateUI();
        timer = new Timer(timerDelay, this);
        frame.setFocusable(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        //TIMER ACTIONS
        if(obj == timer){
            time++;
            gameMenu.time++;
            gameMenu.updateUI();
        }

        //MENU ACTION LISTENING
        if(obj == menu.GamesButton){
            frame.remove(menu);
            gameMenu.g1.addActionListener(this);
            gameMenu.g2.addActionListener(this);
            gameMenu.g3.addActionListener(this);
            gameMenu.Back.addActionListener(this);
            timer.start();
            gameMenu.addKeyListener(this);
            frame.add(gameMenu);
            gameMenu.updateUI();
            frame.addKeyListener(this);


        }
        else if(obj == menu.OptionsButton){
            frame.remove(menu);
            options.Back.addActionListener(this);
            options.row1.black.addActionListener(this);
            options.row1.dGray.addActionListener(this);
            options.row1.gray.addActionListener(this);
            options.row1.white.addActionListener(this);
            frame.add(options);
            options.updateUI();


        }
        else if(obj == menu.InstructionButton){
            frame.remove(menu);
            instruc.Back.addActionListener(this);
            frame.add(instruc);
            instruc.updateUI();

        }
        else if(obj == menu.Credits){
            frame.remove(menu);
            credit.Back.addActionListener(this);
            frame.add(credit);
            credit.updateUI();

        }

        //CREDITS ACTION LISTENING
        if(obj == credit.Back){
            frame.remove(credit);
            frame.add(menu);
            menu.updateUI();
        }

        //GameMenu ACTION LISTENING
        if(obj == gameMenu.g1){


        }
        else if(obj == gameMenu.g2){


        }
        else if(obj == gameMenu.g3){


        }
        if(obj == gameMenu.Back){
            frame.remove(gameMenu);
            frame.add(menu);
            menu.updateUI();
        }


        //Option ACTION LISTENER
        if(obj == options.Back){
            frame.remove(options);
            frame.add(menu);
            menu.updateUI();
        }
        else if(obj == options.row1.black){
            changeBG(Color.black);
        }
        else if(obj == options.row1.dGray){
            changeBG(Color.darkGray);
        }
        else if(obj == options.row1.gray){
            changeBG(Color.gray);
        }
        else if(obj == options.row1.white){
            changeBG(Color.white);
        }

        //Instructions ACTION LISTENER
        if(obj == instruc.Back){
            frame.remove(instruc);
            frame.add(menu);
            menu.updateUI();
        }

        //Game1 ACTION LISTENER
        if(obj == g1.Back){
            frame.remove(g1);
            frame.add(gameMenu);
            gameMenu.updateUI();
        }
        //Game2 ACTION LISTENER
        if(obj == g2.Back){
            frame.remove(g2);
            frame.add(gameMenu);
            gameMenu.updateUI();
        }
        //Game3 ACTION LISTENER
        if(obj == g3.Back) {
            frame.remove(g3);
            frame.add(gameMenu);
            gameMenu.updateUI();
        }

    }

    public void changeBG(Color bgColor){
        menu.setBackground(bgColor);
        credit.setBackground(bgColor);
        g1.setBackground(bgColor);
        g2.setBackground(bgColor);
        g3.setBackground(bgColor);
        gameMenu.setBackground(bgColor);
        instruc.setBackground(bgColor);
        options.setBackground(bgColor);
    }

    public void setGameChar(int charNum){
        g1.setCharacter(charNum);
        g2.setCharacter(charNum);
        g3.setCharacter(charNum);
    }

    @Override
    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == 'w'){
            player.moveUp();
            gameMenu.repaint();
            g1.repaint();
            g2.repaint();
            g3.repaint();
            System.out.println("W");

        }
        if(e.getKeyChar() == 'a'){
            player.moveLeft();
            gameMenu.repaint();
            g1.repaint();
            g2.repaint();
            g3.repaint();
            System.out.println("A");
        }
        if(e.getKeyChar() == 's'){
            player.moveDown();
            gameMenu.repaint();
            g1.repaint();
            g2.repaint();
            g3.repaint();
            System.out.printf("S");
        }
        if (e.getKeyChar() == 'd'){
            player.moveRight();
            gameMenu.repaint();
            g1.repaint();
            g2.repaint();
            g3.repaint();
            System.out.println("D");
        }
        if((gameMenu.player.x >300 && gameMenu.player.x < 400)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadG1();
        }
        if((gameMenu.player.x >450 && gameMenu.player.x < 550)&&
                (gameMenu.player.y >150 && gameMenu.player.y <200)){
            loadG2();
        }
        if((gameMenu.player.x >600 && gameMenu.player.x < 700)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadG3();
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'w'){
            System.out.println("press w");
        }

    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    public void loadG1(){
        frame.remove(gameMenu);
        g1.Back.addActionListener(this);
        g1.addKeyListener(this);
        frame.add(g1);

        g1.updateUI();
        player.resetPos();
    }
    public void loadG2(){
        frame.remove(gameMenu);
        frame.add(g2);
        g2.addKeyListener(this);
        g2.Back.addActionListener(this);
        g2.updateUI();
        player.resetPos();
    }
    public void loadG3(){
        frame.remove(gameMenu);
        frame.add(g3);
        g3.Back.addActionListener(this);
        g3.addKeyListener(this);
        g3.updateUI();
        player.resetPos();
    }
}


