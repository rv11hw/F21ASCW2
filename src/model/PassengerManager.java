package model;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * Created by jithinjanardanan on 3/17/17.
 */

public class PassengerManager {
	
	ArrayList<PassengerInfo> passengerGroup;	
	int limit;
	
	PassengerManager(){
		 passengerGroup = new ArrayList<PassengerInfo>();
		 fetchData();
	}
	
	public void fetchData(){		
		ArrayList<String> temp1 = ProcessFile.readFile("PassengerList");
		for(String line:temp1)
		{
			String[] parts = line.split(",",2);
		    String part1 = parts[0];
		    String part2 = parts[1];
		    PassengerInfo psngrInfo = new PassengerInfo(part1,part2);
		    passengerGroup.add(psngrInfo);
		}
	}
	
	public void removeData(){
		passengerGroup.remove(0);
		limit--;
	}
	
	public String fetchFirstData(){
		String str = "";
		for(PassengerInfo pi : passengerGroup){
			 str += pi.getDestination();
			 str += pi.getPassengerCount()+"\n";
			 break;
		}
		return str;
	}
	
	public void dispData(){
		int count = 0;
		System.out.println("Passenger Group information:-");
		Iterator<PassengerInfo> itr1 = passengerGroup.iterator();
		while (itr1.hasNext()) {
		    PassengerInfo x = (PassengerInfo) itr1.next();
		    System.out.println(x.getDestination());
		    System.out.println(x.getPassengerCount()+"\n");
		    if(++count == limit){
		    	break;
		    }
		}
	}
	
	public String getStrData(){
		int count = 0;
		String str = "";
		Iterator<PassengerInfo> itr1 = passengerGroup.iterator();
		while (itr1.hasNext()) {
		    PassengerInfo x = (PassengerInfo) itr1.next();
		    str += x.getDestination();
		    str += x.getPassengerCount()+"\n";
		    if(++count == limit){
		    	break;
		    }
		}
		return str;
	}
	
	public ArrayList<PassengerInfo> getPGObj(){
		return passengerGroup;
	}
	
	public void setLimit(int limit){
		this.limit = limit;
	}
	public int getLimit(){
		return limit;
	}
	
}