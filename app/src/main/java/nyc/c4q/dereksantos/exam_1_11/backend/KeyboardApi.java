package nyc.c4q.dereksantos.exam_1_11.backend;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SACC on 1/11/17.
 */
public interface KeyboardApi {

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<KeyboardResponse> getKeyboardResponse();
}
