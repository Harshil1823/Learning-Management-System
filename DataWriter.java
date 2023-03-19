import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataWriter extends DataConstants {

    public void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userArray = UserList.getUser(null);
        JSONArray jsonUser = new JSONArray();

        for (int i = 0; i < userArray.size(); i++) {
            jsonUser.add(getUserJSON(userArray.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUser.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getUserID());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PHONENUMBER, user.getPhoneNumber());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }

    public void saveCourses() {
        JSONArray jsonCourses = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(COURSE_FILE_NAME));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray courses = (JSONArray) jsonObject.get("courses");
            for (int i = 0; i < courses.size(); i++) {
                jsonCourses.add(courses.get(i));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("courses", jsonCourses);
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
