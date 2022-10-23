package service;

import model.TrafficSigns;
import serviceCallback.ListDataCallback;

public interface TrafficSignsService {
    public void getListTrafficSigns(ListDataCallback<TrafficSigns> callback);
}
