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
    int gameTime = 0;
    Timer gameTimer = new Timer(g1delay, this);
    int game1Ration = 0;
    int game2Ration = 0;
    int game3Ration = 0;
    GameOver overScreen = new GameOver(score);




    public ViewController() {
        frame.add(intro);
        intro.updateUI();
        try {
            Thread.sleep(3500);
        }
        catch(Exception e){
            System.out.println("Exception?");
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
        //Options button listening
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

        //Instructions buttons
        else if(obj == menu.InstructionButton){
            frame.remove(menu);
            instruc.Back.addActionListener(this);
            frame.add(instruc);
            instruc.updateUI();

        }
        //Credits buttons
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


        //Game Timer
        if(obj == gameTimer){
            switch(player.currentGame){
                case 1:
                    g1.seekPlayer();
                    break;
                case 2:
                    g2.seekPlayer();
                    break;
                case 3:
                    g3.seekPlayer();
                    break;
            }
            gameTime++;
            if(g1delay > gameTime) {
                gameTimer.setDelay(g1delay - gameTime);
            }
            collisionCheck();
        }

    }

    //Method for changing the background in all the panels
    public void changeBG(Color bgColor){
        menu.setBackground(bgColor);
        credit.setBackground(bgColor);
        g1.setBackground(bgColor);
        g2.setBackground(bgColor);
        g3.setBackground(bgColor);
        gameMenu.setBackground(bgColor);
        instruc.setBackground(bgColor);
        options.setBackground(bgColor);
        overScreen.setBackground(bgColor);
    }

    //Method to change the character color everywhere
    public void setGameChar(Color color){
        g1.setCharacter(color);
        g2.setCharacter(color);
        g3.setCharacter(color);
        gameMenu.setCharacter(color);
    }

    //WASD Key movement detection
    @Override
    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == 'w'){ up(); }
        if(e.getKeyChar() == 'a'){ left(); }
        if(e.getKeyChar() == 's'){ down(); }
        if(e.getKeyChar() == 'd'){ right(); }
        collisionCheck();

    }

    //Arrow Key movement detection
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){ up(); }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){ left(); }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){ down(); }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){ right(); }
        collisionCheck();
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
        player.currentGame = 0;
    }

    public void gameOver(Game1 game){
        overScreen.score = game.score;
        frame.remove(game);
        frame.add(overScreen);
        overScreen.updateUI();

        overScreen.repaint();



        gameTimer.setDelay(1000);

        //Uses gameTimer to pause game on the game over screen for 5 seconds
        if(gameTime >7){
            gameTime  =0;
        }
        gameTimer.start();
        if(!(gameTime < 5)) {
            gameMenu.score = score;
            loadGameMenu(overScreen);
            game.score = 0;
        }

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


    //checks the collision based on the current game
    public void collisionCheck(){
        switch(player.currentGame){
            case 0:
                game0Collision();
                break;
            case 1:
                game1Collision();
                break;
            case 2:
                game2Collision();
                break;
            case 3:
                game3Collision();
                break;
        }
    }

    //GameMenu button collision
    public void game0Collision(){
        if((gameMenu.player.x >300 && gameMenu.player.x < 400)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadGame(g1);
            player.setCurrentGame(1);
            gameTimer.restart();
            g1delay = 300;
            gameTimer.setDelay(g1delay);
            g1.enemy1.x = 0;
            g1.enemy1.y = 0;
        }
        if((gameMenu.player.x >450 && gameMenu.player.x < 550)&&
                (gameMenu.player.y >150 && gameMenu.player.y <200)){
            loadGame(g2);
            player.setCurrentGame(2);
            gameTimer.restart();
            g1delay = 300;
            gameTimer.setDelay(g1delay);
            g2.enemy1.x = 0;
            g2.enemy1.y = 0;
            g2.enemy2.x = 1160;
            g2.enemy2.y = 0;

        }
        if((gameMenu.player.x >600 && gameMenu.player.x < 700)&&
                (gameMenu.player.y >200 && gameMenu.player.y <250)){
            loadGame(g3);
            player.setCurrentGame(3);
            gameTimer.restart();
            g1delay = 300;
            gameTimer.setDelay(g1delay);
            g3.enemy1.x = 0;
            g3.enemy1.y = 0;
            g3.enemy2.x = 1199;
            g3.enemy2.y = 0;
            g3.enemy3.x = 599;
            g3.enemy3.y = 0;
        }
        if((gameMenu.player.x >450 && gameMenu.player.x < 550)&&
                (gameMenu.player.y >300 && gameMenu.player.y <350)){
            gameTimer.stop();
            frame.remove(gameMenu);
            frame.add(menu);
            menu.updateUI();
        }
    }

    //Game 1 collision
    public void game1Collision(){
        //Back Button
        if((g1.player.x >500 && g1.player.x < 600)&&
                (g1.player.y >150 && g1.player.y <200)){
            loadGameMenu(g1);
            gameTimer.stop();
            player.setCurrentGame(0);
        }
        //Ration
        if((g1.player.x +14 > g1.ration.x-8 && g1.player.x -4 < g1.ration.x + 8) &&
                (g1.player.y +14 > g1.ration.y-8 && g1.player.y-4 < g1.ration.y + 8)){
            collectRation(g1, game1Ration);
        }
        //Enemy
        if((g1.player.x +14 > g1.enemy1.x-8 && g1.player.x -4 < g1.enemy1.x + 8) &&
                (g1.player.y +14 > g1.enemy1.y-8 && g1.player.y-4 < g1.enemy1.y + 8)){
            gameOver(g1);
        }
    }

    //Game 2 Collision
    public void game2Collision(){
        //Back button
        if((g2.player.x >500 && g2.player.x < 600)&&
                (g2.player.y >150 && g2.player.y <200)){
            loadGameMenu(g2);
            gameTimer.stop();
            player.setCurrentGame(0);
        }
        //Ration
        if((g2.player.x +15 > g2.ration.x-8 && g2.player.x -4 < g2.ration.x + 8) &&
                (g2.player.y +14 > g2.ration.y-8 && g2.player.y-4 < g2.ration.y + 8)){
            collectRation(g2, game2Ration);
        }
        //Enemies
        if(((g2.player.x +14 > g2.enemy1.x-8 && g2.player.x -4 < g2.enemy1.x + 8) &&
                (g2.player.y +14 > g2.enemy1.y-8 && g2.player.y-4 < g2.enemy1.y + 8))
                ||((g2.player.x +14 > g2.enemy2.x-8 && g2.player.x -4 < g2.enemy2.x + 8) &&
                (g2.player.y +14 > g2.enemy2.y-8 && g2.player.y-4 < g2.enemy2.y + 8))){
            gameOver(g2);
        }
    }

    //Game 3 Collision
    public void game3Collision(){
        //Back
        if((g3.player.x >500 && g3.player.x < 600)&&
                (g3.player.y >150 && g3.player.y <200)){
            loadGameMenu(g3);
            gameTimer.stop();
            player.setCurrentGame(0);
        }
        //Ration
        if((g3.player.x +15 > g3.ration.x-8 && g3.player.x -4 < g3.ration.x + 8) &&
                (g3.player.y +14 > g3.ration.y-8 && g3.player.y-4 < g3.ration.y + 8)){
           collectRationG3(g3,game3Ration);
        }
        //Enemies
        if(((g3.player.x +14 > g3.enemy1.x-8 && g3.player.x -4 < g3.enemy1.x + 8) &&
                (g3.player.y +14 > g3.enemy1.y-8 && g3.player.y-4 < g3.enemy1.y + 8))
                ||((g3.player.x +14 > g3.enemy2.x-8 && g3.player.x -4 < g3.enemy2.x + 8) &&
                (g3.player.y +14 > g3.enemy2.y-8 && g3.player.y-4 < g3.enemy2.y + 8))
                ||((g3.player.x +14 > g3.enemy3.x-8 && g3.player.x -4 < g3.enemy3.x + 8) &&
                (g3.player.y +14 > g3.enemy3.y-8 && g3.player.y-4 < g3.enemy3.y + 8))){
            gameOver(g3);
        }
    }

    //For when a player hits a ration block, it will make the first enemy faster
    public void collectRation(Game1 game, int gameRation){
        game.newRation();
        score += 10;
        gameRation++;
        if(gameRation % 4 == 0){
            game.player.moveSpeed++;
        }
        if(gameRation % 2 == 0){
            game.enemy1.moveSpeed++;
        }
    }

    //For in game 3 where there's 3 enemies and all the enemies get faster
    public void collectRationG3(Game3 game, int gameRation){
        collectRation(game, game3Ration);
        if(gameRation % 2 == 0){
            game.enemy2.moveSpeed++;
            game.enemy3.moveSpeed+=2;
        }
    }

}