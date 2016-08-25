package br.com.involves.photolegend;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public interface ImageLoad {

	void reader(byte[] imageInit) throws Exception;

	BufferedImage getImage();

	int getHeight();

	Graphics2D createGraphics();

	void reader(InputStream imageInit) throws Exception;
	
	
	
}
