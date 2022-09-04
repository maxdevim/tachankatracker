package helper;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import objects.MatchObject;

public class MatchHistoryHelper extends AnchorPane {
	MatchObject matchData;
	int matchID;
	Rectangle showResult = new Rectangle();
	Rectangle container = new Rectangle();
	ImageView showMap = new ImageView();
	ImageView showTachanka = new ImageView();
	ImageView showHighlight = new ImageView();
	Text mapTitle = new Text();
	Text attack = new Text();
	Text attackStats = new Text();
	Text defense = new Text();
	Text defenseStats = new Text();
	
	Text banTitles = new Text();
	
	int yOffset = 120;
	
	public MatchHistoryHelper(MatchObject match, int id){
		this.prefHeight(120);
		this.prefWidth(565);
		this.getChildren().add(showResult);
		this.getChildren().add(container);
		this.getChildren().add(showMap);
		this.getChildren().add(showTachanka);
		this.getChildren().add(showHighlight);
		this.getChildren().add(mapTitle);
		this.getChildren().add(banTitles);
		this.getChildren().add(attack);
		this.getChildren().add(attackStats);
		this.getChildren().add(defense);
		this.getChildren().add(defenseStats);
		matchData = match;
		matchID = id;
		setupElements();
	}
	
	private void setupElements(){
		showResult.setWidth(55);
		showResult.setHeight(117);
		showResult.setLayoutY(0 + (yOffset * matchID));
		if(matchData.isWin()) {
			showResult.setFill(Color.LIMEGREEN);
		}
		else {
			showResult.setFill(Color.RED);
		}
		
		banTitles.setLayoutX(270);
		banTitles.setLayoutY(60 + (yOffset * matchID));
		banTitles.setText(matchData.getMapBan1().getName() + " / " + matchData.getMapBan2().getName());
		banTitles.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		
		container.setWidth(307);
		container.setHeight(117 + (yOffset * matchID));
		container.setLayoutX(260);
		container.setLayoutY(0 + (yOffset * matchID));
		container.setFill(Color.TRANSPARENT);
		
		showMap.setFitWidth(201);
		showMap.setFitHeight(117);
		showMap.setLayoutX(57);
		showMap.setLayoutY(0 + (yOffset * matchID));
		showMap.setImage(new Image("file:" + matchData.getMapPick().getImagePath()));
		
		mapTitle.setLayoutX(273);
		mapTitle.setLayoutY(27 + (yOffset * matchID));
		mapTitle.setText(matchData.getMapPick().getName());
		mapTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		mapTitle.setUnderline(true);
		
		attack.setLayoutX(300);
		attack.setLayoutY(85 + (yOffset * matchID));
		attack.setText("Attack W/L");
		attack.setFont(Font.font("Verdana", 15));
		
		attackStats.setLayoutX(330);
		attackStats.setLayoutY(105 + (yOffset * matchID));
		attackStats.setText(matchData.getAttackWin() + " / " + matchData.getAttackLoss());
		attackStats.setFont(Font.font("Verdana", 15));
		
		defense.setLayoutX(430);
		defense.setLayoutY(85 + (yOffset * matchID));
		defense.setText("Defense W/L");
		defense.setFont(Font.font("Verdana", 15));
		
		defenseStats.setLayoutX(470);
		defenseStats.setLayoutY(105 + (yOffset * matchID));
		defenseStats.setText(matchData.getDefenseWin() + " / " + matchData.getDefenseLoss());
		defenseStats.setFont(Font.font("Verdana", 15));
		
		if(matchData.isTachanka()) {
			showTachanka.setFitHeight(35);
			showTachanka.setFitWidth(30);
			showTachanka.setLayoutX(500);
			showTachanka.setLayoutY(0 + (yOffset * matchID));
			showTachanka.setImage(new Image("file:" + "./classes/images/r6-icon-tachanka.png"));
		}
		
		if(matchData.isHighlight()) {
			showHighlight.setFitHeight(35);
			showHighlight.setFitWidth(30);
			showHighlight.setLayoutX(530);
			showHighlight.setLayoutY(0 + (yOffset * matchID));
			showHighlight.setImage(new Image("file:" + "./classes/images/r6-icon-crime.png"));
		}
	}
}
