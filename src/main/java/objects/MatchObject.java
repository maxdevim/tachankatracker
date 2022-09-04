package objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "match")
public class MatchObject {
	private MapObject mapPick;
	private MapObject mapBan1;
	private MapObject mapBan2;
	
	private boolean isWin;
	private boolean isTachanka;
	private boolean isHighlight;
	
	private int attackWin;
	private int attackLoss;
	private int defenseWin;
	private int defenseLoss;
	
	public MapObject getMapPick() {
		return mapPick;
	}
	public void setMapPick(MapObject mapPick) {
		this.mapPick = mapPick;
	}
	public MapObject getMapBan1() {
		return mapBan1;
	}
	public void setMapBan1(MapObject mapBan1) {
		this.mapBan1 = mapBan1;
	}
	public MapObject getMapBan2() {
		return mapBan2;
	}
	public void setMapBan2(MapObject mapBan2) {
		this.mapBan2 = mapBan2;
	}
	public boolean isWin() {
		return isWin;
	}
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
	public boolean isTachanka() {
		return isTachanka;
	}
	public void setTachanka(boolean isTachanka) {
		this.isTachanka = isTachanka;
	}
	public boolean isHighlight() {
		return isHighlight;
	}
	public void setHighlight(boolean isHighlight) {
		this.isHighlight = isHighlight;
	}
	public int getAttackWin() {
		return attackWin;
	}
	public void setAttackWin(int attackWin) {
		this.attackWin = attackWin;
	}
	public int getAttackLoss() {
		return attackLoss;
	}
	public void setAttackLoss(int attackLoss) {
		this.attackLoss = attackLoss;
	}
	public int getDefenseWin() {
		return defenseWin;
	}
	public void setDefenseWin(int defenseWin) {
		this.defenseWin = defenseWin;
	}
	public int getDefenseLoss() {
		return defenseLoss;
	}
	public void setDefenseLoss(int defenseLoss) {
		this.defenseLoss = defenseLoss;
	}
	
	
}
