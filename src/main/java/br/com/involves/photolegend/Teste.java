package br.com.involves.photolegend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

public class Teste {

	public File addThumbnail(File imagemOriginal, String label,
			String imagemDestino) throws IOException {
		
		try {
			assert imagemOriginal != null : "Imagem original deve ser fornecida";
			assert (imagemDestino != null && !imagemDestino.isEmpty()) : "Caminho da imagem destino deve ser fornecida";

			BufferedImage image = ImageIO.read(imagemOriginal);
			
			BufferedImage imageFormatRgb = new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_INT_RGB);
			imageFormatRgb.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
			  

			/*BufferedImage thumbnail = Thumbnails.of(image)
					.size(image.getWidth(), image.getHeight())
					.asBufferedImage();*/

			Graphics2D gO = imageFormatRgb.createGraphics();
			gO.setFont(new Font( "SansSerif", Font.BOLD, 20 ));
			gO.setColor(Color.YELLOW);
			gO.drawString(label, 20, imageFormatRgb.getHeight() - 20);
		    
			
			File file = new File(imagemDestino);
			ImageIO.write(imageFormatRgb, "JPG", file);
			return file;
		} catch (IOException e) {
			System.out
					.println("Ocorreu um erro ao tentar aplicar marca dagua na imagem "
							+ imagemDestino);
			throw e;
		}
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException {
		
		Teste t = new Teste();
		
		t.addThumbnail(
				new File("/home/wesleyramos/Downloads/caixa.gif"), 
				"carimbo foto",
				"/home/wesleyramos/Downloads/gif_teste.jpg");

		//http://www.matera.com/br/2015/03/04/marca-dagua-com-java-e-thumbnailator/
		//http://www.guj.com.br/t/escrevendo-texto-em-imagens/226341/14
		//http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/DrawtextwithTextLayout.htm
		
		System.out.println("DONE!");
	}

}
