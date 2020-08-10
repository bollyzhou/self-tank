package com.self.tank;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZST
 * @Date: 2020/8/10
 */
public class CollideChain {

    List<Collide> collides = new ArrayList<>();
    public CollideChain() {
        add(new BulletTankCollide());
        add(new TankTankCollide());
    }

    public void add(Collide collide){
        collides.add(collide);
    }

    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        for (Collide collide : collides) {
            collide.collide(gameObject1, gameObject2);
            return true;
        }
        return false;
    }
}
