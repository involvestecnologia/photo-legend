package br.com.involves.agilepromoter.photolegend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.com.involves.agilepromoter.photolegend.exception.PhotoLegendException;
import org.apache.commons.lang.StringUtils;


public class WriteToImage {

	private static final Color COLOR = Color.YELLOW;
	private static final int SIZE = 20;
	private static final String FONT_NAME = "SansSerif";
	private static final Font FONT = new Font( FONT_NAME, Font.BOLD, SIZE );
	
	private ImageLoad imageLoad;
	private String label;
	private Graphics2D graphics2d;

	public WriteToImage(ImageLoad imageLoad, String label) throws PhotoLegendException {
		this.imageLoad = imageLoad;
		this.label = label;
		writeToImage();
	}

	private void writeToImage() throws PhotoLegendException {

		valid();
		
		graphics2d = imageLoad.createGraphics();
		graphics2d.setFont(FONT);
		graphics2d.setColor(COLOR);
		graphics2d.drawString(label, getPosX(), getY());
		
	}

	private void valid() throws PhotoLegendException {
		if( StringUtils.isEmpty(label) ){
			throw new PhotoLegendException("Label não pode ser nulo.");
		}
	}

	private int getY(){
		return imageLoad.getHeight() - VALUE_POS_DEFAULT();
	}

	private int VALUE_POS_DEFAULT() {
		return 20;
	}

	private int getPosX() {
		return 20;
	}


	public byte[] getByte() throws PhotoLegendException {
		
		try(ByteArrayOutputStream byteReturn = new ByteArrayOutputStream()){
			ImageIO.write(imageLoad.getImage(), "JPG", byteReturn);
			return byteReturn.toByteArray();
		} catch (IOException e) {
			throw new PhotoLegendException("Não foi possível escrever na imagem.");
		}
		
	}

}
