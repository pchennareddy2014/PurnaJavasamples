/*
Design a parking lot using object-oriented principles

Goals:
- Your solution should be in Java - if you would like to use another language, please let the interviewer know.
- Boilerplate is provided. Feel free to change the code as you see fit

Assumptions:
- The parking lot can hold motorcycles, cars and vans
- The parking lot has motorcycle spots, car spots and large spots
- A motorcycle can park in any spot
- A car can park in a single compact spot, or a regular spot
- A van can park, but it will take up 3 regular spots
- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed
Spots : motorCycleSpot, compactSpot, regularSpot
Motorcycle - any spot
Car -- compact and regular
Van -- 3 regular

10 each
3, 3, 3 vans
spotType, total
spotType, available
spotType, filled


Here are a few methods that you should be able to run:
- Tell us how many spots are remaining
- Tell us how many total spots are in the parking lot
- Tell us when the parking lot is full
- Tell us when the parking lot is empty
- Tell us when certain spots are full e.g. when all motorcycle spots are taken
- Tell us how many spots vans are taking up

Hey candidate! Welcome to your interview. I'll start off by giving you a Solution class. To run the code at any time, please hit the run button located in the top left corner.
*/

import java.io.*;
import java.util.*;

class ParklingLotSolution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Please put code below");
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("************* Parking LOT ****************");
        System.out.println("Initilizing");
        initializeparkingLot(5, 5, 5 );
        printStatus();

        allocateSpot(CYCLE);
        allocateSpot(CAR);
        allocateSpot(VAN);

        printStatus();

        allocateSpot(VAN);
        allocateSpot(VAN);
        allocateSpot(VAN);

        allocateSpot(VAN);

        allocateSpot(CAR);
        allocateSpot(CAR);
        allocateSpot(CAR);

        allocateSpot(CAR);
        allocateSpot(CYCLE);

        printStatus();
    }
    static String motorcyceSpot = "CYCLE_SPOT";
    static String compactSpot = "COMPACT_SPOT";
    static String regularSpot = "REGULAR_SPOT";

    static final String CYCLE = "CYCLE";
    static final String CAR = "CAR";
    static final String VAN = "VAN";

    static final String FULL = "FULL";
    static final String EMPTY = "EMPTY";

    static Map<String, Integer> totalAvailableSpots = new HashMap<String, Integer>();
    static Map<String, Integer> allocated = new HashMap<String, Integer>();
    static Map<String, String> status = new HashMap<String, String>();

    public static void initializeparkingLot(Integer cycyleSpots, Integer compactSpots, Integer regularSpots) {
        totalAvailableSpots.put(CYCLE , cycyleSpots);
        totalAvailableSpots.put(CAR , compactSpots);
        totalAvailableSpots.put(VAN , regularSpots);

    }
    public static void allocateSpot( String vehicleType ) {
        switch( vehicleType) {
            case  CYCLE : // if any spot availble allocate and reduce available
                if( totalAvailableSpots.get(CYCLE) > 0 ) {
                    totalAvailableSpots.put(CYCLE, totalAvailableSpots.get(CYCLE)-1);
                    allocated.put(CYCLE, ( allocated.get(CYCLE) != null ? allocated.get(CYCLE)+1 : 1));
                } else if( totalAvailableSpots.get(CAR) > 0 ) {
                    totalAvailableSpots.put(CAR, totalAvailableSpots.get(CAR)-1);
                    allocated.put(CAR, allocated.get(CAR) != null ? allocated.get(CAR)+1 : 1);
                }  else if( totalAvailableSpots.get(VAN) > 0 ) {
                    totalAvailableSpots.put(VAN, totalAvailableSpots.get(VAN)-1);
                    allocated.put(VAN, allocated.get(VAN) != null ? allocated.get(VAN)+1 : 1);
                }
                break;
            case  CAR : // if any spot availble allocate and reduce available
                if( totalAvailableSpots.get(CAR) > 0 ) {
                    totalAvailableSpots.put(CAR, totalAvailableSpots.get(CAR)-1);
                    allocated.put(CAR, allocated.get(CAR) != null ? allocated.get(CAR)+1 : 1);
                }  else if( totalAvailableSpots.get(VAN) > 0 ) {
                    totalAvailableSpots.put(VAN, totalAvailableSpots.get(VAN)-1);
                    allocated.put(VAN, allocated.get(VAN) != null ? allocated.get(VAN)+1 : 1);
                }
                break;
            case  VAN : // if any spot availble allocate and reduce available
                if( totalAvailableSpots.get(VAN) >= 3 ) {
                    totalAvailableSpots.put(VAN, totalAvailableSpots.get(VAN)-3);
                    allocated.put(VAN, allocated.get(VAN) != null ? allocated.get(VAN)+3 : 3);
                }
                break;
        }
        //update available  status
        status.put(CYCLE ,  totalAvailableSpots.get(CYCLE) <= 0 ? FULL : "EMPTY "+ String.valueOf(totalAvailableSpots.get(CYCLE)));
        status.put(CAR ,  totalAvailableSpots.get(CAR) <= 0 ? FULL : "EMPTY "+ String.valueOf(totalAvailableSpots.get(CAR)));
        status.put(VAN ,  totalAvailableSpots.get(VAN) < 3 ? FULL : "EMPTY "+ String.valueOf(totalAvailableSpots.get(VAN)));

    }

    public static void printStatus() {
        System.out.println(totalAvailableSpots);
        System.out.println(allocated);
        System.out.println(status);
    }

}

