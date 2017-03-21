package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jithinjanardanan on 3/17/17.
 */
public class TaxiManager {
    ArrayList<TaxiInfo> taxiGroup;
    int limit;
	
	TaxiManager(){
		this.taxiGroup = new ArrayList<TaxiInfo>();
		fetchData();
	}
	
	public void fetchData(){
	    ArrayList<String> temp2 = ProcessFile.readFile("TaxiList");
		for(String line:temp2)
        {
			TaxiInfo taxiInf = new TaxiInfo(line);
            taxiGroup.add(taxiInf);
        }
	}
	
	public void removeData(){
		taxiGroup.remove(0);
		limit--;
	}	
	
	public void dispData(){
		int count = 0;
		System.out.println("Taxi Group information:-");
        Iterator<TaxiInfo> itr2 = taxiGroup.iterator();
        while (itr2.hasNext()) {
        	TaxiInfo x = (TaxiInfo) itr2.next();
            System.out.println(x.getTaxiNo()+"\n");
            if(++count == limit){
		    	break;
		    }
        }		
	}
	
	public String getStrData(){
		int count = 0;
		String str = "";
		Iterator<TaxiInfo> itr2 = taxiGroup.iterator();
		while (itr2.hasNext()) {
        	TaxiInfo x = (TaxiInfo) itr2.next();
		    str += x.getTaxiNo()+"\n";
		    if(++count == limit){
		    	break;
		    }
		}
		return str;
	}	
	
	
	public ArrayList<TaxiInfo> getTaxiObj(){
		return taxiGroup;
	}
	
	public void setLimit(int limit){
		this.limit = limit;
	}
	public int getLimit(){
		return limit;
	}
}
