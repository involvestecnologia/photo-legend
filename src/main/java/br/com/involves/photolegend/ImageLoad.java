package br.com.involves.photolegend;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import br.com.involves.photolegend.exception.PhotoLegendException;

public interface ImageLoad {

	void reader(byte[] imageInit) throws PhotoLegendException;

	BufferedImage getImage();

	int getHeight();
    
	int getWidth();
	
	Graphics2D createGraphics();

	void reader(InputStream imageInit) throws PhotoLegendException;
		
}
