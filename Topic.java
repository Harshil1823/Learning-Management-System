import java.io.*;
/**
 * @author JavaDoc
 * Represents a module topic
 */
public class Topic {
    private String title;
    private String description;

    /**
     * Constructor to initialize a Topic.
     * @param topicTitle String of topic title.
     * @param topicDescription String of topic description.
     */
    public Topic(String topicTitle, String topicDescription) {
        this.title = topicTitle;
        this.description = topicDescription;
    }

    /**
     * Returns the title of the topic.
     * @return The title of the topic.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the topic.
     * @param title The title of the topic.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the description of the topic.
     * @return The description of the topic.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the topic.
     * @param description The description of the topic.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void displayDetails(){
        System.out.println("     Title" + title);
        System.out.println("       Topic description: " + description);
    }

    public void displayDetailsToFile(PrintWriter out){
        out.println("     Title" + title);
        out.println("       Topic description: " + description);
    }
}