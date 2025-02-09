package LLD.StackOverFlow.search;

import LLD.StackOverFlow.Question;

import java.util.List;

public class SearchQuestion {  //context
    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public List<Question> performSearch(String query , List<Question> allQuestions){
        return searchStrategy.search(query,allQuestions);
    }
}
