package kr.ac.kpu.s2015184027.termproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.ac.kpu.s2015184027.termproject.framework.view.GameView;
import kr.ac.kpu.s2015184027.termproject.game.MainGame;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    private MainGame mainGame;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),
                    "OnActivityResult. Code: " + requestCode + ", Result: " +
                    requestCode, Toast.LENGTH_LONG).show();

            if (requestCode == RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(), "offered name: " + name,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainGame = new MainGame();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Title.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        GameView.view.pauseGame();
    }
}