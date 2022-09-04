package objects;

import javax.xml.bind.annotation.XmlRootElement;
import helper.MapHelper;

@XmlRootElement(name = "map")
public class MapObject implements Comparable<MapObject>{
	private int mapID;
	private String name;
	private String imagePath;
	
	private float win;
	private float pick;
	private float appearance;
	
	private float attackWin;
	private float attackLoss;
	private float defenseWin;
	private float defenseLoss;
	
	private int tachankaCount;
	private int highlightCount;
	
	private float winrate;
	private float banrate;
	private float appearancerate;
	private float attackWinrate;
	private float defenseWinrate;
	
	private static int sortColumn = 0;
	
	public void initializeMap() {
		winrate = win != 0 ? win / pick : 0;
		banrate = (appearance == 0) ? 0 : ((pick == 0) ? 1 : 1 - (pick / appearance));
		appearancerate = appearance != 0 ? appearance / MapHelper.appearanceCount : 0;
		attackWinrate = (attackWin + attackLoss) != 0 ? attackWin / (attackWin + attackLoss) : 0;
		defenseWinrate = (defenseWin + defenseLoss) != 0 ? defenseWin / (defenseWin + defenseLoss) : 0;
		
		System.out.println(name + " initialized");
	}
	
	public int getTachankaCount() {
		return tachankaCount;
	}
	public void setTachankaCount(int tachankaCount) {
		this.tachankaCount = tachankaCount;
	}
	public int getHighlightCount() {
		return highlightCount;
	}
	public void setHighlightCount(int highlightCount) {
		this.highlightCount = highlightCount;
	}
	public float getWinrate() {
		return winrate;
	}
	public void setWinrate(float winrate) {
		this.winrate = winrate;
	}
	public float getBanrate() {
		return banrate;
	}
	public void setBanRate(float banrate) {
		this.banrate = banrate;
	}
	public float getAppearancerate() {
		return appearancerate;
	}
	public void setAppearancerate(float appearancerate) {
		this.appearancerate = appearancerate;
	}
	public float getAttackWinrate() {
		return attackWinrate;
	}
	public void setAttackWinrate(float attackWinrate) {
		this.attackWinrate = attackWinrate;
	}
	public float getDefenseWinrate() {
		return defenseWinrate;
	}
	public void setDefenseWinrate(float defenseWinrate) {
		this.defenseWinrate = defenseWinrate;
	}
	public float getAttackWin() {
		return attackWin;
	}
	public void setAttackWin(float attackWin) {
		this.attackWin = attackWin;
	}
	public float getAttackLoss() {
		return attackLoss;
	}
	public void setAttackLoss(float attackLoss) {
		this.attackLoss = attackLoss;
	}
	public float getDefenseWin() {
		return defenseWin;
	}
	public void setDefenseWin(float defenseWin) {
		this.defenseWin = defenseWin;
	}
	public float getDefenseLoss() {
		return defenseLoss;
	}
	public void setDefenseLoss(float defenseLoss) {
		this.defenseLoss = defenseLoss;
	}
	public int getMapID() {
		return mapID;
	}
	public void setMapID(int mapID) {
		this.mapID = mapID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public float getWin() {
		return win;
	}
	public void setWin(float win) {
		this.win = win;
	}
	public float getPick() {
		return pick;
	}
	public void setPick(float pick) {
		this.pick = pick;
	}
	public float getAppearance() {
		return appearance;
	}
	public void setAppearance(float appearance) {
		this.appearance = appearance;
	}

	public void setBanrate(float banrate) {
		this.banrate = banrate;
	}

	@Override
	public int compareTo(MapObject o) {
		
		switch (sortColumn) {
		case 0:
			if(getWinrate() < o.getWinrate())
			{
				return -1;
			}
			else if(getWinrate() > o.getWinrate())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		case 1:
			if(getBanrate() < o.getBanrate())
			{
				return -1;
			}
			else if(getBanrate() > o.getBanrate())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		case 2:
			if(getAppearancerate() < o.getAppearancerate())
			{
				return -1;
			}
			else if(getAppearancerate() > o.getAppearancerate())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		case 3:
			if(getMapID() < o.getMapID())
			{
				return -1;
			}
			if(getMapID() > o.getMapID())
			{
				return 1;
			}
		}
		return 0;
	}

	public static void setSortColumn(int sortColumn) {
		MapObject.sortColumn = sortColumn;
	}

	@Override
	public String toString() {
		return name + " " + pick + " " + win + " " + winrate;
	}
	
	
}
