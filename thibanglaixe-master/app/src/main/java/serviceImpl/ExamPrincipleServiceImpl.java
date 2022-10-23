package serviceImpl;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import api.ExamPrincipleAPI;
import model.ExamPrinciple;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ExamPrincipleService;
import serviceCallback.ListDataCallback;
import utils.Constant;
import utils.RetrofitRequest;

public class ExamPrincipleServiceImpl implements ExamPrincipleService {

    private static ExamPrincipleAPI trafficSignsAPI;
    private static ExamPrincipleService trafficSignsService;

    public ExamPrincipleServiceImpl() {
        trafficSignsAPI = RetrofitRequest.getInstance().getRetrofit().create(ExamPrincipleAPI.class);
    }

    public static ExamPrincipleService getInstance() {
        if (trafficSignsService == null) {
            trafficSignsService = new ExamPrincipleServiceImpl();
        }
        return trafficSignsService;
    }

    @Override
    public void getListExamPrinciples(final ListDataCallback<ExamPrinciple> callback) {
        trafficSignsAPI.getListExamPrinciples("thuc_hanh").enqueue(new Callback<List<ExamPrinciple>>() {
            @Override
            public void onResponse(Call<List<ExamPrinciple>> call, Response<List<ExamPrinciple>> response) {
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
            public void onFailure(Call<List<ExamPrinciple>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });
    }
}
