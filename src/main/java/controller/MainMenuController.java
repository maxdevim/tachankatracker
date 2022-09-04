package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import helper.MapHelper;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import start.App;

public class MainMenuController {
	
	
	@FXML Text bestMapName;
	@FXML ImageView bestMapImage;
	@FXML ProgressIndicator bestMapWinrate;
	@FXML ProgressIndicator bestMapDefenseWinrate;
	@FXML ProgressIndicator bestMapAttackWinrate;
	@FXML Text highlights;
	@FXML Text tachankas;
	
	@FXML
	private void switchToAddMatch() throws IOException
	{
		App.setRoot("addMatch");
	}
	
	@FXML
	private void switchToMapOverview() throws IOException
	{
		App.setRoot("mapOverview");
	}
	
	@FXML
	private void SwitchToMatchHistory() throws IOException
	{
		App.setRoot("matchHistory");
	}
	
	public void initialize() throws FileNotFoundException, JAXBException
	{
		App.refreshData();
		bestMapName.setText(App.bestMap.getName());
		bestMapImage.setImage(new Image("file:" + App.bestMap.getImagePath()));
		bestMapWinrate.setProgress(App.bestMap.getWinrate());
		bestMapDefenseWinrate.setProgress(App.bestMap.getDefenseWinrate());
		bestMapAttackWinrate.setProgress(App.bestMap.getAttackWinrate());
		highlights.setText("Highlights: " + String.valueOf(MapHelper.highlightsCount));
		tachankas.setText("Tachankas spotted: " + String.valueOf(MapHelper.tachankaCount));
		
		System.out.println("Main menu initialized");
	}
}
