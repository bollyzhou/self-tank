package com.self.tank;

import java.awt.*;
import java.util.Iterator;

public class Bullet {
	private static final int SPEED = 5;
	public static int WIDTH = ResourceMgr.bulletU.getWidth(), HEIGHT = ResourceMgr.bulletU.getHeight();
	
	private int x, y;
	private Dir dir;
	boolean living = true;
	private GameModle gm = null;
	private Group group;

	Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, GameModle gm) {
		this.x = x;
		this.y = y;
		this.group = group;
		this.gm = gm;
		this.dir = dir;

		rectangle.x = this.x;
		rectangle.y = this.y;
		rectangle.width = WIDTH;
		rectangle.height = HEIGHT;
		gm.bullets.add(this);
	}
	
	public void paint(Graphics g) {
	    if (!living) {
            saveRemove();
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

    private void saveRemove() {
        gm.bullets.removeIf(this::equals);
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
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
	}

    public void collideWith(Tank tank) {
        if (this.group.equals(tank.getGroup())) {
            return;
        }
        // 每次碰撞都要创建，将retangle 放到创建坦克和子弹到地方，当子弹销毁的时候 rectangle 即销毁
//        Rectangle br = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//        Rectangle tr = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (tank.getRectangle().intersects(rectangle)) {
            this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gm.explodes.add(new Explode(eX, eY, gm));
        }
    }

    private void die() {
        this.living = false;
    }
}