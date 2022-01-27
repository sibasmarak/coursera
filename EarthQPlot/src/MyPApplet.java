import processing.core.*;
public class MyPApplet extends PApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String URL = "https://image.shutterstock.com/image-photo/la-jolla-beach-sunset-san-600w-416488936.jpg";
	private PImage backgrdImg;
	public void setup()
	{
		size(400, 400);
//		/stroke(0);
		backgrdImg = loadImage(URL, "jpg");
	}
	public void draw()
	{
		backgrdImg.resize(0, height);
		image(backgrdImg, 0, 0);
		System.out.println(second());
		int arr[] = sunSec(second());
		fill(arr[0],arr[1],arr[2]);
		ellipse(5*width/6, height/5, width/5, height/5);
	}
	private int[] sunSec(int second) {
		int rgb[] = new int[3];
		int diff = Math.abs(30-second);
		double ratio = (double)diff/30.0;
		rgb[0] = rgb[1] = (int)(ratio*255);
		rgb[2] = 0;
		System.out.println(diff + " " + ratio + " " + rgb[0] + " " + rgb[1] + " " + rgb[2]);
		return rgb;
	}

}
