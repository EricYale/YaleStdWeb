package examples;
import java.util.ArrayList;
import java.util.Scanner;
import YaleStdWeb.*;

public class YaliesExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Yalies API key: ");
        String apiKey = scanner.nextLine();

        YaliesAPI api = new YaliesAPI(apiKey);
        YaliesFilter filter = new YaliesFilter();
        filter.setQuery("Eric");
        filter.setSchoolFilter("Yale College");
        filter.setYearFilter(new int[] { 2025, 2026, 2027 });

        ArrayList<YaliesPerson> results = api.performPeopleSearch(filter);
        for(YaliesPerson person : results) {
            System.out.println("\nName: " + person.getFirstName() + " " + person.getLastName());
            System.out.println("College: " + person.getCollege());
            System.out.println("Year: " + person.getYear());
        }
    }
}
