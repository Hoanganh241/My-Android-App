package serviceImpl;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import api.TopicAPI;
import model.Topic;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.TopicService;
import serviceCallback.ListDataCallback;
import utils.Constant;
import utils.RetrofitRequest;

public class TopicServiceImpl implements TopicService {

    private static TopicAPI topicsAPI;

    private static TopicService topicsService;
    private List<Topic> topics;

    public TopicServiceImpl() {
        topicsAPI = RetrofitRequest.getInstance().getRetrofit().create(TopicAPI.class);
    }

    public static TopicService getInstance() {
        if (topicsService == null) {
            topicsService = new TopicServiceImpl();
        }
        return topicsService;
    }

    @Override
    public void getListTopics(final ListDataCallback<Topic> callback) {
        topicsAPI.getListTopic("ma_de").enqueue(new Callback<List<Topic>>() {
            @Override
            public void onResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    try {
                        callback.onFail("Có lỗi xảy ra !");
                        Log.e("error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Topic>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });

    }
}
