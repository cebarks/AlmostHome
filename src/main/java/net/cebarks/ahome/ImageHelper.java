package net.cebarks.ahome;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
