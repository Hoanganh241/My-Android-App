package api;

import java.util.List;

import model.Question;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuestionAPI {
    @GET("/API_giaothong/api.php")
    Call<List<Question>> getListQuestion(@Query("task") String task, @Query("id_de") String idDe);
}
