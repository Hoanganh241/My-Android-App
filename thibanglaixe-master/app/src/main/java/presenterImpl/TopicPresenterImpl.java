package presenterImpl;

import java.util.List;

import model.Topic;
import presenter.TopicPresenter;
import service.TopicService;
import serviceCallback.ListDataCallback;
import serviceImpl.TopicServiceImpl;
import ui.activityImpl.TopicActivityImpl;

public class TopicPresenterImpl implements TopicPresenter {

    private TopicActivityImpl view;
    private TopicService topicService;

    public TopicPresenterImpl(TopicActivityImpl topicActivity) {
        this.view = topicActivity;
        this.topicService = TopicServiceImpl.getInstance();
    }

    @Override
    public void getListTopics() {
        topicService.getListTopics(new ListDataCallback<Topic>() {
            @Override
            public void onSuccess(List<Topic> data) {
                view.setListTopics(data);
            }

            @Override
            public void onFail(String error) {

            }
        });

    }
}
