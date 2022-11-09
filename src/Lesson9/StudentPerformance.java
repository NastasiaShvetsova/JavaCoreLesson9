package Lesson9;

import java.util.ArrayList;
import java.util.List;

public class StudentPerformance implements Student {
    private final String surname;
    private final List<Course> courses;

    public StudentPerformance(String surname, List<Course> courses) {
        this.surname = surname;
        this.courses = courses == null ? new ArrayList<>(0): courses;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
    @Override
    public String toString() {
        return surname;
    }
}
