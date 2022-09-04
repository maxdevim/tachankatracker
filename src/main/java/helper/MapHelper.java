package helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import objects.MapObject;

@XmlRootElement(name = "mapHelper")
public class MapHelper {
	public List<MapObject> mapList = new ArrayList<MapObject>();
	public static int appearanceCount;
	public static int tachankaCount;
	public static int highlightsCount;

	public void intializeHelper(){
		
		appearanceCount = 0;
		tachankaCount = 0;
		highlightsCount = 0;
		
		for (MapObject map : mapList) {
			appearanceCount += map.getAppearance();
			tachankaCount += map.getTachankaCount();
			highlightsCount += map.getHighlightCount();
		}
		
		for (MapObject map : mapList) {
			map.initializeMap();
		}
	}
	
	public MapObject getBestMap(){
		
		MapObject tempBestMap = mapList.get(0);
		
		for (MapObject map : mapList) {
			
			if(map.getWinrate() > tempBestMap.getWinrate()){
				tempBestMap = map;
			}
		}
		
		return tempBestMap;
	}
	
	
	// TODO: delete when not needed anymore
	public void show()
	{
		System.out.print(this + " :");
		for (MapObject map : mapList) {
			System.out.print(" (" + map.toString() +")");
		}
		System.out.println();
	}
}
