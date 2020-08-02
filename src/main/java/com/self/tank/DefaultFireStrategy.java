package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/8/2
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getGm());

        if (tank.getGroup().equals(Group.GOOD)) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
