package examples;
import java.util.ArrayList;
import java.util.Scanner;
import YaleStdWeb.*;

public class CoursetableExample {
    public static void main(String[] args) {
        CoursetableAPI api = new CoursetableAPI();

        CoursetableCourse myCourse = api.getCourseByName("Introduction to Programming");
        System.out.println("Course Code: " + myCourse.getCourseCode());
        System.out.println("Title: " + myCourse.getTitle());
        System.out.println("Professor: " + myCourse.getProfessor());
        System.out.println("----------------------------");

        ArrayList<CoursetableCourse> courses = api.getFall25Courses();
        for(CoursetableCourse course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Professor: " + course.getProfessor());
            System.out.println("----------------------------");
        }
    }
}
