package demos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;
public class LifeExpectancyDemo extends PApplet{
	private UnfoldingMap map;
	private Map<String, Float> lifeExpByCountry;
	private List<Feature> countries;
	private List<Marker> countryMarkers;
	public void setup() {
		size(950,600,OPENGL);
		map = new UnfoldingMap(this, 50, 50, 650, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");//bunch of data i.e. list of countries
		countryMarkers = MapUtils.createSimpleMarkers(countries);//marker for each of the country
		map.addMarkers(countryMarkers);
		shadeCountries();
	}
	
	private void shadeCountries() {
		for (Marker marker : countryMarkers) {
			String countryID = marker.getId();
			if(lifeExpByCountry.containsKey(countryID))
			{
				float lifeExp = lifeExpByCountry.get(countryID);
				int colorLevel = (int)map(lifeExp, 40 , 90,10,255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else
				marker.setColor(color(150,150,150));
		}
	}

	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExp = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);
		for (String row : rows) {
			String[] columns = row.split(",");
			if(columns.length == 6 && !columns[5].equals(".."))
			{
				float lifeExpVal = Float.parseFloat(columns[5]);
				lifeExp.put(columns[4], lifeExpVal);
			}
		}
		return lifeExp;
	}
	public void draw() {
		map.draw();
	}
	

}
