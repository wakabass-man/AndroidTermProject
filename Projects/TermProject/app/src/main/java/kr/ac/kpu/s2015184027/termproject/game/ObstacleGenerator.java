package kr.ac.kpu.s2015184027.termproject.game;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

import kr.ac.kpu.s2015184027.termproject.framework.GameObject;
import kr.ac.kpu.s2015184027.termproject.ui.view.GameView;

public class ObstacleGenerator implements GameObject {

    private static final float INITIAL_SPAWN_INTERVAL = 2.0f;
    private static final String TAG = ObstacleGenerator.class.getSimpleName();
    private float time;
    private float spawnInterval;
    private int wave;

    public ObstacleGenerator() {
        time = INITIAL_SPAWN_INTERVAL;
        spawnInterval = INITIAL_SPAWN_INTERVAL;
        wave = 0;
    }
    @Override
    public void update() {
        MainGame game = MainGame.get();
        time += game.frameTime;
        if (time >= spawnInterval) {
            generate();
            time -= spawnInterval;
        }
    }

    private void generate() {
        wave++;
        //Log.d(TAG, "Generate now !!");
        MainGame game = MainGame.get();
        int tenth = GameView.view.getWidth() / 10;
        Random r = new Random();
        for (int i = 1; i <= 9; i += 2) {
            int x = tenth * i;
            int y = 0;
            int level = wave / 10 - r.nextInt(3);
            if (level < 1) level = 1;
            if (level > 20) level = 20;
            Obstacle obstacle = new Obstacle(level, x, y, 700);
            game.add(obstacle);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        // does nothing
    }
}
