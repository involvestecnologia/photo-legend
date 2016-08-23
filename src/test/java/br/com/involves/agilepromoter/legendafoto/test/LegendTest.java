package br.com.involves.agilepromoter.legendafoto.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.agilepromoter.photolegend.PhotoLegend;
import br.com.involves.agilepromoter.photolegend.exception.PhotoLegendException;

/**
 * 
 * @author marcelo
 *
 */
public class LegendTest {

	@Test
	public void createLegend(){
		String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
		File fileTest = new File(imagemTest);

		try(InputStream is = new FileInputStream(fileTest)){
			PhotoLegend.getInstance().addLegend("Texto", is);
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@Test
	public void createLegendByte(){
		try{
			
			String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
			Path path = Paths.get(imagemTest);
			byte[] byteIn = Files.readAllBytes(path);
			
			PhotoLegend.getInstance().addLegend("Texto", byteIn);
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void createLegendWithReturn(){
		String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
		File fileTest = new File(imagemTest);

		try{
			InputStream is = new FileInputStream(fileTest);
			byte[] out = null;
			out = PhotoLegend.getInstance().addLegend("Texto", is);
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}

	@Test
	public void createLegendWithReturnAndSave(){
		try{
			String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
			File fileTest = new File(imagemTest);
			
			InputStream is = new FileInputStream(fileTest);
			byte[] out = PhotoLegend.getInstance().addLegend("Texto", is);
			
			File gravar = new File("/tmp/testImageLegend.jpg");
			Files.write(gravar.toPath(), out);

			System.out.println("Arquivo gerado: "+gravar.toPath());
			
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@Test
	public void createLegendImageNull() {
		
		InputStream is = null;
		try {
			PhotoLegend.getInstance().addLegend("Texto", is);
			Assert.fail();
		} catch (PhotoLegendException e) {
			Assert.assertEquals(e.getMessage(), "Imagem não pode ser nula.");
		}
		
	}

	@Test
	public void createLegendLabelNull() throws FileNotFoundException {
		
		String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
		File fileTest = new File(imagemTest);
		
		InputStream is = new FileInputStream(fileTest);
		
		try {
			PhotoLegend.getInstance().addLegend(null, is);
			Assert.fail();
		} catch (PhotoLegendException e) {
			Assert.assertEquals(e.getMessage(), "Label não pode ser nulo.");
		}
		
	}
	
	@Test
	public void createLegendWithReturnAndSaveAndLabelLarg(){
		try{
			String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test.jpg").getPath();
			File fileTest = new File(imagemTest);
			
			InputStream is = new FileInputStream(fileTest);
			byte[] out = PhotoLegend.getInstance().addLegend("Texto sdkjf hsdkljfh sldjkh fjksd hlkjf hlsjkdh flshdjkfh jksd hfsdjkfdf dsh fsd fjk dsf jlsd", is);
			
			File gravar = new File("/tmp/testImageLegendLarg.jpg");
			Files.write(gravar.toPath(), out);

			System.out.println("Arquivo gerado: "+gravar.toPath());
			
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@Test
	public void createLegendWithReturnAndSavePng(){
		try{
			String imagemTest = LegendTest.class.getClassLoader().getResource("images//imagem-test-png.png").getPath();
			File fileTest = new File(imagemTest);
			
			InputStream is = new FileInputStream(fileTest);
			byte[] out = PhotoLegend.getInstance().addLegend("Texto", is);
			
			File gravar = new File("/tmp/testImageLegendPng.jpg");
			Files.write(gravar.toPath(), out);

			System.out.println("Arquivo gerado: "+gravar.toPath());
			
			Assert.assertTrue(true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@Test
	public void createLegendWithReturnAndSaveTxt(){
		try{
			String imagemTest = LegendTest.class.getClassLoader().getResource("images//texto-test.txt").getPath();
			File fileTest = new File(imagemTest);
			
			InputStream is = new FileInputStream(fileTest);
			byte[] out = PhotoLegend.getInstance().addLegend("Texto", is);
			
			File gravar = new File("/tmp/testImageLegendTxt.jpg");
			Files.write(gravar.toPath(), out);

			System.out.println("Arquivo gerado: "+gravar.toPath());
			Assert.fail();
		} catch (PhotoLegendException e) {
			e.printStackTrace();
			Assert.assertEquals(e.getMessage(), "Formato inválido.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}