import java.util.ArrayList;

public class Module {
    private String title;
    private String description;
    private ArrayList<Topic> topics;
    private ArrayList<Question> questions;
    private ArrayList<Comment> comments;
    private ArrayList<ModuleGrade> moduleGrades;

    public Module(String title, String description, ArrayList<Topic> topics, ArrayList<Question> questions,
                  ArrayList<Comment> comments, ArrayList<ModuleGrade> moduleGrades) {
        this.title = title;
        this.description = description;
        this.topics = topics;
        this.questions = questions;
        this.comments = comments;
        this.moduleGrades = moduleGrades;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<ModuleGrade> getModuleGrades() {
        return moduleGrades;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setModuleGrades(ArrayList<ModuleGrade> moduleGrades) {
        this.moduleGrades = moduleGrades;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
    
    public void addTopic(Topic topic) {
        topics.add(topic);
    }
    
    public void addQuestion(Question question) {
        questions.add(question);
    }
    
    public void addModuleGrade(ModuleGrade moduleGrade) {
        moduleGrades.add(moduleGrade);
    }
    
    public void addComment(String userId, String text) {
        Comment comment = new Comment(userId, text);
        addComment(comment);
    }
    
    public void addQuestion(String questionText, ArrayList<String> choices, String correctChoice) {
        Question question = new Question(questionText, choices, correctChoice);
        addQuestion(question);
    }
    
    public void addModuleGrade(String module, String grade) {
        ModuleGrade moduleGrade = new ModuleGrade(module, grade);
        addModuleGrade(moduleGrade);
    }
    
    public void addTopic(String title, String description) {
        Topic topic = new Topic(title, description);
        addTopic(topic);
    }
    
}
