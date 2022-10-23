package api;

import java.util.List;

import model.ExamPrinciple;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExamPrincipleAPI {
    @GET("/API_giaothong/api.php")
    Call<List<ExamPrinciple>> getListExamPrinciples(@Query("task") String task);
}
