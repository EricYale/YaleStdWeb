package YaleStdWeb;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class YaliesAPI {
    private String apiKey;
    private final String BASE_URL = "https://api.yalies.io/v2/";
    
    public YaliesAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public ArrayList<YaliesPerson> performPeopleSearch(String query, ) {
        URL url = new URL(BASE_URL + "people");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
    }

    public ArrayList<YaliesPerson> getAllPeople() {

    }
}
