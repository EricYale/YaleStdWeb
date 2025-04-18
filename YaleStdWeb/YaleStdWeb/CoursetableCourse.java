package YaleStdWeb;

public class CoursetableCourse {
    public String courseCode;
    public String title;
    public String professor;

    public CoursetableCourse(String courseCode, String title, String professor) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public String getProfessor() { return professor; }
}
