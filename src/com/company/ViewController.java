package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController implements ActionListener {


    int time = 0;
    int score = 0;
    Intro intro = new Intro();
    Menu menu = new Menu();
    MainFrame frame = new MainFrame();
    GameMenu gameMenu = new GameMenu(time, score);
    Options options = new Options();
    Credits credit = new Credits();
    Instructions instruc = new Instructions();
    Game1 g1 = new Game1();
    Game2 g2 = new Game2();
    Game3 g3 = new Game3();
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
            frame.add(gameMenu);
            gameMenu.updateUI();

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
            frame.remove(gameMenu);
            g1.Back.addActionListener(this);
            frame.add(g1);

            g1.updateUI();

        }
        else if(obj == gameMenu.g2){
            frame.remove(gameMenu);
            frame.add(g2);
            g2.Back.addActionListener(this);
            g2.updateUI();

        }
        else if(obj == gameMenu.g3){
            frame.remove(gameMenu);
            frame.add(g3);
            g3.Back.addActionListener(this);
            g3.updateUI();

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

}
