package LLD.StackOverFlow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question implements ICommentable,IVotable {
    private String questionId;
    private String title;
    private String description;
    private User askedBy;
    private int votes;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private LocalDateTime dateTime;


    public Question(String title, String description, User askedBy, List<Tag> tags) {
        this.dateTime=LocalDateTime.now();
        this.title = title;
        this.description = description;
        this.askedBy = askedBy;
        this.tags = tags;
        this.votes=0;
        this.answers=new ArrayList<>();
        this.comments=new ArrayList<>();
        this.tags=new ArrayList<>();
    }
    public User getAskedBy(){
        return askedBy;
    }
    public void addAnswer(Answer answer){
        answers.add(answer);
    }
    @Override
    public void addComment(Comment comment) {
    comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void upVote() {
         votes++;
         askedBy.increaseReputation();
    }

    @Override
    public void downVote() {
         votes--;
         askedBy.decreaseReputation();
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", askedBy=" + askedBy +
                ", votes=" + votes +
                ", answers=" + answers +
                ", comments=" + comments +
                ", tags=" + tags +
                ", dateTime=" + dateTime +
                '}';
    }
}
