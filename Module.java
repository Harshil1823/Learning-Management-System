import java.util.ArrayList;
public class Module {
    private ArrayList<Module> modules;
    private Topic topics;
    private ArrayList<Comment> moduleComment;
    private String title;

    public Module(String moduleTitle, String moduleDescription, ArrayList<Topic> topics2, ArrayList<Question> questions,
            ArrayList<Comment> comments) {

    }

    public void addComments(Comment comment){
        moduleComment.add(comment);
    }
}
