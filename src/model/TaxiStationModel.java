package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.Observer;
import interfaces.Subject;

public class TaxiStationModel implements Runnable, Subject  {

	PassengerManager pgManage;
	TaxiManager taxiManage;
	String passManagerStr;
	String taxiManagerStr;
	
	KioskWindow window1;
	KioskWindow window2;
	
	String winSelect = "W1";
	
	Thread thread1;
	Thread thread2;
	

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
	
	public void setWindowVal(String val){
		winSelect = val;
	}
	
	public String getWindowVal(){
		return winSelect;
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
		}/* else{
			try {
				thread1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return window1.getwindow1Str();
	}
	
	public String getWin2Queue(){
		if(window2 == null){
			return "";
		}/* else{
			try {
				thread1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return window2.getwindow2Str();
	}
	
	public void run(){		
		int count = 0;		
		for(PassengerInfo pass : pgManage.getPGObj()){
			TaxiInfo taxi = taxiManage.getTaxiObj().get(count);
		
			// creates and starts a thread using this counter
			if(count%2 == 0){
				setWindowVal("W1");
				window1 = new KioskWindow("W1",pass,taxi);					
				thread1 = new Thread(window1);					
				thread1.start();
				notifyObservers();
				
			}else{
				// creates and starts a 2nd thread using this counter
				setWindowVal("W2");
				window2 = new KioskWindow("W2",pass,taxi);					
				thread2 = new Thread(window2);				
				thread2.start();
				notifyObservers();
			}		
			count++;
			if(count == (pgManage.getLimit()) || count == (taxiManage.getLimit())){
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
