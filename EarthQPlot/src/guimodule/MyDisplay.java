package guimodule;
import processing.core.*;
public class MyDisplay extends PApplet{
	public void setup()
	{
		size(400, 400);
		background(200,200,200);
	}
	//draw() works everytime gui runs
	public void draw() {
		fill(255,255,0);
		ellipse(200,200,390,390);
		fill(255,255,255);
		ellipse(120, 130, 50, 70);
		fill(255,255,255);
		ellipse(280, 130, 50, 70);
		arc(200, 300, 75, 75, 0, PI);
	}

}
