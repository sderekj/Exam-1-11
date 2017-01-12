package nyc.c4q.dereksantos.exam_1_11.android;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import nyc.c4q.dereksantos.exam_1_11.backend.Letter;

public class KeyboardAdapter extends RecyclerView.Adapter<LetterViewHolder> {

    List<Letter> letterList;

    public KeyboardAdapter(List<Letter> letterList) {
        this.letterList = letterList;
    }

    @Override
    public LetterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LetterViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(LetterViewHolder holder, int position) {
        Letter letter = letterList.get(position);
        holder.bind(letter);
        holder.setOnClickListener(buildLetterClickListener(letter));
    }

    @Override
    public int getItemCount() {
        return letterList.size();
    }

    // ClickListeners
    private View.OnClickListener buildLetterClickListener(Letter letter) {
        if (letter != null){
            return navigateToLetterViewListener(letter.getUrl());
        }
        return defaultClickListener();
    }

    private View.OnClickListener navigateToLetterViewListener(final String url) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LetterActivity.class);
                intent.putExtra(LetterActivity.LETTER_URL_PARTIAL, url);
                view.getContext().startActivity(intent);
            }
        };
    }

    private View.OnClickListener defaultClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do Nothing
            }
        };
    }
}
