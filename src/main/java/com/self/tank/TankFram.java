package com.self.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class TankFram extends Frame {

    Tank myTank = new Tank(400, 500, Dir.UP, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enemyTanks = new ArrayList<>();
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 800;
    List<Explode> explodes = new ArrayList<>();
    public TankFram() {
        setResizable(false);
        setVisible(true);
        setTitle("Self-Tank");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);


        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + enemyTanks.size(), 10, 80);
        g.drawString("炸弹的数量:" + explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (Tank t : enemyTanks) {
            t.paint(g);
        }
        for (Bullet b : bullets) {
            b.paint(g);
        }
        for (Explode explode : explodes) {
            explode.paint(g);
        }
        // 子弹是否打中坦克
        for (Bullet bullet : bullets) {
            for (Tank enemyTank : enemyTanks) {
                bullet.collideWith(enemyTank);
            }
        }

//        // 消除内存占用
//        bullets.removeIf(b -> !b.living);

    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }



    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bU) {
                    myTank.setDir(Dir.UP);
                }
                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }
                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }
            }
        }
    }
}
