import java.io.FileReader;
import java.security.Key;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {
    public static ArrayList<User> user = new ArrayList<User>();

    public ArrayList<User> getUsers(){
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser(); 
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for(int i = 0; i < usersJSON.size(); i++ ){
                JSONObject userJSON = (JSONObject) usersJSON.get(i);

                String userID = (String) userJSON.get(USER_ID);
                String uFirstName = (String) userJSON.get(USER_FIRST_NAME);
                String uLastName = (String) userJSON.get(USER_LAST_NAME);
                String userEmail = (String) userJSON.get(USER_EMAIL);
                String uPhoneNumber = (String) userJSON.get(USER_PHONENUMBER);
                String userName = (String) userJSON.get(USER_USERNAME);
                String uPassword = (String) userJSON.get(USER_PASSWORD);
                String isUser = (String) userJSON.get(IS_USER);

                
                user.add(new User());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

  
    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONObject coursesJSON = (JSONObject) parser.parse(reader);
            JSONArray coursesArray = (JSONArray) coursesJSON.get("courses");
    
            for(int i = 0; i < coursesArray.size(); i++ ){
                JSONObject courseJSON = (JSONObject) coursesArray.get(i);
    
                String courseId = (String) courseJSON.get("courseid");
                String title = (String) courseJSON.get("title");
                String description = (String) courseJSON.get("description");
                String user_Id = (String) courseJSON.get("user_id");
                String difficulty = (String) courseJSON.get("difficulty");
    
                JSONArray modulesJSON = (JSONArray) courseJSON.get("modules");
                ArrayList<Module> modules = new ArrayList<Module>();
                for(int j = 0; j < modulesJSON.size(); j++) {
                    JSONObject moduleJSON = (JSONObject) modulesJSON.get(j);
                    String moduleTitle = (String) moduleJSON.get("title");
                    String moduleDescription = (String) moduleJSON.get("description");
    
                    JSONArray topicsJSON = (JSONArray) moduleJSON.get("topics");
                    ArrayList<Topic> topics = new ArrayList<Topic>();
                    for(int k = 0; k < topicsJSON.size(); k++) {
                        JSONObject topicJSON = (JSONObject) topicsJSON.get(k);
                        String topicTitle = (String) topicJSON.get("title");
                        String topicDescription = (String) topicJSON.get("description");
                        topics.add(new Topic(topicTitle, topicDescription));
                    }
    
                    JSONArray questionsJSON = (JSONArray) moduleJSON.get("questions");
                    ArrayList<Question> questions = new ArrayList<Question>();
                    for(int k = 0; k < questionsJSON.size(); k++) {
                        JSONObject questionJSON = (JSONObject) questionsJSON.get(k);
                        String questionText = (String) questionJSON.get("questionText");
                        JSONArray choicesJSON = (JSONArray) questionJSON.get("choices");
                        ArrayList<String> choices = new ArrayList<String>();
                        for(int l = 0; l < choicesJSON.size(); l++) {
                            String choice = (String) choicesJSON.get(l);
                            choices.add(choice);
                        }
                        String correctChoice = (String) questionJSON.get("correctChoice");
                        questions.add(new Question(questionText, choices, correctChoice));
                    }
    
                    JSONArray commentsJSON = (JSONArray) moduleJSON.get("comments");
                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    for(int k = 0; k < commentsJSON.size(); k++) {
                        JSONObject commentJSON = (JSONObject) commentsJSON.get(k);
                        String userId = (String) commentJSON.get("user_id");
                        String text = (String) commentJSON.get("text");
                        comments.add(new Comment(userId, text));
                    }
    
                    modules.add(new Module(moduleTitle, moduleDescription, topics, questions, comments));
                }
    
                JSONArray reviewJSON = (JSONArray) courseJSON.get("review");
                ArrayList<Review> reviews = new ArrayList<Review>();
                for(int j = 0; j < reviewJSON.size(); j++) {
                    JSONObject reviewObj = (JSONObject) reviewJSON.get(j);
                    String userId = (String) reviewObj.get("user_id");
                    String text = (String) reviewObj.get("text");
                    double rating = (double) reviewObj.get("rating");
                    String date = (String) reviewObj.get("date");
                    reviews.add(new Review(userId, text, rating, date));
                }
    
                JSONArray courgradeJSON = (JSONArray) courseJSON.get("courgrade");
                ArrayList<CourseGrade> courseGrades = new ArrayList<CourseGrade>();
                for(int j=0;j<courgradeJSON.size();j++){
                    JSONObject courGradObject = (JSONObject) courgradeJSON.get(j);
                    String userID = (String) courGradObject.get("user_id");
                    String totalGrade = (String) courGradObject.get("totalGrade");
                    String course = (String) courGradObject.get("course");
                    courseGrades.add(new CourseGrade(userID,totalGrade,course));
                }
                Course course = new Course(courseId, title, description,user_Id, modules, reviews, courseGrades, difficulty);
                courses.add(course);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}