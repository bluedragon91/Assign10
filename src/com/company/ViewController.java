package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class ViewController implements ActionListener, KeyListener {


    int time = 0;
    int score = 0;
    Character player = new Character(10);
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
    int g1delay = 300;
    int g1Time = 0;
    Timer g1timer = new Timer(g1delay, this);




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
            frame.add(gameMenu);
            gameMenu.updateUI();

            //Prevents a bug where the user could exit to menu and go back to game and get a double speed character
            if(time == 0) {
                gameMenu.addKeyListener(this);
                frame.addKeyListener(this);
            }

            timer.start();


        }
        else if(obj == menu.OptionsButton){
            frame.remove(menu);
            options.Back.addActionListener(this);
            options.row1.black.addActionListener(this);
            options.row1.dGray.addActionListener(this);
            options.row1.gray.addActionListener(this);
            options.row1.white.addActionListener(this);

            options.row2.blue.addActionListener(this);
            options.row2.black.addActionListener(this);
            options.row2.white.addActionListener(this);
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
        else if(obj == options.row2.blue){
            setGameChar(Color.blue);
        }
        else if(obj == options.row2.black){
            setGameChar(Color.black);
        }
        else if(obj == options.row2.white){
            setGameChar(Color.white);
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

        //Game 1 Timer
        if(obj == g1timer){
            g1Time++;
            g1.seekPlayer();
            if(g1Time > g1delay) {
                g1timer.setDelay(g1delay - g1Time);
            }
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

    public void setGameChar(Color color){
        g1.setCharacter(color);
        g2.setCharacter(color);
        g3.setCharacter(color);
        gameMenu.setCharacter(color);
    }

    @Override
    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == 'w'){ up(); }
        if(e.getKeyChar() == 'a'){ left(); }
        if(e.getKeyChar() == 's'){ down(); }
        if(e.getKeyChar() == 'd'){ right(); }

        //GameMenu button collision
        if(player.currentGame == 0 && (gameMenu.player.x >300 && gameMenu.player.x < 400)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadGame(g1);
            player.setCurrentGame(1);
            g1timer.restart();
        }
        if(player.currentGame == 0 && (gameMenu.player.x >450 && gameMenu.player.x < 550)&&
                (gameMenu.player.y >150 && gameMenu.player.y <200)){
            loadGame(g2);
            player.setCurrentGame(2);
        }
        if(player.currentGame == 0 && (gameMenu.player.x >600 && gameMenu.player.x < 700)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadGame(g3);
            player.setCurrentGame(3);
        }
        if(player.currentGame == 0 && (gameMenu.player.x >450 && gameMenu.player.x < 550)&&
                (gameMenu.player.y >300 && gameMenu.player.y <350)){
            frame.remove(gameMenu);
            frame.add(menu);
            menu.updateUI();
        }


        //Game 1 collision
        if(player.currentGame == 1 && (g1.player.x >500 && g1.player.x < 600)&&
                (g1.player.y >150 && g1.player.y <200)){
            loadGameMenu(g1);
            g1timer.stop();
            player.setCurrentGame(0);
        }
        if(player.currentGame == 1 && (g1.player.x +4 > g1.ration.x && g1.player.x -4 < g1.ration.x + 8) &&
                (g1.player.y +4 > g1.ration.y && g1.player.y-4 < g1.ration.y + 8)){
            g1.newRation();
            score += 10;
        }

        //Game 2 Collision
        if(player.currentGame == 2 && (g2.player.x >500 && g2.player.x < 600)&&
                (g2.player.y >150 && g2.player.y <200)){
            loadGameMenu(g2);
            player.setCurrentGame(0);
        }

        //Game 3 Collision
        if(player.currentGame == 3 && (g3.player.x >500 && g3.player.x < 600)&&
                (g3.player.y >150 && g3.player.y <200)){
            loadGameMenu(g3);
            player.setCurrentGame(0);
            frame.remove(g3);
        }

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){ up(); }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){ left(); }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){ down(); }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){ right(); }
    }
    @Override
    public void keyReleased(KeyEvent e){

    }

    public void loadGame(JPanel game){
        frame.remove(gameMenu);
        frame.add(game);
        game.addKeyListener(this);
        game.updateUI();
        player.resetPos();
    }

    public void loadGameMenu(JPanel game){
        frame.remove(game);
        gameMenu.Back.addActionListener(this);
        frame.add(gameMenu);
        gameMenu.updateUI();
        player.resetPos();
    }

    public void up(){
        player.moveUp();
        gameMenu.repaint();
        g1.repaint();
        g2.repaint();
        g3.repaint();
    }

    public void left(){
        player.moveLeft();
        gameMenu.repaint();
        g1.repaint();
        g2.repaint();
        g3.repaint();
    }

    public void down(){
        player.moveDown();
        gameMenu.repaint();
        g1.repaint();
        g2.repaint();
        g3.repaint();
    }

    public void right(){
        player.moveRight();
        gameMenu.repaint();
        g1.repaint();
        g2.repaint();
        g3.repaint();
    }



}


