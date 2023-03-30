import java.io.FileWriter;
import java.io.IOException;
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
            userObj.put(IS_AUTHOR, user.isAuthor());
            userArray.add(userObj);
        }
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(userArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray courseArray = new JSONArray();
        for (Course course : courses) {
            JSONObject courseObj = new JSONObject();
            courseObj.put("courseId", course.getCourseID());
            courseObj.put("title", course.getTitle());
            courseObj.put("description", course.getDescription());
            courseObj.put("userId", course.getUser_ID());
            courseObj.put("difficulty", course.getDifficulty());

            JSONArray moduleArray = new JSONArray();
            for (Module module : course.getModules()) {
                JSONObject moduleObj = new JSONObject();
                moduleObj.put("title", module.getTitle());
                moduleObj.put("description", module.getDescription());

                JSONArray topicArray = new JSONArray();
                for (Topic topic : module.getTopics()) {
                    JSONObject topicObj = new JSONObject();
                    topicObj.put("title", topic.getTitle());
                    topicObj.put("description", topic.getDescription());
                    topicArray.add(topicObj);
                }
                moduleObj.put("topics", topicArray);

                JSONArray questionArray = new JSONArray();
                for (Question question : module.getQuestions()) {
                    JSONObject questionObj = new JSONObject();
                    questionObj.put("questionText", question.getQuestionText());

                    JSONArray choicesArray = new JSONArray();
                    for (String choice : question.getChoices()) {
                        choicesArray.add(choice);
                    }
                    questionObj.put("choices", choicesArray);
                    questionObj.put("correctChoice", question.getCorrectChoice());
                    questionArray.add(questionObj);
                }
                moduleObj.put("questions", questionArray);

                JSONArray commentsArray = new JSONArray();
                for (Comment comment : module.getComments()) {
                    JSONObject commentObj = new JSONObject();
                    commentObj.put("userId", comment.getUserID());
                    commentObj.put("text", comment.getText());
                    commentsArray.add(commentObj);
                }
                moduleObj.put("comments", commentsArray);
                /* 
                JSONArray moduleGradeArray = new JSONArray();
                moduleGradeArray = module.getModuleGrade()
                for (ModuleGrade moduleGrade : module.getModuleGrade()) {
                    JSONObject moduleGradeObj = new JSONObject();
                    moduleGradeObj.put("quiz", moduleGrade.getQuizzes());
                    moduleGradeObj.put("finalGrade", moduleGrade.getFinalGrade());
                    moduleGradeArray.add(moduleGradeObj);
                }
                moduleObj.put("moduleGrades", moduleGradeArray);

                moduleArray.add(moduleObj);
                */
            }
            courseObj.put("modules", moduleArray);

            JSONArray reviewArray = new JSONArray();
            for (Review review : course.getReviews()) {
                JSONObject reviewObj = new JSONObject();
                reviewObj.put("userId", review.getUserID());
                reviewObj.put("text", review.getText());
                reviewObj.put("rating", review.getRating());
                reviewArray.add(reviewObj);
            }
            courseObj.put("reviews", reviewArray);

            courseArray.add(courseObj);
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            file.write(courseArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}