package com.self.tank;

import java.awt.*;

public class Bullet {
	private static final int SPEED = 5;
	public static int WIDTH = ResourceMgr.bulletU.getWidth(), HEIGHT = ResourceMgr.bulletU.getHeight();
	
	private int x, y;
	private Dir dir;
	boolean living = true;
	private TankFram tankFram = null;
	private Group group;

    public Bullet(int x, int y, Dir dir, Group group, TankFram tankFram) {
		this.x = x;
		this.y = y;
		this.group = group;
		this.tankFram = tankFram;
		this.dir = dir;
	}
	
	public void paint(Graphics g) {
	    if (!living) {
            tankFram.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
		
		move();
	}
	
	private void move() {
		
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
			default:break;
		}
		if (x < 0 || y < 0 || x > TankFram.GAME_WIDTH || y > TankFram.GAME_HEIGHT ) {
            living = false;
        }
	}

    public void collideWith(Tank tank) {
        if (this.group.equals(tank.getGroup())) {
            return;
        }
        Rectangle br = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle tr = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (br.intersects(tr)) {
            this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tankFram.explodes.add(new Explode(eX, eY, tankFram));
        }
    }

    private void die() {
        this.living = false;
    }
}