package LLD.StackOverFlow;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private String commentId;
    private User commentedBy;
    private LocalDateTime date;
    private String content;
    public Comment(User commentedBy, String content) {
        commentId=generateId();
        this.commentedBy = commentedBy;
        this.content = content;
        date= LocalDateTime.now();
    }

    private String generateId() {
        return  Long.toString (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", commentedBy=" + commentedBy +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
