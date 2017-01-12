package nyc.c4q.dereksantos.exam_1_11.android;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.dereksantos.exam_1_11.R;

public class LetterActivity extends AppCompatActivity {

    public static final String LETTER_URL_PARTIAL = "extra.letter.url";
    boolean backButtonPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);

        String fullUrl = "http://jsjrobotics.nyc" + getIntent().getStringExtra(LETTER_URL_PARTIAL);

        ImageView letterImageView = (ImageView) findViewById(R.id.letter_imageview);

        Picasso.with(getApplicationContext()).load(fullUrl).into(letterImageView);
    }

    @Override
    public void onBackPressed() {
        if (backButtonPressedOnce) {
            super.onBackPressed();
            return;
        }

        backButtonPressedOnce = true;
        Toast.makeText(this, "Press Once More to See List", Toast.LENGTH_SHORT).show();

//        resetBackButtonPressedOnce(); // resets backButtonPressedOnce variable if back button not pressed quickly
    }

    public void resetBackButtonPressedOnce() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                backButtonPressedOnce = false;
            }
        }, 2000);
    }
}
