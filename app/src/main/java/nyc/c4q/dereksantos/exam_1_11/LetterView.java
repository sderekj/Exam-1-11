package nyc.c4q.dereksantos.exam_1_11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LetterView extends AppCompatActivity {

    public static final String LETTER_URL = "extra.letter.url";
    private static final String TAG = LetterView.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letter_view);

        String partOfUrl = getIntent().getStringExtra(LETTER_URL);
        String fullUrl = "http://jsjrobotics.nyc" + partOfUrl;

        ImageView letterImageView = (ImageView) findViewById(R.id.letter_imageview);

        Picasso.with(getApplicationContext()).load(fullUrl).into(letterImageView);
    }
}
