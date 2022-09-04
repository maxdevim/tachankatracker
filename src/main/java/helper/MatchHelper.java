package helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import objects.MatchObject;

@XmlRootElement(name = "matchHelper")
public class MatchHelper {
	public List<MatchObject> matchList = new ArrayList<MatchObject>();
}
