package utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    private static RetrofitRequest instance;
    private static Retrofit retrofit = null;
    private static OkHttpClient defaultHttpClient = null;

    private RetrofitRequest() {
        if (defaultHttpClient == null) {
            defaultHttpClient = OkHttpUtils.createHttpClient();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.RETROFIT.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }
    }

    public static RetrofitRequest getInstance() {
        if (instance == null) {
            instance = new RetrofitRequest();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
