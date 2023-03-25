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
    
}
