package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/8/3
 */
public class BulletTankCollide implements Collide {

    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Bullet && gameObject2 instanceof Tank) {
            Bullet b = (Bullet)gameObject1;
            Tank t = (Tank)gameObject2;
            return !b.collideWith(t);

        } else if (gameObject1 instanceof Tank && gameObject2 instanceof Bullet) {
            return collide(gameObject2, gameObject1);
        }

        return true;
    }
}
