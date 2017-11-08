package com.mycompany.observer;

import java.util.Observable;
import java.util.Observer;

public class Listener implements Observer {
	public void update(Observable o, Object arg) {
        System.out.println("RunThread死机");
        ObserveImplFunc run = new ObserveImplFunc();
        run.addObserver(this);
        new Thread(run).start();
        System.out.println("RunThread重启");
    }
}
