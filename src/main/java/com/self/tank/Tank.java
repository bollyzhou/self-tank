package com.self.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Author: ZST
 * @Date: 2020/7/8
 */
public class Tank {
    public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int BAD_SPEED = 1;
    private static final int GOOD_SPEED = 10;
    private boolean moving = true;
    private TankFram tankFram = null;
    private boolean living = true;
    private Group group;
    private Random random = new Random();


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public Tank(int x, int y, Dir dir, Group group, TankFram tankFram) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFram = tankFram;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFram.enemyTanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(group.equals(Group.BAD) ? ResourceMgr.badTankL : ResourceMgr.goodTankL, x, y, null);
                break;
            case UP:
                g.drawImage(group.equals(Group.BAD) ? ResourceMgr.badTankU : ResourceMgr.goodTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(group.equals(Group.BAD) ? ResourceMgr.badTankR : ResourceMgr.goodTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(group.equals(Group.BAD) ? ResourceMgr.badTankD : ResourceMgr.goodTankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        if (group.equals(Group.GOOD)) {
           changeSpeed(GOOD_SPEED);
        } else {
            changeSpeed(BAD_SPEED);
        }
        if (group.equals(Group.BAD) && random.nextInt(100) > 95) {
            this.fire();
        }
        if (group.equals(Group.BAD) && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

    }

    private void boundsCheck() {
        if (x >= TankFram.GAME_WIDTH - WIDTH) {
            x = TankFram.GAME_WIDTH - WIDTH;
        }
        if (y >= TankFram.GAME_HEIGHT - HEIGHT) {
            y = TankFram.GAME_HEIGHT - HEIGHT;
        }
        if (x <= 0) {
            x = 0;
        }
        if (y <= 30) {
            y = 30;
        }
    }

    private void changeSpeed(int speed) {
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
    }


    private void randomDir() {
        dir = Dir.values()[random.nextInt(Dir.values().length)];
    }

    public void fire() {
        int bX = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFram.bullets.add(new Bullet(bX, bY, this.dir, this.group, tankFram));
    }

    public void die() {
        this.living = false;
    }
}
