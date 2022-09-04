package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import helper.MatchHistoryHelper;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import objects.MatchObject;
import start.App;

public class MatchHistoryController {
	
	@FXML AnchorPane matchListContainer;
	List<MatchObject> overviewList = new ArrayList<MatchObject>();
	List<MatchHistoryHelper> matchHistoryList = new ArrayList<MatchHistoryHelper>();
	
	List<CheckBox> checkList = new ArrayList<CheckBox>();
	
	@FXML CheckBox bankCheckBox;
	@FXML CheckBox borderCheckBox;
	@FXML CheckBox chaletCheckBox;
	@FXML CheckBox clubhouseCheckBox;
	@FXML CheckBox coastlineCheckBox;
	@FXML CheckBox consulateCheckBox;
	@FXML CheckBox emeraldPlainsCheckBox;
	@FXML CheckBox favelaCheckBox;
	@FXML CheckBox kafeCheckBox;
	@FXML CheckBox kanalCheckBox;
	@FXML CheckBox oregonCheckBox;
	@FXML CheckBox outbackCheckBox;
	@FXML CheckBox skyscraperCheckBox;
	@FXML CheckBox themeParkCheckBox;
	@FXML CheckBox villaCheckBox;
	
	@FXML CheckBox selectAllCheckBox;
	@FXML CheckBox deselectAllCheckBox;

	@FXML
	private void switchToMainMenu() throws IOException
	{
		App.setRoot("mainMenu");
	}
	
	@FXML
	public void initialize() {
		
		initCheckBoxList();
		
		overviewList = App.matchH.matchList;
		
		for(int i = overviewList.size() - 1; i >= 0; i--) {
			matchHistoryList.add(new MatchHistoryHelper(overviewList.get(i), overviewList.size() - 1 - i));
		}
		
		matchListContainer.setPrefHeight(matchHistoryList.size() * 120);
		matchListContainer.getChildren().addAll(matchHistoryList);
	}
	
	@FXML
	public void filterBy() {
		int pos = 0;
		matchHistoryList.clear();
		matchListContainer.getChildren().clear();
		for(int i = overviewList.size() - 1; i >= 0; i--) {
			for (int j = 0; j < checkList.size(); j++) {
				if(checkList.get(j).isSelected() == true) {
					if(j == overviewList.get(i).getMapPick().getMapID()) {
						matchHistoryList.add(new MatchHistoryHelper(overviewList.get(i), pos));
						pos++;
					}
				}
			}
		}
		matchListContainer.getChildren().addAll(matchHistoryList);
	}
	
	private void initCheckBoxList() {
		checkList.add(bankCheckBox);
		checkList.add(borderCheckBox);
		checkList.add(chaletCheckBox);
		checkList.add(clubhouseCheckBox);
		checkList.add(coastlineCheckBox);
		checkList.add(consulateCheckBox);
		checkList.add(emeraldPlainsCheckBox);
		checkList.add(favelaCheckBox);
		checkList.add(kafeCheckBox);
		checkList.add(kanalCheckBox);
		checkList.add(oregonCheckBox);
		checkList.add(outbackCheckBox);
		checkList.add(skyscraperCheckBox);
		checkList.add(themeParkCheckBox);
		checkList.add(villaCheckBox);
	}
	
	public void all() {
		for (CheckBox box : checkList) {
			box.setSelected(true);
		}
		filterBy();
		deselectAllCheckBox.setSelected(false);
	}
	public void none() {
		for (CheckBox box : checkList) {
			box.setSelected(false);
		}
		filterBy();
		selectAllCheckBox.setSelected(false);
	}
}
