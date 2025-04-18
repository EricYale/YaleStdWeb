package YaleStdWeb;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;

import YaleStdWeb.json.JSONArray;
import YaleStdWeb.json.JSONObject;

public class CoursetableAPI {
    private final String BASE_URL = "https://api.coursetable.com/ferry/v1/graphql";

    public ArrayList<CoursetableCourse> getFall25Courses() {
        String query = """
                {
                    courses(where: {
                        season_code: { _eq: \\"202503\\" }
                    }) {
                        title
                        course_professors {
                            professor {
                                name
                            }
                        }
                        listings {
                            course_code
                            section
                        }
                    }
                }
                """;
        String body = "{\"query\":\"" + query.replace("\n", "") + "\"}";
        HttpURLConnection connection;
        try {
            URI uri = new URI(BASE_URL);
            connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(body); // query without whitespace
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error response from Coursetable API: " + responseCode);
                return null;
            }
            String response = new String(connection.getInputStream().readAllBytes());
            return parseResponseData(response);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CoursetableCourse getCourseByName(String name) {
        String query = """
                {
                    courses(where: {
                        season_code: { _eq: \\"202503\\" },
                        title:{_eq:\\"
        """
        + name +
        """
                \\"}
                    }) {
                        title
                        course_professors {
                            professor {
                                name
                            }
                        }
                        listings {
                            course_code
                            section
                        }
                    }
                }
                """;
        String body = "{\"query\":\"" + query.replace("\n", "") + "\"}";
        HttpURLConnection connection;
        try {
            URI uri = new URI(BASE_URL);
            connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(body); // query without whitespace
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error response from Coursetable API: " + responseCode);
                return null;
            }
            String response = new String(connection.getInputStream().readAllBytes());
            ArrayList<CoursetableCourse> res = parseResponseData(response);
            if(res.size() > 0) {
                return res.get(0);
            }
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CoursetableCourse> parseResponseData(String response) {
        JSONObject responseJson = new JSONObject(response);
        JSONObject data = responseJson.getJSONObject("data");
        JSONArray coursesArray = data.getJSONArray("courses");

        ArrayList<CoursetableCourse> courses = new ArrayList<>();

        for(int i = 0; i < coursesArray.length(); i++) {
            JSONObject courseJson = coursesArray.getJSONObject(i);
            String title = courseJson.getString("title");

            JSONArray professorsArray = courseJson.getJSONArray("course_professors");
            String professorName = professorsArray.length() > 0 ? professorsArray.getJSONObject(0).getJSONObject("professor").getString("name") : "Unknown";

            JSONArray listingsArray = courseJson.getJSONArray("listings");
            String courseCode = listingsArray.length() > 0 ? listingsArray.getJSONObject(0).getString("course_code") : "Unknown";

            CoursetableCourse course = new CoursetableCourse(courseCode, title, professorName);
            courses.add(course);
        }
        return courses;
    }
}
