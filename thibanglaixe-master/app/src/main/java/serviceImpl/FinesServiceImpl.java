package serviceImpl;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import api.FinesAPI;
import model.Fines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.FinesService;
import serviceCallback.ListDataCallback;
import utils.Constant;
import utils.RetrofitRequest;

public class FinesServiceImpl implements FinesService {

    private static FinesAPI finesAPI;

    private static FinesService finesService;
    private List<Fines> fines;

    public FinesServiceImpl() {
        finesAPI = RetrofitRequest.getInstance().getRetrofit().create(FinesAPI.class);
    }

    public static FinesService getInstance() {
        if (finesService == null) {
            finesService = new FinesServiceImpl();
        }
        return finesService;
    }

    @Override
    public void getListFines(final ListDataCallback<Fines> callback) {
        finesAPI.getListFines("xu_phat").enqueue(new Callback<List<Fines>>() {
            @Override
            public void onResponse(Call<List<Fines>> call, Response<List<Fines>> response) {
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
            public void onFailure(Call<List<Fines>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });

    }
}
