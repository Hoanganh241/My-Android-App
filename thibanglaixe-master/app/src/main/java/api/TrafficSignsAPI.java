package api;

import java.util.List;

import model.TrafficSigns;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrafficSignsAPI {
    @GET("/API_giaothong/api.php")
    Call<List<TrafficSigns>> getListTrafficSigns(@Query("task") String task);
}
