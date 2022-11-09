package Lesson9;

public class CoursePerformance implements Course {
    private final String nameCourse;

    public CoursePerformance(String nameCourse) {
        this.nameCourse = nameCourse;
    }
    @Override
    public String toString() {
        return nameCourse;
    }
}
