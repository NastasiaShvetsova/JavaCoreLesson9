package Lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course course1 = new CoursePerformance("SQL");
        Course course2 = new CoursePerformance("Java_Core");
        Course course3 = new CoursePerformance("QA");
        Course course4 = new CoursePerformance("Java");

        List<Student> students = Arrays.asList(
                new StudentPerformance("Ivanov", Arrays.asList(course1,course3, course2)),
                new StudentPerformance("Petrov", Arrays.asList(course3)),
                new StudentPerformance("Pavlov", Arrays.asList(course4, course1, course3)),
                new StudentPerformance("Svetikova", Arrays.asList(course3, course4)),
                new StudentPerformance("Lenina", null));

        System.out.println("Уникальные курсы: " + getUniqueCourses(students));
        System.out.println("Список из трех самых любознательных студентов: " + getInquisitiveStudent(students));
        System.out.println("Cписок студентов, которые посещают курс Java: " + getStudentsByCourses(students, course4));
    }
    public static List<Course> getUniqueCourses(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAllCourses)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        }
    public static List<Student> getInquisitiveStudent(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    List<Course> c1 = o1.getAllCourses();
                    List<Course> c2 = o2.getAllCourses();
                    return Integer.compare(
                            c2 == null ? 0 : c2.size(),
                            c1 == null ? 0 : c1.size()
                    );
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourses(List<Student> students, Course course) {
        if (course == null) {
            return new ArrayList<>();
        }

        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .filter(student -> {
                    List<Course> courses = student.getAllCourses();
                    courses = courses == null ? Collections.emptyList() : courses;
                    return courses.contains(course);
                })
                .collect(Collectors.toList());
    }
}


