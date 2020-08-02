package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/8/2
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX, bY, Dir.DOWN, tank.getGroup(), tank.getGm());
        new Bullet(bX, bY, Dir.UP, tank.getGroup(), tank.getGm());
        new Bullet(bX, bY, Dir.LEFT, tank.getGroup(), tank.getGm());
        new Bullet(bX, bY, Dir.RIGHT, tank.getGroup(), tank.getGm());

        if (tank.getGroup().equals(Group.GOOD)) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
