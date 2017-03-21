package views;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.TaxiStationModel;




public class TaxiStationGUI
{
	LauncherGUI lgui;
	QueueGUI qgui;
	KioskGUI kgui;
	
	public TaxiStationGUI(TaxiStationModel model){
		lgui = new LauncherGUI();
		lgui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lgui.setVisible(true);
		
		qgui = new QueueGUI(model);
	    qgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    qgui.setVisible(true);
	    qgui.update();
	    
	    kgui = new KioskGUI(model);
		kgui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kgui.setVisible(true);
	}
	
	//return contents of passenger text box
	public String getPassNumber() {
		return lgui.getPassNumber();
	}
	
	//return contents of taxi text box
	public String getTaxiNumbers() {
		return lgui.getTaxiNumbers();
	}
	
	//add listener to update button
	public void addSetListener (ActionListener al) {
		lgui.addSetListener(al);
	}
}

