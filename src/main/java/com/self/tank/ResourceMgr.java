package com.self.tank;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {

	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
//	public static BufferedImage badTankL, badTankU, badTankR, badTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
//	public static BufferedImage[] explodes = new BufferedImage[16];


	static {
		try {

			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			goodTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			goodTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			goodTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

//			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
//			badTankL = ImageUtil.rotateImage(badTankU, -90);
//			badTankR = ImageUtil.rotateImage(badTankU, 90);
//			badTankD = ImageUtil.rotateImage(badTankU, 180);
//
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
//			bulletL = ImageUtil.rotateImage(bulletU, -90);
//			bulletR = ImageUtil.rotateImage(bulletU, 90);
//			bulletD = ImageUtil.rotateImage(bulletU, 180);
//
//			for(int i=0; i<16; i++)
//				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
