package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/8/10
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Tank && gameObject2 instanceof Tank)  {
            Tank t1 = (Tank) gameObject1;
            Tank t2 = (Tank) gameObject2;
            if (t1.getRectangle().intersects(t2.rectangle)) {
                t1.setX(t1.getX() - 2);
                t1.setY(t1.getY() - 2);
                t2.setX(t1.getX() - 2);
                t2.setY(t1.getY() - 2);
            }
        }
        return false;
    }
}
