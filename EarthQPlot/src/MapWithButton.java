import javax.management.loading.PrivateClassLoader;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;
public class MapWithButton extends PApplet
{
	private UnfoldingMap map;
	public void setup() {
		size(800,600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.AerialProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	public void draw() {
		map.draw();
		createButtons();
	}
	private void createButtons() {
		// TODO Auto-generated method stub
		fill(255,255,255);
		rect(150, 100, 25, 25);
		
		fill(150,150,150);
		rect(150,150,25,25);
	}
	@Override
	public void mouseReleased() {
		if(mouseX > 150 && mouseX < 175 && mouseY > 100 && mouseY < 125)
			background(255,255,255);
		else if(mouseX > 150 && mouseX < 175 && mouseY > 150 && mouseY < 175)
			background(150,150,150);
		super.mouseReleased();
	
	}
	public void keyPressed() {
		if(key == 'w')
			background(0,0,0);
	}
}
