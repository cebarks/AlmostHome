package net.cebarks.ahome.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.cebarks.ahome.AlmostHome;

public class ImageHelper {
	public static BufferedImage loadImage(String image) {
		BufferedImage bi = null;
		
		try {
			bi = ImageIO.read(AlmostHome.class.getResource(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bi;
	}
}
