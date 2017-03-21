package model;

/**
 * Created by jithinjanardanan on 3/17/17.
 */
public class TaxiInfo {
    String taxiNo;
    public TaxiInfo (String a)
    {
        if(a.trim().length()==0|a.trim().length()>5)
            throw new IllegalStateException("Invalid input encountered! Please check your input again");
        taxiNo = a;
    }
    public String getTaxiNo()
    {
        return taxiNo;
    }

}
