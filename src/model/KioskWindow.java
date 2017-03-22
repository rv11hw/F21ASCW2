package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.Observer;
import interfaces.Subject;
import views.KioskGUI;

public class KioskWindow implements Runnable    {
	String worker;
	PassengerInfo passengerGrp;
	TaxiInfo taxi;
	
	String window1Str;
	String window2Str;
	
	public KioskWindow(){
		
	}
	
	public KioskWindow(String worker, PassengerInfo passengerGrp, TaxiInfo taxi){
		this.worker = worker;
		this.passengerGrp = new PassengerInfo(passengerGrp.getDestination(), passengerGrp.getPassengerCount());
		this.taxi = new TaxiInfo(taxi.getTaxiNo());
	}
	
	public void run() {
		//for (int i = 0; i < 5; i++) {
			try {						
				Thread.sleep(5000);		
				if(worker.equals("W1")){
					setWindow1Str();
					KioskGUI kobs = new KioskGUI();
					for (Observer obs : registeredObservers){					
					kobs = (KioskGUI) obs;
					kobs.update(worker);
					}
				} else{
					setWindow2Str();
					KioskGUI kobs = new KioskGUI();
					for (Observer obs : registeredObservers){					
					kobs = (KioskGUI) obs;
					kobs.update(worker);
					}
				}	
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		//}
	}
	
	public void setWindow1Str(){
		window1Str = "W1" + passengerGrp.getDestination()+" "+passengerGrp.getPassengerCount()+" "+taxi.getTaxiNo();
	}
	
	public void setWindow2Str(){
		window2Str = "W2" + passengerGrp.getDestination()+" "+passengerGrp.getPassengerCount()+" "+taxi.getTaxiNo();
	}
	
	public String getwindow1Str(){		
		return window1Str;
	}
	
	public String getwindow2Str(){		
		return window2Str;
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

	public void notifyObservers(String worker) {
		KioskGUI kobs = new KioskGUI();
		for (Observer obs : registeredObservers)
			kobs = (KioskGUI) obs;
			kobs.update(worker);
	}
	////////////////////////////////////////////////////////
	
	/*public static TravelManager getInstance()
	{
	if (instance == null)
	instance = new NextNumber();
	return instance;
	}*/
	
	//public String 
}
