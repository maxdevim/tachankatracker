module maxim.tachankatracker {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.xml.bind;
	requires javafx.base;

    opens start to javafx.fxml;
    exports start;
    
    opens controller to javafx.fxml;
    exports controller;
    
    opens helper to java.xml.bind;
    exports helper;
    
    opens objects to java.xml.bind;
    exports objects;
    
}