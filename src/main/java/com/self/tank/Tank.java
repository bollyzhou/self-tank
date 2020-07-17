package com.self.tank;

import java.awt.*;

/**
 * @Author: ZST
 * @Date: 2020/7/8
 */
public class Tank {

    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFram tankFram = null;

    public TankFram getTankFram() {
        return tankFram;
    }

    public void setTankFram(TankFram tankFram) {
        this.tankFram = tankFram;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, TankFram tankFram) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFram = tankFram;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);

        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tankFram.bullets.add(new Bullet(this.x, this.y, this.dir, tankFram));
    }
}
