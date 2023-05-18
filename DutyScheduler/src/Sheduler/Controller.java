package Sheduler;

/**
 * @author: Griffin Robinson
 * @date: 2023-05-18
 * @File Name: Controller
 * @description: _______
 */
public class Controller {
    Config config;
    FileReader fileReader;
    FileWriter fileWriter;
    Generator generator;
    Teacher teacher;
    TeacherDuty teacherDuty;
    Duty duty;
    Time time;
    Location location;
    Restriction restriction;

    public static void main(String[] args) {
        Window window = new Window();
    }
}
