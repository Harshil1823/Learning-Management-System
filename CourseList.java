import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;

/**
 * @author JavaDoc
 *         Handles CourseList operations.
 */
public class CourseList {
    private static Scanner keyboard = new Scanner(System.in);
    private static CourseList courseList;
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * Constructor to initialize course list.
     */
    CourseList() {
    }

    /**
     * Returns instance of course list.
     * 
     * @return Either new instance or previous instance of course list.
     */
    public static CourseList getInstance() {
        if (courseList == null)
            return new CourseList();
        return courseList;
    }

    /**
     * checks if it's in bounds and userCan
     * choose a couse
     * 
     * @param index
     * @return
     */
    public Course getCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        }
        return null;
    }

    /**
     * Add course to course list.
     * 
     * @param course Type Course to add.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Returns course by title. If not found returns null.
     * 
     * @param title Course title to search for.
     * @return Course with same title. Otherwise null.
     */
    public Course getCourseByTitle(String title) {
        for (Course course : courses)
            if (title.equalsIgnoreCase(course.getTitle()))
                return course;
        return null;

    }

    /**
     * Delete course from list.
     * 
     * @param course Type Course to delete.
     */
    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    /**
     * Save course list to datawriter.
     */
    public void save() {
        DataWriter writer = new DataWriter();
        DataWriter.saveCourses(courses);
    }

    /**
     * Displays courses in list.
     */
    public void viewCourses() {
        int i = 1;
        for (Course course : courses){
            System.out.println(i + ". ");
            System.out.println(course.getTitle());
        }
    }

    /**
     * Enrolls the user in course using the title of the course
     * if the user is already enrolled then it checks for it
     * if course isn't valid then it says course not found
     * 
     * @param user  - takes the user object
     * @param title - takes the title of the course and checks if it's in course
     *              list
     * @return - true if the user is enrolled and false if not
     */
    public boolean enrollInCourse(User user) {
        viewCourses();
        System.out.println("Please enter course title to enroll in.");
        String title = keyboard.nextLine();
        
        Course course = getCourseByTitle(title);
        if (course == null) {
            System.out.println("Course not found.");
            return false;
        }
        if (user.getCourses().contains(course)) {
            System.out.println("You are already enrolled in this course.");
            return false;
        }
        user.addCourse(course);
        System.out.println("You have successfully enrolled in " + course.getTitle() + ".");
        return true;
    }

    public Course createCourse(User user) {

        System.out.println("Please enter the title of the course.");
        String title = keyboard.next();

        System.out.println("Please enter the description of the course.");
        String description = keyboard.nextLine();
        keyboard.nextLine();

        System.out.println("Please enter the difficulty of the course.");
        String difficulty = keyboard.next();

        boolean moduleLoop = true;
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Topic> topics;
        ArrayList<Question> question_arr;
        Module module;
        while (moduleLoop) {
            moduleLoop = false;
            System.out.println("Would you like to create a module. \"Y\" to create module. Otherwise, \"N\"");
            String choice = keyboard.next();
            keyboard.nextLine();
            topics = new ArrayList<>();
            question_arr = new ArrayList<>();
            String module_title = "";
            String module_description = "";

            // if creating module
            if (choice.equalsIgnoreCase("y")) {

                System.out.println("Please enter the title of module.");
                module_title = keyboard.nextLine();

                System.out.println("Please enter the description of module.");
                module_description = keyboard.nextLine();

                System.out.println("How many topic(s) will be in this module?");
                int topic_count = keyboard.nextInt();
                keyboard.nextLine();

                // topic creation
                for (int i = 1; i <= topic_count; i++) {
                    System.out.println("Please enter the topic title for topic " + i + ".");
                    String topic_title = keyboard.nextLine();

                    System.out.println("Please enter the topic description for topic " + i + ".");
                    String topic_description = keyboard.nextLine();

                    Topic topic = new Topic(topic_title, topic_description);
                    topics.add(topic);
                }

                moduleLoop = true;

                System.out.println("How many questions would you like to add to module?");
                int questions = keyboard.nextInt();
                keyboard.nextLine();

                String questionText = "";
                int correct = 0;
                ArrayList<String> choice_arr = new ArrayList<>();

                for (int i = 1; i <= questions; i++) {
                    // question creation
                    System.out.println("Please enter a question " + i + " for module.");
                    questionText = keyboard.nextLine();

                    System.out.println("How many choices do you want for this question?");
                    int choices = keyboard.nextInt();
                    keyboard.nextLine();

                    for (int j = 1; j <= choices; j++) {
                        System.out.println("Please enter choice " + j);
                        choice_arr.add(keyboard.nextLine());
                    }

                    System.out.println("Which number choice is correct choice?");
                    correct = keyboard.nextInt();
                    keyboard.nextLine();

                    Question question = new Question(questionText, choice_arr, correct - 1);
                    question_arr.add(question);

                }

                module = new Module(module_title, module_description, topics, question_arr,
                        new ArrayList<Comment>(), new ArrayList<ModuleGrade>());
                modules.add(module);
            }

        }
        ArrayList<Review> reviews = new ArrayList<>();
        ArrayList<CourseGrade> courseGrades = new ArrayList<>();
        // module creation!!!

        // created course
        Course course = new Course(user.getFirstName() + " " + user.getLastName(), title, description, user.getUserID(),
                UUID.randomUUID().toString(), difficulty, modules, reviews, courseGrades);
        return course;
    }

    /**
     * Allow for user to edit a course.
     */
    public void editCourse() {
        System.out.println("Which course would you like to edit? (Enter number)");

        for (int i = 1; i <= courses.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(courses.get(i-1).getTitle());
        }

        int choice = keyboard.nextInt();
        keyboard.nextLine();
        Course edit_course = courses.get(choice-1);

        System.out.println("How would you like to edit this course? (Enter number)");
        System.out.println("1. Edit module");
        System.out.println("2. Remove module");
        System.out.println("3. Add module");

        Module edit_module;
        choice = keyboard.nextInt();

        // MODULE EDITING CHOICE
        if (choice == 1) {
            System.out.println("Which module would you like to choose from?");

            for (int i = 1; i <= edit_course.getModules().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(edit_course.getModules().get(i-1).getTitle());
            }

            choice = keyboard.nextInt();
            keyboard.nextLine();

            // module to edit
            edit_module = edit_course.getModules().get(choice - 1);

            System.out.println("How would you like to edit this module?");
            System.out.println("1. Add question");
            System.out.println("2. Add topic");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            String questionText = "";
            int correct = 0;
            ArrayList<String> choice_arr = new ArrayList<>();

            // add question
            if (choice == 1) {
                // question creation
                System.out.println("Please enter a question for module.");
                questionText = keyboard.nextLine();

                System.out.println("How many choices do you want for this question?");
                int choices = keyboard.nextInt();
                keyboard.nextLine();

                for (int j = 1; j <= choices; j++) {
                    System.out.println("Please enter choice " + j);
                    choice_arr.add(keyboard.nextLine());
                }

                System.out.println("Which number choice is correct choice?");
                correct = keyboard.nextInt();
                keyboard.nextLine();

                Question question = new Question(questionText, choice_arr, correct - 1);
                edit_module.addQuestion(question);

                System.out.println("Question added!");

            }

            else if (choice == 2) {
                // topic creation
                ArrayList<Topic> topics = new ArrayList<>();
                System.out.println("Please enter the topic title for topic.");
                String topic_title = keyboard.nextLine();

                System.out.println("Please enter the topic description for topic.");
                String topic_description = keyboard.nextLine();

                Topic topic = new Topic(topic_title, topic_description);
                topics.add(topic);
            } else {
                System.out.println("Invalid choice.");
                return;
            }
        }
        // module remove
        else if (choice == 2) {
            System.out.println("Which module would you like remove? (Enter number)");

            for (int i = 1; i <= edit_course.getModules().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(edit_course.getModules().get(i-1).getTitle());
            }

            int module_choice = keyboard.nextInt();
            keyboard.nextLine();

            edit_course.getModules().remove(module_choice-1);
            System.out.println("Module removed");
        }
        // module adding
        else if (choice == 3) {

            System.out.println("Please enter the title of module.");
            String module_title = keyboard.nextLine();

            System.out.println("Please enter the description of module.");
            String module_description = keyboard.nextLine();

            System.out.println("How many topic(s) will be in this module?");
            int topic_count = keyboard.nextInt();
            keyboard.nextLine();

            ArrayList<Topic> topics = new ArrayList<>();
            // topic creation
            for (int i = 1; i <= topic_count; i++) {
                System.out.println("Please enter the topic title for topic " + i + ".");
                String topic_title = keyboard.nextLine();

                System.out.println("Please enter the topic description for topic " + i + ".");
                String topic_description = keyboard.nextLine();

                Topic topic = new Topic(topic_title, topic_description);
                topics.add(topic);
            }

            System.out.println("How many questions would you like to add to module?");
            int questions = keyboard.nextInt();
            keyboard.nextLine();

            String questionText = "";
            int correct = 0;
            ArrayList<String> choice_arr = new ArrayList<>();
            ArrayList<Question> question_arr = new ArrayList<>();
            for (int i = 1; i <= questions; i++) {
                // question creation
                System.out.println("Please enter a question " + i + " for module.");
                questionText = keyboard.nextLine();

                System.out.println("How many choices do you want for this question?");
                int choices = keyboard.nextInt();
                keyboard.nextLine();

                for (int j = 1; j <= choices; j++) {
                    System.out.println("Please enter choice " + j);
                    choice_arr.add(keyboard.nextLine());
                }

                System.out.println("Which number choice is correct choice?");
                correct = keyboard.nextInt();
                keyboard.nextLine();

                Question question = new Question(questionText, choice_arr, correct - 1);
                question_arr.add(question);

            }

            Module module = new Module(module_title, module_description, topics, question_arr,
                    new ArrayList<Comment>(), new ArrayList<ModuleGrade>());
            edit_course.getModules().add(module);
        }
        else{
            System.out.println("Invalid choice");
            return;
        }
    }
    
    public void displayEnrolledCourses(User user){
        if(user.getCourses().size() <= 0)
            System.out.println("You aren't enrolled in any courses");
        else
            for(int i = 1; i <= user.getCourses().size(); i ++){
                System.out.println(i + ". ");
                System.out.println(user.getCourses().get(i-1).getTitle());
            }     
    }

    //ADDS COMMENT
    public void courseComment(User user){
        System.out.println("Which course would you like to comment on?");
        viewCourses();

        int choice = keyboard.nextInt();
        keyboard.nextLine();


        System.out.println("Please enter your comment.");
        String reply = keyboard.nextLine();
        Comment comment = new Comment(user.getFirstName() + " " + user.getLastName(), reply);
        courses.get(choice - 1).addComment(comment);
        System.out.println("Comment added");
    }

    //ADDS REVIEW
    public void courseReview(User user){
        System.out.println("Which course would you like to leave a review on?");
        viewCourses();

        int choice = keyboard.nextInt();
        keyboard.nextLine();


        System.out.println("Please enter rating 1 - 10 of course.");
        String rating = keyboard.next();
        keyboard.nextLine();

        System.out.println("Please enter the reason behind this rating.");
        String text = keyboard.nextLine();

        Review review = new Review(user.getUserID(), text, rating, LocalDate.now().toString());

        courses.get(choice - 1).addReview(review);
        System.out.println("Review added");
    }
}
