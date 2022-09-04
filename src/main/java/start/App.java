package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import helper.MapHelper;
import helper.MatchHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import objects.MapObject;

/**
 * JavaFX App
 */

public class App extends Application {

	private static Scene scene;
	
	public static final String MAPOVERVIEWDATA_XML = "./classes/data/mapOverviewData.xml";
	public static final String MATCHHISTORYDATA_XML = "./classes/data/matchHistoryData.xml";
	
	static JAXBContext mapContext;
	static JAXBContext matchContext;
	
	static Marshaller mapMarshaller;
	static Marshaller matchMarshaller;
	
	static Unmarshaller mapUnmarshaller;
	static Unmarshaller matchUnmarshaller;
	
    public static MapHelper mapH;
	public static MatchHelper matchH;
	
	public static MapObject bestMap;

    // Stage settings 
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainMenu"), 900, 700);
        stage.getIcons().add(new Image("file:" + "./classes/images/r6-icon-tachanka.png"));
        stage.setTitle("TACHANKA TRACKER");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    // Scene switcher
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Scene loader from FXML
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/scenes/" + fxml + ".fxml"));
    	return fxmlLoader.load();
    }

    public static void initializeJAXB() throws JAXBException, FileNotFoundException {
    	// JAXB setup for XML files into map lists
   
    	mapContext = JAXBContext.newInstance(MapHelper.class);
    	mapMarshaller = mapContext.createMarshaller();
    	mapUnmarshaller = mapContext.createUnmarshaller();
    	mapMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	
    	mapH = (MapHelper) mapUnmarshaller.unmarshal(new FileReader(MAPOVERVIEWDATA_XML));
    	
    	// JAXB setup for XML files into match lists
    	matchContext = JAXBContext.newInstance(MatchHelper.class);
    	matchMarshaller = matchContext.createMarshaller();
    	matchUnmarshaller = matchContext.createUnmarshaller();
    	matchMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	
    	matchH = (MatchHelper) matchUnmarshaller.unmarshal(new FileReader(MATCHHISTORYDATA_XML));
    }
    
    public static void refreshData() throws FileNotFoundException, JAXBException
    {
    	mapH = (MapHelper) mapUnmarshaller.unmarshal(new FileReader(MAPOVERVIEWDATA_XML));
    	matchH = (MatchHelper) matchUnmarshaller.unmarshal(new FileReader(MATCHHISTORYDATA_XML));
    	mapH.intializeHelper();
    	bestMap = mapH.getBestMap();
    }
    
    public static void writeFile() throws JAXBException {
    	// WRITE from map XML file
    	mapMarshaller.marshal(mapH, new File(MAPOVERVIEWDATA_XML));
    	
    	// WRITE from match XML file
    	matchMarshaller.marshal(matchH, new File(MATCHHISTORYDATA_XML));
    }
    
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
    	
    	initializeJAXB();
    	mapH.intializeHelper();
    	bestMap = mapH.getBestMap();
        launch();
        
    }

}