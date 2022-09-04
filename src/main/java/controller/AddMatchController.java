package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import objects.MapObject;
import objects.MatchObject;
import start.App;

public class AddMatchController {

	@FXML Button addMatchButton;
	@FXML Text validate;
	
	@FXML ChoiceBox<String> matchResult;
	@FXML ChoiceBox<Integer> attackWin;
	@FXML ChoiceBox<Integer> attackLoss;
	@FXML ChoiceBox<Integer> defenseWin;
	@FXML ChoiceBox<Integer> defenseLoss;
	
	@FXML CheckBox highlight;
	@FXML CheckBox tachanka;
	
	@FXML Text pick;
	@FXML Text ban1;
	@FXML Text ban2;
	
	@FXML ImageView showPick0;
	@FXML ImageView showPick1;
	@FXML ImageView showPick2;
	@FXML ImageView showPick3;
	@FXML ImageView showPick4;
	@FXML ImageView showPick5;
	@FXML ImageView showPick6;
	@FXML ImageView showPick7;
	@FXML ImageView showPick8;
	@FXML ImageView showPick9;
	@FXML ImageView showPick10;
	@FXML ImageView showPick11;
	@FXML ImageView showPick12;
	@FXML ImageView showPick13;
	@FXML ImageView showPick14;
	
	@FXML ImageView showFirstBan0;
	@FXML ImageView showFirstBan1;
	@FXML ImageView showFirstBan2;
	@FXML ImageView showFirstBan3;
	@FXML ImageView showFirstBan4;
	@FXML ImageView showFirstBan5;
	@FXML ImageView showFirstBan6;
	@FXML ImageView showFirstBan7;
	@FXML ImageView showFirstBan8;
	@FXML ImageView showFirstBan9;
	@FXML ImageView showFirstBan10;
	@FXML ImageView showFirstBan11;
	@FXML ImageView showFirstBan12;
	@FXML ImageView showFirstBan13;
	@FXML ImageView showFirstBan14;
	
	@FXML ImageView showSecondBan0;
	@FXML ImageView showSecondBan1;
	@FXML ImageView showSecondBan2;
	@FXML ImageView showSecondBan3;
	@FXML ImageView showSecondBan4;
	@FXML ImageView showSecondBan5;
	@FXML ImageView showSecondBan6;
	@FXML ImageView showSecondBan7;
	@FXML ImageView showSecondBan8;
	@FXML ImageView showSecondBan9;
	@FXML ImageView showSecondBan10;
	@FXML ImageView showSecondBan11;
	@FXML ImageView showSecondBan12;
	@FXML ImageView showSecondBan13;
	@FXML ImageView showSecondBan14;
	
	List<ImageView> showPickList = new ArrayList<ImageView>();
	List<ImageView> showFirstBanList = new ArrayList<ImageView>();
	List<ImageView> showSecondBanList = new ArrayList<ImageView>();
	
	List<MapObject> overviewList;
	
	MapObject mapPick;
	MapObject mapFirstBan;
	MapObject mapSecondBan;
	
	public MapObject getMapPick() {
		return mapPick;
	}

	public void setMapPick(MapObject mapPick) {
		this.mapPick = mapPick;
	}

	public MapObject getMapFirstBan() {
		return mapFirstBan;
	}

	public void setMapFirstBan(MapObject mapFirstBan) {
		this.mapFirstBan = mapFirstBan;
	}

	public MapObject getMapSecondBan() {
		return mapSecondBan;
	}

	public void setMapSecondBan(MapObject mapSecondBan) {
		this.mapSecondBan = mapSecondBan;
	}

	@FXML
	private void switchToMainMenu() throws IOException
	{
		App.setRoot("mainMenu");
	}
	
