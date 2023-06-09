package Scheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MainTester {
    Time beforeSchool = new Time(LocalTime.of(7, 40), LocalTime.of(8, 0));
    Time period1 = new Time(LocalTime.of(8, 0), LocalTime.of(9, 15));
    Time period2 = new Time(LocalTime.of(9, 20), LocalTime.of(10, 35));
    Time lunch = new Time(LocalTime.of(10, 35), LocalTime.of(11, 35));
    Time period3 = new Time(LocalTime.of(11, 35), LocalTime.of(12, 50));
    Time period4 = new Time(LocalTime.of(12, 55), LocalTime.of(14, 10));
    Time afterSchool = new Time(LocalTime.of(14, 10), LocalTime.of(14, 30));
    Teacher Teach1 = new Teacher(1000, 485, (ArrayList<Time>) Arrays.asList(period2, period4), (ArrayList<Time>) Arrays.asList(period1, period3), null, true);
    Teacher Teach2 = new Teacher(800, 344, (ArrayList<Time>) Arrays.asList(period2, period3), (ArrayList<Time>) Arrays.asList(period1, period4), null, true);
    Teacher Teach3 = new Teacher(1200, 540, (ArrayList<Time>) Arrays.asList(period1, period3), (ArrayList<Time>) Arrays.asList(period2, period4), null, true);
    Teacher Teach4 = new Teacher(1050, 250, (ArrayList<Time>) Arrays.asList(period1, period4), (ArrayList<Time>) Arrays.asList(period2, period3), null, true);
}
