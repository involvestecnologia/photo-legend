package br.com.involves.photolegend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.involves.photolegend.exception.PhotoLegendException;

/**
 * 
 * @author marcelo
 *
 */
public class ImageLoadImpl implements ImageLoad {

	static Logger LOGGER = LoggerFactory.getLogger(ImageLoadImpl.class);
	
	private BufferedImage image;
	
	public ImageLoadImpl(InputStream imageInit) throws PhotoLegendException {
		reader(imageInit);
	}

	public ImageLoadImpl(byte[] imageInit) throws PhotoLegendException {
		reader(imageInit);
	}

	/**
	 * 
	 * Valida a integridade da imagem, se ela foi lida corretamente.<br>
	 * Se o {@link BufferedImage} for nulo é porque o objeto recebido não era um formato válido para imagem.
	 * 
	 * @throws PhotoLegendException
	 */
	private void validateIntegrity() throws PhotoLegendException {

		if( image == null ){
			throw new PhotoLegendException("Formato inválido.");
		}
		
	}

	/**
	 * Valida se o objeto é null.
	 * 
	 * @param imageInit
	 * @throws PhotoLegendException
	 */
	private void valid(Object imageInit) throws PhotoLegendException {
		
		if( imageInit == null ){
			throw new PhotoLegendException("Imagem não pode ser nula.");
		}
		
	}

	@Override
	public void reader(byte[] imageInit) throws PhotoLegendException {
		
		valid(imageInit);
		
		try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageInit)){
			
			image 							= ImageIO.read(byteArrayInputStream);
			
			validateIntegrity();
			
			BufferedImage imageFormatRgb 	= new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_INT_RGB);
			imageFormatRgb.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
			image                           = imageFormatRgb;  
			
		} catch (IOException e) {
			throw new PhotoLegendException("Não foi possí­vel ler a imagem.", e);
		}
	}
	
	@Override
	public void reader(InputStream imageInit) throws PhotoLegendException {
		
		valid(imageInit);
		
		try {
			
			image 							= ImageIO.read(imageInit);
			
			validateIntegrity();
			
			BufferedImage imageFormatRgb 	= new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_INT_RGB);
			imageFormatRgb.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
			image                           = imageFormatRgb;
			
		} catch (IOException e) {
			throw new PhotoLegendException("Não foi possí­vel ler a imagem.", e);
		}
	}

	@Override
	public Graphics2D createGraphics() {
		return image.createGraphics();
	}

	@Override
	public int getHeight() {
		return image.getHeight();
	}
	
	@Override
	public int getWidth() {
		return image.getWidth();
	}
	
	@Override
	public BufferedImage getImage(){
		return image;
	}
	
}
