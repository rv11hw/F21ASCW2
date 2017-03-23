package model;

import java.util.Observable;

import logger.Log;

public class KioskWindow extends Observable implements Runnable {
	String worker;
	PassengerInfo passengerGrp;
	TaxiInfo taxi;

	String window1Str;
	String window2Str;

	Log nn = Log.getInstance();

	public KioskWindow(String worker, PassengerInfo passengerGrp, TaxiInfo taxi) {
		this.worker = worker;
		this.passengerGrp = new PassengerInfo(passengerGrp.getDestination(), passengerGrp.getPassengerCount());
		this.taxi = new TaxiInfo(taxi.getTaxiNo());
		if (worker.equals("W1")) {
			setWindow1Str();
		} else {
			setWindow2Str();
		}
	}

	public void run() {
		// for (int i = 0; i < 5; i++) {
		if (worker.equals("W1")) {
			nn.addString(window1Str+"\n");
		} else {
			nn.addString(window2Str+"\n");
		}
		// }
	}

	public void setWindow1Str() {
		window1Str = "W1: " + passengerGrp.getDestination() + " " + passengerGrp.getPassengerCount() + " "
				+ taxi.getTaxiNo();
	}

	public void setWindow2Str() {
		window2Str = "W2: " + passengerGrp.getDestination() + " " + passengerGrp.getPassengerCount() + " "
				+ taxi.getTaxiNo();
	}

	public String getwindow1Str() {
		return window1Str;
	}

	public String getwindow2Str() {
		return window2Str;
	}

}
