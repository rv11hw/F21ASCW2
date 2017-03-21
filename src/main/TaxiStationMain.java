package main;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import controllers.TaxiStationController;
import model.TaxiStationModel;
import model.PassengerInfo;
import model.ProcessFile;
import model.TaxiInfo;
import views.TaxiStationGUI;


public class TaxiStationMain {

    public static void main(String[] args)
    {
    	// Model for kiosk
    	TaxiStationModel model = new TaxiStationModel();
    	
        //This view displays the time, updating whenever changed
    	//AND incorporates the GUI to change the time
    	TaxiStationGUI view = new TaxiStationGUI(model); 
    	
    	//this controller responds when the time is changed in the view
    	//it needs to know about the view and the model
    	TaxiStationController controller = new TaxiStationController (view, model);
    	
    	//now all is displayed, wait for user to interact
 
    } 
}
