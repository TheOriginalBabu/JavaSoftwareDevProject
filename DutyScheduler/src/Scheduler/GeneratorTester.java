package Scheduler;

import java.time.LocalTime;
import java.util.*;

public class GeneratorTester {
    public Time beforeSchool = new Time("beforeSchool", LocalTime.of(7, 40), LocalTime.of(8, 0));
    public Time period1 = new Time("period1", LocalTime.of(8, 0), LocalTime.of(9, 15));
    public Time period2 = new Time("period2", LocalTime.of(9, 20), LocalTime.of(10, 35));
    public Time lunch = new Time("lunch", LocalTime.of(10, 35), LocalTime.of(11, 35));
    public Time period3 = new Time("period3", LocalTime.of(11, 35), LocalTime.of(12, 50));
    public Time period4 = new Time("period4", LocalTime.of(12, 55), LocalTime.of(14, 10));
    public Time afterSchool = new Time("afterSchool", LocalTime.of(14, 10), LocalTime.of(14, 30));
    public Teacher teach1 = new Teacher("Teach1", 1000, 485, new ArrayList<>(Arrays.asList(period2, period4)), new ArrayList<>(Arrays.asList(period1, period3)), new HashMap<Time, Boolean>(){{put(beforeSchool, true); put(afterSchool, true); put(lunch, true)}});
    public Teacher teach2 = new Teacher("Teach2", 800, 344, new ArrayList<>(Arrays.asList(period2, period3)), new ArrayList<>(Arrays.asList(period1, period4)), true);
    public Teacher teach3 = new Teacher("Teach3", 1200, 540, new ArrayList<>(Arrays.asList(period1, period3)), new ArrayList<>(Arrays.asList(period2, period4)), true);
    public Teacher teach4 = new Teacher("Teach4", 1050, 250, new ArrayList<>(Arrays.asList(period1, period4)), new ArrayList<>(Arrays.asList(period2, period3)), true);
    public Location cafeteria = new Location("Cafe", "The cafeteria", new ArrayList<>(Arrays.asList(lunch)));
    public Location hall1 = new Location("hall1", "The main hall", new ArrayList<>(Arrays.asList(period1, period2, lunch, period3, period4)));
    public Location hall2 = new Location("hall2", "The side hall", new ArrayList<>(Arrays.asList(period2, period3)));
    public Location buses = new Location("Buses", "Bus pickup zone", new ArrayList<>(Arrays.asList(beforeSchool, afterSchool)));
    public Restriction teach2Restrict = new Restriction("Not coming in morning", new Date(123, 0, 3), 0, period1, false);//todo: fix CSVDemo
    public Restriction Teach4Restrict = new Restriction("Leaving Early", new Date(123, 0, 4), 0, period4, false);
    public SupervisionDuty morningBus = new SupervisionDuty("morningBus", beforeSchool, buses, 0);
    public SupervisionDuty afternoonBus = new SupervisionDuty("afternoonBus", afterSchool, buses, 0);
    public SupervisionDuty cafeteriaDuty = new SupervisionDuty("cafeteriaDuty", lunch, cafeteria, 0);
    public SupervisionDuty Hall1Period1 = new SupervisionDuty("Hall1Period1", period1, hall1, 0);
    public SupervisionDuty Hall1Period2 = new SupervisionDuty("Hall1Period2", period2, hall1, 0);
    public SupervisionDuty Hall1Period3 = new SupervisionDuty("Hall1Period3", period3, hall1, 0);
    public SupervisionDuty Hall1Period4 = new SupervisionDuty("Hall1Period4", period4, hall1, 0);
    public SupervisionDuty Hall2Period2 = new SupervisionDuty("Hall2Period2", period2, hall2, 0);
    public OnCallDuty teach4FillIn = new OnCallDuty("teach4FillIn", period4, new Location("Teach4 class", "Teach4's period4 class supervision"), new Date(123, 0, 4));

    public ArrayList<Teacher> teachers = new ArrayList<>(Arrays.asList(teach1, teach2, teach3, teach4));
    public ArrayList<Location> locations = new ArrayList<>(Arrays.asList(cafeteria, hall1, hall2, buses));
    public ArrayList<Time> times = new ArrayList<>(Arrays.asList(beforeSchool, period1, period2, lunch, period3, period4, afterSchool));
    public ArrayList<SupervisionDuty> supervisionDuties = new ArrayList<>(Arrays.asList(morningBus, afternoonBus, cafeteriaDuty, Hall1Period1, Hall1Period2, Hall1Period3, Hall1Period4, Hall2Period2));
    public ArrayList<OnCallDuty> onCallDuties = new ArrayList<>(Arrays.asList(teach4FillIn));
    public ArrayList<Restriction> restrictions = new ArrayList<>(Arrays.asList(teach2Restrict, Teach4Restrict));


    public GeneratorTester() {
        teach2.addRestriction(teach2Restrict);
        teach4.addRestriction(Teach4Restrict);

        SupervisionGenerator supervisionGenerator = new SupervisionGenerator(supervisionDuties, teachers, 0);
        HashMap<SupervisionDuty, Teacher> assignedSupervisionDuties = supervisionGenerator.generate();

        ArrayList<Teacher> assignedTeachers = new ArrayList<>();
        for (SupervisionDuty name: assignedSupervisionDuties.keySet()) {
            assignedTeachers.add(assignedSupervisionDuties.get(name));
        }

        OnCallGenerator onCallGenerator = new OnCallGenerator(onCallDuties, teachers, assignedTeachers);
        HashMap<OnCallDuty, Teacher> assignedOnCallDuties = onCallGenerator.generate();
        for (SupervisionDuty name: assignedSupervisionDuties.keySet()) {

            assignedTeachers.add(assignedSupervisionDuties.get(name));
        }
    }

    public static void main(String[] args) {
        new GeneratorTester();
    }
}
