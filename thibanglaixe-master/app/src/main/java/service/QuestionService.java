package service;

import model.Question;
import serviceCallback.ListDataCallback;

public interface QuestionService {
    void getListQuestion(ListDataCallback<Question> callback, String task, String idDe);
}
