import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    private static final Object MODULE_QUESTIONS = null;
    private static final Object MODULE_TITLE = null;
    public void saveUsers(ArrayList<User> users) {
        JSONArray userArray = new JSONArray();
        for (User user : users) {
            JSONObject userObj = new JSONObject();
            userObj.put(USER_ID, user.getUserID());
            userObj.put(USER_FIRST_NAME, user.getFirstName());
            userObj.put(USER_LAST_NAME, user.getLastName());
            userObj.put(USER_EMAIL, user.getEmail());
            userObj.put(USER_PHONENUMBER, user.getPhoneNumber());
            userObj.put(USER_USERNAME, user.getUserName());
            userObj.put(USER_PASSWORD, user.getPassword());
            userObj.put(IS_AUTHOR, user.getIsAuthor());
            userArray.add(userObj);
        }
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(userArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveCourses(ArrayList<Course> courses) {
        JSONArray courseArray = new JSONArray();
        for (Course course : courses) {
            JSONObject courseObj = new JSONObject();
            courseObj.put(COURSE_ID, course.getCourseId());
            courseObj.put(COURSE_TITLE, course.getTitle());
            courseObj.put(COURSE_DESCRIPTION, course.getDescription());
            courseObj.put(USER_ID, course.getUser_Id());
            courseObj.put(DIFFICULTY, course.getDifficulty());
            courseObj.put(IS_AUTHOR, course.getIsAuthor());
    
            JSONArray moduleArray = new JSONArray();
            for (Module module : course.getModules()) {
                JSONObject moduleObj = new JSONObject();
                moduleObj.put(MODULE_TITLE, module.getTitle());
                moduleObj.put(MODULE_DESCRIPTION, module.getDescription());
    
                JSONArray topicArray = new JSONArray();
                for (Topic topic : module.getTopics()) {
                    JSONObject topicObj = new JSONObject();
                    topicObj.put(TOPIC_TITLE, topic.getTitle());
                    topicObj.put(TOPIC_DESCRIPTION, topic.getDescription());
                    topicArray.add(topicObj);
                }
                moduleObj.put(MODULE_TOPIC, topicArray);
    
                JSONArray questionArray = new JSONArray();
                for (Question question : module.getQuestions()) {
                    JSONObject questionObj = new JSONObject();
                    questionObj.put(QUESTION_TEXT, question.getQuestionText());
    
                    JSONArray choicesArray = new JSONArray();
                    for (String choice : question.getChoices()) {
                        choicesArray.add(choice);
                    }
                    questionObj.put(QUESTION_CHOICES, choicesArray);
                    questionObj.put(CORRECT_CHOICE, question.getCorrectChoice());
                    questionArray.add(questionObj);
                }
                moduleObj.put(MODULE_QUESTIONS, questionArray);
    
                JSONArray commentsArray = new JSONArray();
                for (Comment comment : module.getComments()) {
                    JSONObject commentObj = new JSONObject();
                    commentObj.put(USER_ID, comment.getUserID());
                    commentObj.put(COMMENT_TEXT, comment.getText());
                    commentsArray.add(commentObj);
                }
                moduleObj.put(MODULE_COMMENTS, commentsArray);
    
                JSONArray moduleGradeArray = new JSONArray();
                for (ModuleGrade moduleGrade : module.getModuleGrades()) {
                    JSONObject moduleGradeObj = new JSONObject();
                    moduleGradeObj.put(GRADE1, moduleGrade.getGrade1());
                    moduleGradeObj.put(GRADE2, moduleGrade.getGrade2());
                    moduleGradeArray.add(moduleGradeObj);
                }
                moduleObj.put(MODULE_GRADE, moduleGradeArray);
    
                moduleArray.add(moduleObj);
            }
            courseObj.put(COURSE_MODULE, moduleArray);
    
            JSONArray reviewArray = new JSONArray();
            for (Review review : course.getReviews()) {
                JSONObject reviewObj = new JSONObject();
                reviewObj.put(USER_ID, review.getUserID());
                reviewObj.put(REVIEW_TEXT, review.getText());
                reviewObj.put(RATING, review.getRating());
                reviewArray.add(reviewObj);
            }
            courseObj.put(COURSE_REVIEWS, reviewArray);
    
            courseArray.add(courseObj);
        }
        try (FileWriter file = new FileWriter(DATA_FILE)) {
            file.write(courseArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}