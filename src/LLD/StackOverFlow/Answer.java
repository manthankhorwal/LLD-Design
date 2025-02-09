package LLD.StackOverFlow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Answer implements IVotable,ICommentable{
    private String answerId;
    private String content;
    private User answeredBy;
    private int votes;
    private List<Comment> comments;
    private LocalDateTime dateTime;

    public Answer(String content, User answeredBy) {
        this.answerId=generateId();
        dateTime=LocalDateTime.now();
        this.content = content;
        this.answeredBy = answeredBy;
        this.votes=0;
        this.comments=new ArrayList<>();
    }

    private String generateId() {
        return  Long.toString (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
    @Override
    public void addComment(Comment comment) {
     comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void upVote() {
     votes++;
     answeredBy.increaseReputation();
    }

    @Override
    public void downVote() {
    votes--;
    answeredBy.decreaseReputation();;
    }
    @Override
    public String toString() {
        return "Answer{" +
                "answerId='" + answerId + '\'' +
                ", content='" + content + '\'' +
                ", answeredBy=" + answeredBy +
                ", votes=" + votes +
                ", comments=" + comments +
                ", dateTime=" + dateTime +
                '}';
    }
}