	public void initialize(){
		matchResult.getItems().addAll("Win", "Loss");
		attackWin.getItems().addAll(0, 1, 2, 3, 4, 5);
		attackLoss.getItems().addAll(0, 1, 2, 3, 4, 5);
		defenseWin.getItems().addAll(0, 1, 2, 3, 4, 5);
		defenseLoss.getItems().addAll(0, 1, 2, 3, 4, 5);
		
		showPickList.add(showPick0);
		showPickList.add(showPick1);
		showPickList.add(showPick2);
		showPickList.add(showPick3);
		showPickList.add(showPick4);
		showPickList.add(showPick5);
		showPickList.add(showPick6);
		showPickList.add(showPick7);
		showPickList.add(showPick8);
		showPickList.add(showPick9);
		showPickList.add(showPick10);
		showPickList.add(showPick11);
		showPickList.add(showPick12);
		showPickList.add(showPick13);
		showPickList.add(showPick14);
		
		showFirstBanList.add(showFirstBan0);
		showFirstBanList.add(showFirstBan1);
		showFirstBanList.add(showFirstBan2);
		showFirstBanList.add(showFirstBan3);
		showFirstBanList.add(showFirstBan4);
		showFirstBanList.add(showFirstBan5);
		showFirstBanList.add(showFirstBan6);
		showFirstBanList.add(showFirstBan7);
		showFirstBanList.add(showFirstBan8);
		showFirstBanList.add(showFirstBan9);
		showFirstBanList.add(showFirstBan10);
		showFirstBanList.add(showFirstBan11);
		showFirstBanList.add(showFirstBan12);
		showFirstBanList.add(showFirstBan13);
		showFirstBanList.add(showFirstBan14);
		
		showSecondBanList.add(showSecondBan0);
		showSecondBanList.add(showSecondBan1);
		showSecondBanList.add(showSecondBan2);
		showSecondBanList.add(showSecondBan3);
		showSecondBanList.add(showSecondBan4);
		showSecondBanList.add(showSecondBan5);
		showSecondBanList.add(showSecondBan6);
		showSecondBanList.add(showSecondBan7);
		showSecondBanList.add(showSecondBan8);
		showSecondBanList.add(showSecondBan9);
		showSecondBanList.add(showSecondBan10);
		showSecondBanList.add(showSecondBan11);
		showSecondBanList.add(showSecondBan12);
		showSecondBanList.add(showSecondBan13);
		showSecondBanList.add(showSecondBan14);
		
		overviewList = App.mapH.mapList;
		
		for(int i = 0; i < showPickList.size(); i++) {
			final int index = i;
			this.showPickList.get(index).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					mapPick = overviewList.get(index);
					pick.setText(mapPick.getName());
				}
			});
			this.showFirstBanList.get(index).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					mapFirstBan = overviewList.get(index);
					ban1.setText(mapFirstBan.getName());
				}
			});
			this.showSecondBanList.get(index).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					mapSecondBan = overviewList.get(index);
					ban2.setText(mapSecondBan.getName());
				}
			});
		}
		
		System.out.println("Add match initialized");
	}
	
	private boolean checkAdding() {
		if(matchResult.getValue() != null) {
			if(attackWin.getValue() != null) {
				if(attackLoss.getValue() != null) {
					if(defenseWin.getValue() != null) {
						if(defenseLoss.getValue() != null) {
							if(mapPick != null) {
								if(mapFirstBan != null) {
									if(mapSecondBan != null) {
										if(mapPick != mapFirstBan && mapPick != mapSecondBan && mapFirstBan != mapSecondBan) {
											validate.setText("valid");
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		validate.setText("invalid");
		return false;
	}
	
	@FXML
	private void createNewMatch() throws IOException, JAXBException {
		if(checkAdding()) {
			for(int i = 0; i < overviewList.size(); i++) {
				if(overviewList.get(i) == mapFirstBan) {
					overviewList.get(i).setAppearance(overviewList.get(i).getAppearance() + 1);
				}
				else if(overviewList.get(i) == mapSecondBan) {
					overviewList.get(i).setAppearance(overviewList.get(i).getAppearance() + 1);
				}
				else if(overviewList.get(i) == mapPick) {
					overviewList.get(i).setAppearance(overviewList.get(i).getAppearance() + 1);
					overviewList.get(i).setPick(overviewList.get(i).getPick() + 1);
					overviewList.get(i).setAttackWin(overviewList.get(i).getAttackWin() + attackWin.getValue());
					overviewList.get(i).setAttackLoss(overviewList.get(i).getAttackLoss() + attackLoss.getValue());
					overviewList.get(i).setDefenseWin(overviewList.get(i).getDefenseWin() + defenseWin.getValue());
					overviewList.get(i).setDefenseLoss(overviewList.get(i).getDefenseLoss() + defenseLoss.getValue());
					if(matchResult.getValue() == "Win") {
						overviewList.get(i).setWin(overviewList.get(i).getWin() + 1);
					}
					if(highlight.isSelected() == true) {
						overviewList.get(i).setHighlightCount(overviewList.get(i).getHighlightCount() + 1);
					}
					if(tachanka.isSelected() == true) {
						overviewList.get(i).setHighlightCount(overviewList.get(i).getHighlightCount() + 1);
					}
				}
			}
			App.mapH.mapList = overviewList;
			
			MatchObject match = new MatchObject();
			match.setMapPick(mapPick);
			match.setMapBan1(mapFirstBan);
			match.setMapBan2(mapSecondBan);
			
			if(matchResult.getValue() == "Win") {
				match.setWin(true);
			}
			else {
				match.setWin(false);
			}
			if(highlight.isSelected() == true) {
				match.setHighlight(true);
			}
			else {
				match.setHighlight(false);
			}
			if(tachanka.isSelected() == true) {
				match.setTachanka(true);
			}
			else {
				match.setTachanka(false);
			}
			
			match.setAttackWin(attackWin.getValue());
			match.setAttackLoss(attackLoss.getValue());
			match.setDefenseWin(defenseWin.getValue());
			match.setDefenseLoss(defenseLoss.getValue());
			
			App.matchH.matchList.add(match);
			App.writeFile();
			switchToMainMenu();
		}
	}
}
