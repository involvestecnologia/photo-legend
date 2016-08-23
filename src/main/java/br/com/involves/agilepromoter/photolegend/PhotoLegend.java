package br.com.involves.agilepromoter.photolegend;

import java.io.InputStream;

import br.com.involves.agilepromoter.photolegend.exception.PhotoLegendException;

public class PhotoLegend {

	private static final PhotoLegend PHOTO_LEGEND = new PhotoLegend();
	
	public static PhotoLegend getInstance() {
		return PHOTO_LEGEND;
	}

	public byte[] addLegend(String label, InputStream imageInit) throws PhotoLegendException {
		ImageLoad imageLoad = new ImageLoadImpl(imageInit);
		return addLegend(label, imageLoad);
	}

	public byte[] addLegend(String label, byte[] byteIn) throws PhotoLegendException {
		ImageLoad imageLoad = new ImageLoadImpl(byteIn);
		return addLegend(label, imageLoad);
	}

	public byte[] addLegend(String label, ImageLoad imageLoad) throws PhotoLegendException {
		return writeToImage(imageLoad, label);
	}
	
	private byte[] writeToImage(ImageLoad imageLoad, String label) throws PhotoLegendException {
		WriteToImage writeToImage = new WriteToImage(imageLoad, label);
		
		return writeToImage.getByte();
	}

}
