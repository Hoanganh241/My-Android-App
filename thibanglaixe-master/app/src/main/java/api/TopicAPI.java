package api;

import java.util.List;

import model.Topic;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TopicAPI {
    @GET("/API_giaothong/api.php")
    Call<List<Topic>> getListTopic(@Query("task") String task);
}
