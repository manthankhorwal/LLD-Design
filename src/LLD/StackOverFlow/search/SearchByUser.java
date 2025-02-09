package LLD.StackOverFlow.search;

import LLD.StackOverFlow.Question;

import java.util.ArrayList;
import java.util.List;

public class SearchByUser implements SearchStrategy {

    @Override
    public List<Question> search(String query, List<Question> list) {
        List<Question> result=new ArrayList<>();
        for(Question q:list){
            if(query.equals(q.getAskedBy().getName()))
                result.add(q);
        }
        return result;
    }
}
