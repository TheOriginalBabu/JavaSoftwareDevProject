package Sheduler;

/**
 * The type Teacher duty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: TeacherDuty
 */
public class TeacherDuty {//todo: Error Trapping/Handling
    private Teacher teacher;
    private Duty duty;

    /**
     * Constructor for TeacherDuty class.
     *
     * @param teacher The Teacher object for this duty.
     * @param duty    The Duty object for this duty.
     */
    public TeacherDuty(Teacher teacher, Duty duty) {
        this.teacher = teacher;
        this.duty = duty;
    }

    /**
     * Getter for teacher field.
     *
     * @return The Teacher object for this duty.
     */
    public Teacher getTeacher() {
        return this.teacher;
    }

    /**
     * Setter for teacher field.
     *
     * @param teacher The new Teacher object for this duty.
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Getter for duty field.
     *
     * @return The Duty object for this duty.
     */
    public Duty getDuty() {
        return this.duty;
    }

    /**
     * Setter for duty field.
     *
     * @param duty The new Duty object for this duty.
     */
    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    /**
     * Provides a string representation of the TeacherDuty object.
     *
     * @return String representation of the TeacherDuty object.
     */
    @Override
    public String toString() {
        return "TeacherDuty{" +
                "teacher=" + teacher +
                ", duty=" + duty +
                '}';
    }
}

