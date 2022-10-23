package serviceImpl;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import api.QuestionAPI;
import model.Question;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.QuestionService;
import serviceCallback.ListDataCallback;
import utils.Constant;
import utils.RetrofitRequest;

public class QuestionServiceImpl implements QuestionService {

    private static QuestionAPI questionAPI;
    private static QuestionService questionService;
    private List<Question> questions;

    public QuestionServiceImpl() {
        questionAPI = RetrofitRequest.getInstance().getRetrofit().create(QuestionAPI.class);
    }

    public static QuestionService getInstance() {
        if (questionService == null) {
            questionService = new QuestionServiceImpl();
        }
        return questionService;
    }

    @Override
    public void getListQuestion(final ListDataCallback<Question> callback, String task, String idDe) {

        questionAPI.getListQuestion(task, idDe).enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
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
            public void onFailure(Call<List<Question>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });
        /*Call<List<Question>> call = questionAPI.getListQuestion(task);
        try {
            Response<List<Question>> response = call.execute();
            Log.d("size", String.valueOf(response.body().size()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
