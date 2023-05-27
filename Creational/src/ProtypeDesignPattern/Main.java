package ProtypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Airport airportA = new Airport();
        airportA.loadDefaultFlights();
        System.out.println("Airport A -> " + airportA.getDefaultFlights());

        Airport airportB = (Airport) airportA.clone();
        airportB.defaultFlights.add("Qatar Airways");
        System.out.println("Airport B -> " + airportB.getDefaultFlights());

        // changing default flights of airport B doesn't change default flights of airport A
        System.out.println("Airport A -> " + airportA.getDefaultFlights());
    }
}

class Airport implements Cloneable{
    List<String> defaultFlights;

    @Override
    public String toString() {
        return "Airport{" +
                "defaultFlights=" + defaultFlights +
                '}';
    }

    Airport() {
        defaultFlights = new ArrayList<>();
    }
    
    Airport(List<String> list) {
        defaultFlights = list;
    }

    public void loadDefaultFlights() {
        defaultFlights.add("British Airways");
        defaultFlights.add("Emirates Airways");
    }

    public List<String> getDefaultFlights() {
        return defaultFlights;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String name: this.getDefaultFlights()) {
            temp.add(name);
        }
        return new Airport(temp);
    }
}
