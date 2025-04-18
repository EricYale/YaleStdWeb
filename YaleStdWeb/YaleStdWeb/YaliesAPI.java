package YaleStdWeb;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import YaleStdWeb.json.*;
import java.net.URI;

public class YaliesAPI {
    private String apiKey;
    private final String BASE_URL = "https://api.yalies.io/v2/";
    
    public YaliesAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public ArrayList<YaliesPerson> performPeopleSearch(YaliesFilter filter) {
        HttpURLConnection connection;
        try {
            URI uri = new URI(BASE_URL + "people");
            connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setDoOutput(true);

            String requestBody = constructBody(filter).toString();
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(requestBody);
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error response from Yalies API: " + responseCode);
                return null;
            }
            String response = new String(connection.getInputStream().readAllBytes());
            return parseResponseData(response);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject constructBody(YaliesFilter filter) {
        JSONObject body = new JSONObject();
        if(filter.getQuery() != null) {
            body.put("query", filter.getQuery());
        }
        body.put("filters", filter.toJsonObject());
        body.put("page", 0);
        body.put("page_size", 100);
        return body;
    }

    public ArrayList<YaliesPerson> parseResponseData(String response) {
        ArrayList<YaliesPerson> people = new ArrayList<>();
        JSONArray peopleArray = new JSONArray(response);
        for(int i = 0; i < peopleArray.length(); i++) {
            JSONObject personJson = peopleArray.getJSONObject(i);
            YaliesPerson person = new YaliesPerson(
                personJson.has("netid") ? personJson.getString("netid") : null,
                personJson.has("email") ? personJson.getString("email") : null,
                personJson.has("first_name") ? personJson.getString("first_name") : null,
                personJson.has("last_name") ? personJson.getString("last_name") : null,
                personJson.has("school") ? personJson.getString("school") : null,
                personJson.has("year") ? personJson.getInt("year") : 0,
                personJson.has("college") ? personJson.getString("college") : null,
                personJson.has("major") ? personJson.getString("major") : null,
                personJson.has("birth_day") ? personJson.getInt("birth_day") : 0,
                personJson.has("birth_month") ? personJson.getInt("birth_month") : 0
            );
            people.add(person);
        }
        return people;
    }
}
