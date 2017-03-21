package model;

/**
 * Created by jithinjanardanan on 3/17/17.
 */
public class PassengerInfo {
    String destination;
    String noOfPassengers;

    public PassengerInfo(String a, String b)
    {
        if(a.trim().length()==0||b.trim().length()==0)
            throw new IllegalStateException("Invalid input encountered! Please check your input again");
        destination = a;
        noOfPassengers = b;

    }
    public String getDestination()
    {
        return destination;
    }
    public String getPassengerCount()
    {
        return noOfPassengers;
    }
}
