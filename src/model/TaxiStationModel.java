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
