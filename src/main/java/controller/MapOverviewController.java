package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import objects.MapObject;
import start.App;

public class MapOverviewController {
	
	List<MapObject> overviewList;
	List<ImageView> showMapList = new ArrayList<ImageView>();
	@FXML ImageView showMap0;
	@FXML ImageView showMap1;
	@FXML ImageView showMap2;
	@FXML ImageView showMap3;
	@FXML ImageView showMap4;
	@FXML ImageView showMap5;
	@FXML ImageView showMap6;
	@FXML ImageView showMap7;
	@FXML ImageView showMap8;
	@FXML ImageView showMap9;
	@FXML ImageView showMap10;
	@FXML ImageView showMap11;
	@FXML ImageView showMap12;
	@FXML ImageView showMap13;
	@FXML ImageView showMap14;
	
	ImageView lastClickedMap;
	
	@FXML CheckBox sortWinrate;
	@FXML CheckBox sortBanrate;
	@FXML CheckBox sortAppearance;
	
	@FXML Text mapTitle;
	@FXML ProgressIndicator relativeWinrate;
	@FXML ProgressIndicator relativeBanrate;
	@FXML ProgressIndicator relativeAppearancerate;
	@FXML ProgressIndicator relativeAttackWinrate;
	@FXML ProgressIndicator relativeDefenseWinrate;
	
	@FXML Text totalWin;
	@FXML Text totalBan;
	@FXML Text totalAppearance;
	@FXML Text totalAttackWin;
	@FXML Text totalDefenseWin;
	
	@FXML
	private void switchToMainMenu() throws IOException{
		App.setRoot("mainMenu");
	}
	
	public void initialize() {
		showMapList.add(showMap0);
		showMapList.add(showMap1);
		showMapList.add(showMap2);
		showMapList.add(showMap3);
		showMapList.add(showMap4);
		showMapList.add(showMap5);
		showMapList.add(showMap6);
		showMapList.add(showMap7);
		showMapList.add(showMap8);
		showMapList.add(showMap9);
		showMapList.add(showMap10);
		showMapList.add(showMap11);
		showMapList.add(showMap12);
		showMapList.add(showMap13);
		showMapList.add(showMap14);
		overviewList = App.mapH.mapList;
		
		for(int i = 0; i< showMapList.size(); i++) {
			final int index = i;
			this.showMapList.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					if(lastClickedMap != null) {
						lastClickedMap.setEffect(null);
					}
					setMapStats(overviewList.get(index));
					lastClickedMap = showMapList.get(index);
					showMapList.get(index).setEffect(new DropShadow(20, Color.BLACK));
				}
			});
			showMapList.get(index).setImage(new Image("file:" + overviewList.get(index).getImagePath()));
		}
		MapObject.setSortColumn(3);
		overviewList.sort(Comparator.naturalOrder());
		System.out.println("Map overview initialized");
	}
	
	@FXML
	private void sortWinrateChecked() {
		sortBanrate.setSelected(false);
		sortAppearance.setSelected(false);
		
		MapObject.setSortColumn(0);
		
		overviewList.sort(Comparator.reverseOrder());		
		refresh();
	}
	
	@FXML
	private void sortBanrateChecked() {
		sortWinrate.setSelected(false);
		sortAppearance.setSelected(false);
		
		MapObject.setSortColumn(1);
		
		overviewList.sort(Comparator.reverseOrder());
		refresh();
	}
	
	@FXML
	private void sortAppearancerateChecked() {
		sortBanrate.setSelected(false);
		sortWinrate.setSelected(false);
		
		MapObject.setSortColumn(2);
		
		overviewList.sort(Comparator.reverseOrder());
		refresh();
	}
	
	private void refresh() {
		for(int i = 0; i < overviewList.size(); i++)
		{
			showMapList.get(i).setImage(new Image("file:" + overviewList.get(i).getImagePath()));
		}
		if(lastClickedMap != null) {
			lastClickedMap.setEffect(null);
		}
	}
	
	private void setMapStats(MapObject clickedMap) {
		
		mapTitle.setText(clickedMap.getName());
		relativeWinrate.setProgress(clickedMap.getWinrate());
		relativeBanrate.setProgress(clickedMap.getBanrate());
		relativeAppearancerate.setProgress(clickedMap.getAppearancerate());
		relativeAttackWinrate.setProgress(clickedMap.getAttackWinrate());
		relativeDefenseWinrate.setProgress(clickedMap.getDefenseWinrate());
		totalWin.setText(String.valueOf(clickedMap.getWin()));
		totalBan.setText(String.valueOf(clickedMap.getAppearance() - clickedMap.getPick()));
		totalAppearance.setText(String.valueOf(clickedMap.getAppearance()));
		totalAttackWin.setText(String.valueOf(clickedMap.getAttackWin()));
		totalDefenseWin.setText(String.valueOf(clickedMap.getDefenseWin()));
	}
}
