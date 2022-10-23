package presenterImpl;

import java.util.List;

import model.TrafficSigns;
import presenter.TrafficSignsPresenter;
import service.TrafficSignsService;
import serviceCallback.ListDataCallback;
import serviceImpl.TrafficSignsServiceImpl;
import ui.activityImpl.TrafficSignsActivityImpl;

public class TrafficSignsPresenterImpl implements TrafficSignsPresenter {

    private TrafficSignsActivityImpl view;
    private TrafficSignsService trafficSignsService;

    public TrafficSignsPresenterImpl(TrafficSignsActivityImpl view) {
        this.view = view;
        this.trafficSignsService = TrafficSignsServiceImpl.getInstance();
    }

    @Override
    public void getListTrafficSigns() {
        trafficSignsService.getListTrafficSigns(new ListDataCallback<TrafficSigns>() {
            @Override
            public void onSuccess(List<TrafficSigns> data) {
                view.setListTrafficSigns(data);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
