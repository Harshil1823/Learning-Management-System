import java.util.ArrayList;

public class Course {
    private String author;
    private String title;
    private String description;
    private String userID;
    private String courseID;
    private String difficulty;
    private ArrayList<Module> modules;
    private ArrayList<Review> reviews;
    private ArrayList<CourseGrade> courseGrades;
    private ArrayList<Comment> courseComments;

    public Course(String author, String title, String description, String userID, String courseID, String difficulty,
            ArrayList<Module> modules, ArrayList<Review> reviews, ArrayList<CourseGrade> courseGrades,
            ArrayList<Comment> courseComments) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.courseID = courseID;
        this.difficulty = difficulty;
        this.modules = modules != null ? modules : new ArrayList<Module>();
        this.reviews = reviews != null ? reviews : new ArrayList<Review>();
        this.courseGrades = courseGrades != null ? courseGrades : new ArrayList<CourseGrade>();
        this.courseComments = courseComments != null ? courseComments : new ArrayList<Comment>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addCourseGrade(CourseGrade grade) {
        courseGrades.add(grade);
    }

    public void addComment(Comment comment) {
        courseComments.add(comment);
    }

    public void viewModules() {
        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }

    public void viewReviews() {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

    public void viewGrades() {
        for (CourseGrade grade : courseGrades) {
            System.out.println(grade.toString());
        }
    }

    public String getAuthor() {
        return author;
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
        return "Course [courseId=" + courseID + ", title=" + title + ", description=" + description + ", modules="
                + modules + ", reviews=" + reviews + ", courseGrades=" + courseGrades + ", difficulty=" + difficulty
                + ", courseComments=" + courseComments + "]";
    }
}
