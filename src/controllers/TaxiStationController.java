package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import interfaces.Subject;
import model.TaxiStationModel;
//import model.Clock;
import views.TaxiStationGUI;

//Handles interaction with users
//calls view and model as needed

public class TaxiStationController {

	private TaxiStationGUI view;  //GUI to allow user to set the time

	private TaxiStationModel taxiStationModel;       //KioskModel models taxi and passenger group model
	
	public TaxiStationController(TaxiStationGUI view, TaxiStationModel model) {
		this.taxiStationModel = model;
		this.view = view;
		//specify the listener for the view
		view.addSetListener(new SetListener());
	}
	
	//inner class SetListener responds when user sets the time
	public class SetListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			int passNo = Integer.parseInt(view.getPassNumber());
			int taxiNo = Integer.parseInt(view.getTaxiNumbers());
			taxiStationModel.setQueue(passNo, taxiNo);
			taxiStationModel.dispQueue();
			taxiStationModel.start();
		}
	}

}
