package nyc.c4q.dereksantos.exam_1_11.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.dereksantos.exam_1_11.R;
import nyc.c4q.dereksantos.exam_1_11.backend.KeyboardApi;
import nyc.c4q.dereksantos.exam_1_11.backend.KeyboardResponse;
import nyc.c4q.dereksantos.exam_1_11.backend.Letter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KeyBoardFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private KeyboardAdapter keyboardAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keyboard, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.keyboard_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchKeyboardList();
        return view;
    }

    private void fetchKeyboardList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KeyboardApi keyboardApi = retrofit.create(KeyboardApi.class);

        Call<KeyboardResponse> call = keyboardApi.getKeyboardResponse();

        call.enqueue(new Callback<KeyboardResponse>() {
            @Override
            public void onResponse(Call<KeyboardResponse> call, Response<KeyboardResponse> response) {
                KeyboardResponse keyboardResponse = response.body();
                List<Letter> listOfLetters = keyboardResponse.getLetterList();

                keyboardAdapter = new KeyboardAdapter(listOfLetters);

                mRecyclerView.setAdapter(keyboardAdapter);
            }

            @Override
            public void onFailure(Call<KeyboardResponse> call, Throwable t) {

            }
        });
    }
}
