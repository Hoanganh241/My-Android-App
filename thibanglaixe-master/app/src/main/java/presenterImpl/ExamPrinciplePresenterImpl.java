package presenterImpl;

import java.util.List;

import model.ExamPrinciple;
import presenter.ExamPrinciplePresenter;
import service.ExamPrincipleService;
import serviceCallback.ListDataCallback;
import serviceImpl.ExamPrincipleServiceImpl;
import ui.activityImpl.ExamPrincipleActivityImpl;

public class ExamPrinciplePresenterImpl implements ExamPrinciplePresenter {

    private ExamPrincipleActivityImpl view;
    private ExamPrincipleService trafficSignsService;

    public ExamPrinciplePresenterImpl(ExamPrincipleActivityImpl view) {
        this.view = view;
        this.trafficSignsService = ExamPrincipleServiceImpl.getInstance();
    }

    @Override
    public void getListExamPrinciples() {
        trafficSignsService.getListExamPrinciples(new ListDataCallback<ExamPrinciple>() {
            @Override
            public void onSuccess(List<ExamPrinciple> data) {
                view.setListExamPrinciples(data);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

}
