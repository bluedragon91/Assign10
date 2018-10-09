package com.company;


public class ViewController {

    Intro intro;
    Menu menu;
    public ViewController() {
        MainFrame frame = new MainFrame();
        intro = new Intro();
        frame.add(intro);
        intro.updateUI();
        try {
            Thread.sleep(4000);
        }
        catch(Exception e){
            System.out.println("I have no idea if this will work and If you're here that's a no");
        }
        frame.remove(intro);

        menu = new Menu();

        frame.add(menu);
        menu.updateUI();
    }
}
