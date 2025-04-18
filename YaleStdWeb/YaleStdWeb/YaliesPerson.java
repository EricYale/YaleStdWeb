package YaleStdWeb;

public class YaliesPerson {
    private String netid;
    private String email;
    private String firstName;
    private String lastName;
    private String school;
    private int year;
    private String college;
    private String major;
    private int birthDay;
    private int birthMonth;

    public YaliesPerson(
        String netid,
        String email,
        String firstName,
        String lastName,
        String school,
        int year,
        String college,
        String major,
        int birthDay,
        int birthMonth
    ) {
        this.netid = netid;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.year = year;
        this.college = college;
        this.major = major;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
    }

    public String getNetid() { return netid; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSchool() { return school; }
    public int getYear() { return year; }
    public String getCollege() { return college; }
    public String getMajor() { return major; }
    public int getBirthDay() { return birthDay; }
    public int getBirthMonth() { return birthMonth; }
}
