package utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class CropImage {

	
	
		static  File imageFile = new File("C:\\Users\\debasishdey\\Documents\\ProjectFrameworks\\UI_Automation_Suite\\screenshots\\screen.png");
		static  File destFile = new File("C:\\Users\\debasishdey\\Documents\\ProjectFrameworks\\UI_Automation_Suite\\screenshots\\image-crop.png");
		static  File finaldestFile = new File("C:\\Users\\debasishdey\\Documents\\ProjectFrameworks\\UI_Automation_Suite\\screenshots\\new-image-crop.png");

		   

		    public static void resize(File imageFile, File destFile,
		                                   int width, int height) throws IOException {

		        BufferedImage originalImage = ImageIO.read(imageFile);

		        /**
		         * SCALE_AREA_AVERAGING
		         * SCALE_DEFAULT
		         * SCALE_FAST
		         * SCALE_REPLICATE
		         * SCALE_SMOOTH
		         */
		        Image newResizedImage = originalImage
		              .getScaledInstance(width, height, Image.SCALE_SMOOTH);

		        String s = destFile.getName().toString();
		        String fileExtension = s.substring(s.lastIndexOf(".") + 1);

		        // we want image in png format
		        ImageIO.write(convertToBufferedImage(newResizedImage),
		                fileExtension, destFile);

		    }

		    public static BufferedImage convertToBufferedImage(Image img) {

		        if (img instanceof BufferedImage) {
		            return (BufferedImage) img;
		        }

		        // Create a buffered image with transparency
		        BufferedImage bi = new BufferedImage(
		                img.getWidth(null), img.getHeight(null),
		                BufferedImage.TYPE_INT_ARGB);

		        Graphics2D graphics2D = bi.createGraphics();
		        graphics2D.drawImage(img, 0, 0, null);
		        graphics2D.dispose();

		        return bi;
		    }
		    
		    public static void crop(File imgFilepath, File destFilepath) {
				  BufferedImage bufferedImage =null;
				  try
				      {
				      bufferedImage = ImageIO.read(imgFilepath);
				      BufferedImage image=bufferedImage.getSubimage(10,116,bufferedImage.getWidth()-20,bufferedImage.getHeight()-116);
			          ImageIO.write(image,"png", destFilepath);
			    }
			  catch (IOException e) 
			      {
			          System.out.println(e);
			      }    
			  }

		    
}
