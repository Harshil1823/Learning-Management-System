import java.util.ArrayList;

public class Course {
    private String courseId;
    private String title;
    private String description;
    private String userID; 
    private ArrayList<Module> modules;
    private ArrayList<Review> reviews;
    private ArrayList<CourseGrade> courseGrades;
    private String difficulty;
    private ArrayList<Comment> courseComments;

    public Course(String courseId, String title, String description, String userID, ArrayList<Module> modules,
            ArrayList<Review> reviews, ArrayList<CourseGrade> courseGrades, String difficulty) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.modules = modules != null ? modules : new ArrayList<Module>();
        this.reviews = reviews != null ? reviews : new ArrayList<Review>();
        this.courseGrades = courseGrades != null ? courseGrades : new ArrayList<CourseGrade>();
        this.difficulty = difficulty;
        this.courseComments = new ArrayList<Comment>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void viewReviews() {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addCourseGrade(CourseGrade grade) {
        courseGrades.add(grade);
    }

    public void showModules() {
        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }

    public void addComment(Comment comment) {
        courseComments.add(comment);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    public ArrayList<Comment> getCourseComments() {
        return courseComments;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", title=" + title + ", description=" + description + ", modules="
                + modules + ", reviews=" + reviews + ", courseGrades=" + courseGrades + ", difficulty=" + difficulty
                + ", courseComments=" + courseComments + "]";
    }
}
