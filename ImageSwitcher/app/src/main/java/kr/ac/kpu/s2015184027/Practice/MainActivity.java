package kr.ac.kpu.s2015184027.Practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainTextView;
    private ImageView mainImageView;
    private ImageButton nextBtn;
    private ImageButton prevBtn;

    private int imageIndex = 0;
    private static final int[] imageArr = {R.mipmap.cat1, R.mipmap.cat2, R.mipmap.cat3, R.mipmap.cat4, R.mipmap.cat5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.mainTextView);
        mainImageView = findViewById(R.id.mainImageView);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        update();
    }

    private void update() {
        prevBtn.setEnabled(imageIndex != 0);
        nextBtn.setEnabled(imageIndex != imageArr.length-1);

        mainTextView.setText((imageIndex+1)+" / "+(imageArr.length));
        mainImageView.setImageResource(imageArr[imageIndex]);
    }

    public void onBtnPrev(View view) {
        imageIndex--;
        update();
    }

    public void onBtnNext(View view) {
        imageIndex++;
        update();
    }
}
