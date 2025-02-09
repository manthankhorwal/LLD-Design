package LLD.StackOverFlow;

import LLD.StackOverFlow.search.SearchByUser;
import LLD.StackOverFlow.search.SearchQuestion;

import java.util.ArrayList;
import java.util.List;

public class StackOverFlowClient {
    public static void main(String[] args) {

    User user1=new User("1","Manthan","manthankhorwal502@gmail.com");
    User user2=new User("2","Tanay","tanay@gmail.com");
    User user3=new User("3","Mohit","mohit@gmail.com");
    List<Question> allQuestions=new ArrayList<>();
    Question q1=new Question("Stack","What is Stack",user1, List.of(new Tag("DSA"),new Tag("LIFO")));
    Answer a1=new Answer("It is a Lifo",user2);
    Question q2=new Question("Queue","What is Queue",user2, List.of(new Tag("DSA"),new Tag("FIFO")));
    Question q3=new Question("Queue","What is Queue",user1, List.of(new Tag("DSA"),new Tag("FIFO")));

    Answer a2=new Answer("This is a FIFO",user1);
    q1.upVote();
    q2.upVote();
    q2.upVote();
    q2.upVote();
    q2.upVote();
    q1.upVote();
    q1.upVote();
    q2.upVote();
    a1.upVote();
    a1.upVote();
    a1.upVote();
    a2.upVote();
    a2.upVote();
    a2.upVote();
    allQuestions.add(q1);
    allQuestions.add(q2);
    allQuestions.add(q3);
    Comment c1=new Comment(user3,"This is right but can be more answered");
    Comment c2=new Comment(user3,"This is right but can be more answered");
    Comment c3=new Comment(user3,"What an easy question");
    a1.addComment(c1);
    a2.addComment(c2);
    q1.addComment(c3);
    q1.addComment(c3);

        System.out.println(q1);
        System.out.println(a1);
        System.out.println(q2);

        SearchQuestion searchQuestion=new SearchQuestion();
        searchQuestion.setSearchStrategy(new SearchByUser());
        System.out.println(searchQuestion.performSearch("Manthan",allQuestions));
    }
}
