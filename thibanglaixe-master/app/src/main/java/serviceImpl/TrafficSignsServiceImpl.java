package serviceImpl;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import api.TrafficSignsAPI;
import model.TrafficSigns;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.TrafficSignsService;
import serviceCallback.ListDataCallback;
import utils.Constant;
import utils.RetrofitRequest;

public class TrafficSignsServiceImpl implements TrafficSignsService {

    private static TrafficSignsAPI trafficSignsAPI;
    private static TrafficSignsService trafficSignsService;

    public TrafficSignsServiceImpl() {
        trafficSignsAPI = RetrofitRequest.getInstance().getRetrofit().create(TrafficSignsAPI.class);
    }

    public static TrafficSignsService getInstance() {
        if (trafficSignsService == null) {
            trafficSignsService = new TrafficSignsServiceImpl();
        }
        return trafficSignsService;
    }

    @Override
    public void getListTrafficSigns(final ListDataCallback<TrafficSigns> callback) {
        trafficSignsAPI.getListTrafficSigns("bien_bao").enqueue(new Callback<List<TrafficSigns>>() {
            @Override
            public void onResponse(Call<List<TrafficSigns>> call, Response<List<TrafficSigns>> response) {
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
            public void onFailure(Call<List<TrafficSigns>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });
    }
}
