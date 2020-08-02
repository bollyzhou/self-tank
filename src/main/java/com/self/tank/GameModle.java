package com.self.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @Author: ZST
 * @Date: 2020/8/2
 */
public class GameModle {

    Tank myTank = new Tank(400, 500, Dir.UP, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enemyTanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();


    public GameModle() {
        int count = Integer.valueOf((String) Objects.requireNonNull(PropertyMgr.getValue("enemy.tank.count")));
        for (int i = 0; i < count; i++) {
            enemyTanks.add(new Tank(200 + i * 100, 200, Dir.DOWN, Group.BAD, this));
        }
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + enemyTanks.size(), 10, 80);
        g.drawString("炸弹的数量:" + enemyTanks.size(), 10, 100);
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
    public Tank getMainTank() {
        return myTank;
    }




    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public List<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(List<Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public List<Explode> getExplodes() {
        return explodes;
    }

    public void setExplodes(List<Explode> explodes) {
        this.explodes = explodes;
    }
}
