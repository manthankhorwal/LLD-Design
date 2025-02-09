package LLD.StackOverFlow.search;

import LLD.StackOverFlow.Question;

import java.util.List;

public interface SearchStrategy {
    public List<Question> search(String query, List<Question> list);
}
