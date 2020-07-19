package com.self.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    private boolean living = true;
    TankFram tankFram = null;

    private int step = 0;

    public Explode(int x, int y, TankFram tankFram) {
        this.x = x;
        this.y = y;
        this.tankFram = tankFram;
        new Audio("audio/explode.wav").play();
    }


    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            step = 0;
        }
    }
}
