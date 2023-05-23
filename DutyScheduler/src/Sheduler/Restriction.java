package Sheduler;

import java.util.Date;

/**
 * The type Restriction. TODO: Add description
 *
 * @author: Griffin Robinson
 * @date: 2023 -05-18
 * @File: Restriction
 */
public class Restriction {//todo: Error Trapping/Handling
    private Teacher teacher;
    private String description;
    private Date date;
    private Time time;

    public Restriction(Teacher teacher, String description, Date date, Time time) {
        this.teacher = teacher;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


}
