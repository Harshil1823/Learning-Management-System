import java.util.ArrayList;

/**
 * @author JavaDoc
 * Represents a course module.
 */
public class Module {
    private String title;
    private String description;
    private ArrayList<Topic> topics;
    private ArrayList<Question> questions;
    private ArrayList<Comment> comments;
    private ArrayList<ModuleGrade> moduleGrades;

    /**
     * Constructor to initalize a module.
     * @param title        String of module title.
     * @param description  String of module description.
     * @param topics       ArrayList<Topic> of topics that module contains.
     * @param questions    ArrayList<Question> of questions that module contains.
     * @param comments     ArrayList<Comment> of comments about module.
     * @param moduleGrades ArrayList<ModuleGrade> containing grades of different
     *                     modules.
     */
    public Module(String title, String description, ArrayList<Topic> topics, ArrayList<Question> questions,
            ArrayList<Comment> comments, ArrayList<ModuleGrade> moduleGrades) {
        this.title = title;
        this.description = description;
        this.topics = topics;
        this.questions = questions;
        this.comments = comments;
        this.moduleGrades = moduleGrades;
    }

    /**
     * Returns title of module.
     * @return String of module title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns description of module.
     * @return String of module description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns module topics.
     * @return ArrayList<Topic> of module topics.
     */
    public ArrayList<Topic> getTopics() {
        return topics;
    }

    /**
     * Returns module questions.
     * @return ArrayList<Question> of module questions.
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Returns module comments.
     * @return ArrayList<Comment> of module comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Returns module grades.
     * @return ArrayList<ModuleGrade> of module grades.
     */
    public ArrayList<ModuleGrade> getModuleGrades() {
        return moduleGrades;
    }

    /**
     * Sets module title.
     * @param title String of module title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets module description.
     * @param description String of module description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets module topics.
     * @param topics ArrayList<Topic> of module topics.
     */
    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    /**
     * Sets module questions.
     * @param questions ArrayList<Question> of module questions.
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * Sets module comments.
     * @param comments ArrayList<Comment> of module coments.
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Sets module grades.
     * @param moduleGrades ArrayList<ModuleGrade> of module grades.
     */
    public void setModuleGrades(ArrayList<ModuleGrade> moduleGrades) {
        this.moduleGrades = moduleGrades;
    }

    /**
     * Adds comment to comment list.
     * @param comment Type Comment.
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Adds topic to topic list.
     * @param topic Type Topic.
     */
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    /**
     * Adds question to questions list.
     * @param question Type Question.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Adds module grade to moduleGrades list.
     * @param moduleGrade Type ModuleGrade
     */
    public void addModuleGrade(ModuleGrade moduleGrade) {
        moduleGrades.add(moduleGrade);
    }

    /**
     * Creates comment and adds to list.
     * @param userID String of user ID.
     * @param text String of the comment text.
     */
    public void addComment(String userID, String text) {
        Comment comment = new Comment(userID, text);
        addComment(comment);
    }

    /**
     * Creatss question and adds to list.
     * @param questionText String of question.
     * @param choices ArrayList<String> of choices.
     * @param correctChoice String of the correct choice.
     */
    public void addQuestion(String questionText, ArrayList<String> choices, int correctChoiceIndex) {
        Question question = new Question(questionText, choices, correctChoiceIndex);
        addQuestion(question);
    }

    /**
     * Creates moduleGrade and adds to list.
     * @param quiz String of quiz grade.
     * @param finalGrade String of final grade.
     */
    public void addModuleGrade(String quiz, String finalGrade) {
        ModuleGrade moduleGrade = new ModuleGrade(quiz, finalGrade);
        addModuleGrade(moduleGrade);
    }

    /**
     * Creates a topic and adds to list.
     * @param title String of topic title.
     * @param description String of topic description.
     */
    public void addTopic(String title, String description) {
        Topic topic = new Topic(title, description);
        addTopic(topic);
    }

    /**
     * Allows user to take the module quiz.
     * @return
     */
    public double takeQuiz(){
        double ret = 0;
        for(Question question : questions){
            if(question.answerQuestion()){
                ret += 1;
            }
        }
        ret = (double)questions.size() / ret;
        return ret;
    }

}
