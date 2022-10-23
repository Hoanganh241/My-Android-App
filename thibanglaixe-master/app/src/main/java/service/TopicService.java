package service;

import model.Topic;
import serviceCallback.ListDataCallback;

public interface TopicService {
    public void getListTopics(ListDataCallback<Topic> callback);
}
