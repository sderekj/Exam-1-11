package nyc.c4q.dereksantos.exam_1_11.android;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.dereksantos.exam_1_11.R;
import nyc.c4q.dereksantos.exam_1_11.backend.Letter;

public class LetterViewHolder extends RecyclerView.ViewHolder {

    private final View mView;
    private final TextView letterTextView;

    public LetterViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        letterTextView = (TextView) mView.findViewById(R.id.letter_textview);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.viewholder_letter, parent, false);
    }


    public void bind(Letter letter) {
        letterTextView.setText(letter.getName());
        int textColor = Color.parseColor(letter.getTextColor());
        letterTextView.setTextColor(textColor);
    }

    public TextView getName(){
        return letterTextView;
    }

    public void setOnClickListener(View.OnClickListener clickListener){
        mView.setOnClickListener(clickListener);
    }
}
