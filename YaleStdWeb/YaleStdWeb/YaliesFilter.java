package YaleStdWeb;

import YaleStdWeb.json.*;

public class YaliesFilter {
    private String query;
    private String[] netid;
    private String[] email;
    private String[] firstName;
    private String[] lastName;
    private String[] school;
    private int[] year;
    private String[] college;
    private String[] major;
    private int[] birthDay;
    private int[] birthMonth;

    public YaliesFilter() {
        this.query = null;
        this.netid = null;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.year = null;
        this.college = null;
        this.major = null;
        this.birthDay = null;
        this.birthMonth = null;
    }

    public JSONObject toJsonObject() {
        JSONObject filters = new JSONObject();
        if (netid != null) filters.put("netid", netid);
        if (email != null) filters.put("email", email);
        if (firstName != null) filters.put("first_name", firstName);
        if (lastName != null) filters.put("last_name", lastName);
        if (school != null) filters.put("school", school);
        if (year != null) filters.put("year", year);
        if (college != null) filters.put("college", college);
        if (major != null) filters.put("major", major);
        if (birthDay != null) filters.put("birth_day", birthDay);
        if (birthMonth != null) filters.put("birth_month", birthMonth);
        return filters;
    }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
    public void setNetidFilter(String[] netid) { this.netid = netid; }
    public void setNetidFilter(String netid) { this.netid = new String[]{netid}; }
    public void setEmailFilter(String[] email) { this.email = email; }
    public void setEmailFilter(String email) { this.email = new String[]{email}; }
    public void setFirstNameFilter(String[] first_name) { this.firstName = first_name; }
    public void setFirstNameFilter(String first_name) { this.firstName = new String[]{first_name}; }
    public void setLastNameFilter(String[] last_name) { this.lastName = last_name; }
    public void setLastNameFilter(String last_name) { this.lastName = new String[]{last_name}; }
    public void setSchoolFilter(String[] school) { this.school = school; }
    public void setSchoolFilter(String school) { this.school = new String[]{school}; }
    public void setYearFilter(int[] year) { this.year = year; }
    public void setYearFilter(int year) { this.year = new int[]{year}; }
    public void setCollegeFilter(String[] college) { this.college = college; }
    public void setCollegeFilter(String college) { this.college = new String[]{college}; }
    public void setMajorFilter(String[] major) { this.major = major; }
    public void setMajorFilter(String major) { this.major = new String[]{major}; }
    public void setBirthDayFilter(int[] birth_day) { this.birthDay = birth_day; }
    public void setBirthDayFilter(int birth_day) { this.birthDay = new int[]{birth_day}; }
    public void setBirthMonthFilter(int[] birth_month) { this.birthMonth = birth_month; }
    public void setBirthMonthFilter(int birth_month) { this.birthMonth = new int[]{birth_month}; }
}