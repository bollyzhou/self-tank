package com.self.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode extends GameObject {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private boolean living = true;
    GameModle gm = null;

    private int step = 0;

    public Explode(int x, int y, GameModle gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            gm.removeGameObject(this);
        }
    }
}
