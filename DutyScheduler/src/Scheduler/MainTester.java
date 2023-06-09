package Scheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MainTester {
    Time beforeSchool = new Time("beforeSchool", LocalTime.of(7, 40), LocalTime.of(8, 0));
    Time period1 = new Time("period1", LocalTime.of(8, 0), LocalTime.of(9, 15));
    Time period2 = new Time("period2", LocalTime.of(9, 20), LocalTime.of(10, 35));
    Time lunch = new Time("lunch", LocalTime.of(10, 35), LocalTime.of(11, 35));
    Time period3 = new Time("period3", LocalTime.of(11, 35), LocalTime.of(12, 50));
    Time period4 = new Time("period4", LocalTime.of(12, 55), LocalTime.of(14, 10));
    Time afterSchool = new Time("afterSchool", LocalTime.of(14, 10), LocalTime.of(14, 30));
    Teacher teach1 = new Teacher("Teach1", 1000, 485, (ArrayList<Time>) Arrays.asList(period2, period4), (ArrayList<Time>) Arrays.asList(period1, period3), null, true);
    Teacher teach2 = new Teacher("Teach2", 800, 344, (ArrayList<Time>) Arrays.asList(period2, period3), (ArrayList<Time>) Arrays.asList(period1, period4), null, true);
    Teacher teach3 = new Teacher("Teach3", 1200, 540, (ArrayList<Time>) Arrays.asList(period1, period3), (ArrayList<Time>) Arrays.asList(period2, period4), null, true);
    Teacher teach4 = new Teacher("Teach4", 1050, 250, (ArrayList<Time>) Arrays.asList(period1, period4), (ArrayList<Time>) Arrays.asList(period2, period3), null, true);
    Location cafeteria = new Location("Cafe", "The cafeteria", (ArrayList<Time>) Arrays.asList(lunch));
    Location hall1 = new Location("hall1", "The main hall", (ArrayList<Time>) Arrays.asList(period1, period2, lunch, period3, period4));
    Location hall2 = new Location("hall2", "The side hall", (ArrayList<Time>) Arrays.asList(period2, period3));
    Location hall3 = new Location("Buses", "Bus pickup zone", (ArrayList<Time>) Arrays.asList(beforeSchool, afterSchool));
    Restriction teach2Restrict = new Restriction("Not coming in morning", );//todo: fix CSVDemo
    Restriction Teach4Restrict = new Restriction();
}
