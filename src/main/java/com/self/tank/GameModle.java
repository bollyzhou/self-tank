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

    Tank myTank;
    private List<GameObject> gameObjects = new ArrayList<>();
    private ColliderChain colliderChain = new ColliderChain();
    private static final GameModle INSTANCE = new GameModle();


    static {
        INSTANCE.init();
    }


    private GameModle() {}

    public static GameModle getInstance() {
        return INSTANCE;
    }

    private void init() {
        myTank = new Tank(400, 500, Dir.UP, Group.GOOD);
        int count = Integer.valueOf((String) Objects.requireNonNull(PropertyMgr.getValue("enemy.tank.count")));
        for (int i = 0; i < count; i++) {
            gameObjects.add(new Tank(200 + i * 100, 200, Dir.DOWN, Group.BAD));
        }
        // 初始化墙
        addGameObject(new Wall(150, 150, 200, 50));
        addGameObject(new Wall(550, 150, 200, 50));
        addGameObject(new Wall(300, 300, 50, 200));
        addGameObject(new Wall(550, 300, 50, 200));
        colliderChain.add(new TankWallCollider());
        colliderChain.add(new BulletWallCollider());
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量:" + enemyTanks.size(), 10, 80);
//        g.drawString("炸弹的数量:" + enemyTanks.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                colliderChain.collide(gameObjects.get(i), gameObjects.get(j));
            }
        }
    }
    public Tank getMainTank() {
        return myTank;
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

}
