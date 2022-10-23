package service;

import model.Fines;
import serviceCallback.ListDataCallback;

public interface FinesService {
    public void getListFines(ListDataCallback<Fines> callback);
}
