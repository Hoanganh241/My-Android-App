package api;

import java.util.List;

import model.Fines;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FinesAPI {
    @GET("/API_giaothong/api.php")
    Call<List<Fines>> getListFines(@Query("task") String task);
}
