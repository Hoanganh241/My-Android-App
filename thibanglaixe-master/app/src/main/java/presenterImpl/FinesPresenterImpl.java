package presenterImpl;

import java.util.List;

import model.Fines;
import presenter.FinesPresenter;
import service.FinesService;
import serviceCallback.ListDataCallback;
import serviceImpl.FinesServiceImpl;
import ui.activityImpl.FinesActivityImpl;

public class FinesPresenterImpl implements FinesPresenter {

    private FinesActivityImpl view;
    private FinesService finesService;

    public FinesPresenterImpl(FinesActivityImpl finesActivity) {
        this.view = finesActivity;
        this.finesService = FinesServiceImpl.getInstance();
    }

    @Override
    public void getListFines() {
        finesService.getListFines(new ListDataCallback<Fines>() {
            @Override
            public void onSuccess(List<Fines> data) {
                view.setListFines(data);
            }

            @Override
            public void onFail(String error) {

            }
        });

    }

}
