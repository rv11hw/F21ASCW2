package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.Observer;
import interfaces.Subject;

public class TaxiStationModel implements Subject  {

	PassengerManager pgManage;
	TaxiManager taxiManage;
	String passManagerStr;
	String taxiManagerStr;
	
	KioskWindow window1;
	KioskWindow window2;
	

	public TaxiStationModel()  {
		pgManage = new PassengerManager();
		taxiManage = new TaxiManager();
	}
	
	public void setQueue(int passngerGrpNo, int taxiNo){
		pgManage.setLimit(passngerGrpNo);
		taxiManage.setLimit(taxiNo);
		updateQueue();
	}
	
	public void updateQueue(){
		passManagerStr = pgManage.getStrData();
		taxiManagerStr = taxiManage.getStrData();
		notifyObservers();
	}
	
	public String getPassengerQueue(){
		return passManagerStr;
	}
	
	public String getTaxiQueue(){
		return taxiManagerStr;
	}	
	
	public void dispQueue(){
		pgManage.dispData();
		taxiManage.dispData();
	}
	
	public void dispPassengerQueue(){
		pgManage.dispData();
	}
	
	public void dispTaxiQueue(){
		taxiManage.dispData();
	}
	
	public String getWin1Queue(){
		if(window1 == null){
			return "";
		}
		return window1.getwindow1Str();
	}
	
	public String getWin2Queue(){
		if(window2 == null){
			return "";
		}
		return window2.getwindow2Str();
	}
	
	public void start(){		
		int count = 0;		
		for(PassengerInfo pass : pgManage.getPGObj()){
			TaxiInfo taxi = taxiManage.getTaxiObj().get(count);
			
			// creates and starts a thread using this counter
			pgManage.removeData();
			
			window1 = new KioskWindow("W1",pass,taxi);
			notifyObservers();			
			Thread thread1 = new Thread(window1);
			thread1.start();
			

			// creates and starts a 2nd thread using this counter
			window2 = new KioskWindow("W2",pass,taxi);
			notifyObservers();
			Thread thread2 = new Thread(window2);
			thread2.start();
			
			if(++count == pgManage.getLimit() || ++count == taxiManage.getLimit()){
		    	break;
		    }
		}
	}
	
	////////////////////////////////////////////////////////
	// OBSERVER PATTERN
	// SUBJECT must be able to register, remove and notify observers
	// list to hold any observers
	private List<Observer> registeredObservers = new LinkedList<Observer>();

	// methods to register, remove and notify observers
	public void registerObserver(Observer obs) {
		registeredObservers.add(obs);
	}

	public void removeObserver(Observer obs) {
		registeredObservers.remove(obs);
	}

	public void notifyObservers() {
		for (Observer obs : registeredObservers)
			obs.update();
	}
	////////////////////////////////////////////////////////
}
