package kr.ac.kpu.s2015184027.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.ac.kpu.s2015184027.termproject.framework.view.GameView;
import kr.ac.kpu.s2015184027.termproject.game.MainGame;

public class MainActivity extends AppCompatActivity {

    private MainGame mainGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainGame = new MainGame();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GameView.view.pauseGame();
    }
}