package br.com.involves.photolegend;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import br.com.involves.photolegend.exception.PhotoLegendException;

/**
 * 
 * @author marcelo
 *
 */
public class ImageLoadImpl implements ImageLoad {

	private BufferedImage image;
	
	public ImageLoadImpl(InputStream imageInit) throws PhotoLegendException {
		reader(imageInit);
		validateIntegrity();
	}

	public ImageLoadImpl(byte[] imageInit) throws PhotoLegendException {
		reader(imageInit);
		validateIntegrity();
	}

	/**
	 * 
	 * Valida a integridade da imagem, se ela foi lida corretamente.<br>
	 * Se o {@link BufferedImage} for nulo � porque o objeto recebido n�o era um formato v�lido para imagem.
	 * 
	 * @throws PhotoLegendException
	 */
	private void validateIntegrity() throws PhotoLegendException {

		if( image == null ){
			throw new PhotoLegendException("Formato inválido.");
		}
		
	}

	/**
	 * Valida se o objeto � null.
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
	public void reader(byte[] imageInit) throws PhotoLegendException{
		
		valid(imageInit);
		
		try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageInit)){
			image = ImageIO.read(byteArrayInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new PhotoLegendException("Não foi possível ler a imagem.");
		}
	}
	
	@Override
	public void reader(InputStream imageInit) throws PhotoLegendException{
		
		valid(imageInit);
		
		try {
			image = ImageIO.read(imageInit);
		} catch (IOException e) {
			throw new PhotoLegendException("Não foi possível ler a imagem.");
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
	public BufferedImage getImage(){
		return image;
	}
	
}
