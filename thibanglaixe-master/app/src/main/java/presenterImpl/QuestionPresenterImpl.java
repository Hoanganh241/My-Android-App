package presenterImpl;

import java.util.List;

import model.Question;
import presenter.QuestionPresenter;
import service.QuestionService;
import serviceCallback.ListDataCallback;
import serviceImpl.QuestionServiceImpl;
import ui.activity.BaseQuestionActivity;

public class QuestionPresenterImpl implements QuestionPresenter {


    private BaseQuestionActivity view;
    private QuestionService questionService;

    public QuestionPresenterImpl(BaseQuestionActivity view) {
        this.view = view;
        this.questionService = QuestionServiceImpl.getInstance();
    }
    
    @Override
    public void getListQuestion(String task, String idDe) {
        questionService.getListQuestion(new ListDataCallback<Question>() {
            @Override
            public void onSuccess(List<Question> data) {
                view.setListQuestion(data);
            }

            @Override
            public void onFail(String error) {

            }
        }, task, idDe);
    }
}
