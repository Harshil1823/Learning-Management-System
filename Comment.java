import java.util.ArrayList;
public class Comment {
    private String comment;
    private String author;
    private ArrayList<Comment> replies;

    public Comment(String userId, String text) {
        this.author = userId;
        this.comment = text;
    }

    public boolean checkValidComment(String Comment){
        return true;
    }

    public Object getUserId() {
        return null;
    }

    public Object getText() {
        return null;
    }
}
