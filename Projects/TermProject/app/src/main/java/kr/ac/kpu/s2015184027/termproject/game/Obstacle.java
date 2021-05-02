package kr.ac.kpu.s2015184027.termproject.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import kr.ac.kpu.s2015184027.termproject.R;
import kr.ac.kpu.s2015184027.termproject.framework.AnimationGameBitmap;
import kr.ac.kpu.s2015184027.termproject.framework.BoxCollidable;
import kr.ac.kpu.s2015184027.termproject.framework.GameBitmap;
import kr.ac.kpu.s2015184027.termproject.framework.GameObject;
import kr.ac.kpu.s2015184027.termproject.ui.view.GameView;

public class Obstacle implements GameObject, BoxCollidable {
    private static final float FRAMES_PER_SECOND = 8.0f;
    private static final int[] RESOURCE_IDS = {
            R.mipmap.brick
    };
    private final float x;
    private final GameBitmap bitmap;
    private final int level;
    private float y;
    private final int speed;

    public Obstacle(int level, float x, float y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.level = level;

        int resId = RESOURCE_IDS[level - 1];

        this.bitmap = new AnimationGameBitmap(resId, FRAMES_PER_SECOND, 0);
    }

    @Override
    public void update() {
        MainGame game = MainGame.get();
        y += speed * game.frameTime;

        if (y > GameView.view.getHeight()) {
            game.remove(this);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        bitmap.draw(canvas, x, y);
    }

    @Override
    public void getBoundingRect(RectF rect) {
        bitmap.getBoundingRect(x, y, rect);
    }
}