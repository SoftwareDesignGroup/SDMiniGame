import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MazeImage extends Component {
	private ImageIcon img;
	private Image image;
	private Image images[];
	private BufferedImage bImage;
	
	public MazeImage()
	{
		editImage();
	}
	
	public void editImage()
	{
		try
		{
			bImage = loadImage();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		bImage = resizeImage(bImage);
		images = new Image[16];
		int index = 0;
		for (int i = 0; i < 4; i++) 
		{
            for (int j = 0; j < 4; j++) 
            {
                image = createImage(new FilteredImageSource(bImage.getSource(),
                        new CropImageFilter(j * bImage.getWidth() / 4, i * bImage.getHeight() / 4,
                                (bImage.getWidth() / 4), bImage.getHeight() / 4)));
                images[index] = image;
                index++;
            }
		}
	}
	
	private BufferedImage resizeImage(BufferedImage original) 
	{
        BufferedImage resized = new BufferedImage(320, 320, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(original, 0, 0, 320, 320, null);
        g.dispose();
        return resized;
	}
	
	private BufferedImage loadImage() throws IOException 
	{
        BufferedImage bimage = ImageIO.read(new File("C:\\Users\\Phillip\\Downloads\\pic3.jpg"));
        return bimage;
    }
	
	public ImageIcon getImage(int i)
	{
		img = new ImageIcon(images[i]);
		return img;
	}
}
