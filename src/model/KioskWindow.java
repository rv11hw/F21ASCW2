package model;

public class KioskWindow implements Runnable {
	String worker;
	PassengerInfo passengerGrp;
	TaxiInfo taxi;
	
	String window1Str;
	String window2Str;
	
	public KioskWindow(String worker, PassengerInfo passengerGrp, TaxiInfo taxi){
		this.worker = worker;
		this.passengerGrp = new PassengerInfo(passengerGrp.getDestination(), passengerGrp.getPassengerCount());
		this.taxi = new TaxiInfo(taxi.getTaxiNo());
		if(worker.equals("W1")){
			setWindow1Str();
		} else{
			setWindow2Str();
		}	
	}
	
	public void run() {
		//for (int i = 0; i < 5; i++) {
			try {						
				Thread.sleep(10);		
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
	
	/*public static TravelManager getInstance()
	{
	if (instance == null)
	instance = new NextNumber();
	return instance;
	}*/
	
	//public String 
}
