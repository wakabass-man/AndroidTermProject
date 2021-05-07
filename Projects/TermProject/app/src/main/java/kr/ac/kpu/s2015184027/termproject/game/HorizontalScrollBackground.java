package kr.ac.kpu.s2015184027.termproject.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import kr.ac.kpu.s2015184027.termproject.framework.GameBitmap;
import kr.ac.kpu.s2015184027.termproject.framework.GameObject;
import kr.ac.kpu.s2015184027.termproject.game.MainGame;
import kr.ac.kpu.s2015184027.termproject.ui.view.GameView;

public class HorizontalScrollBackground implements GameObject {
    private final Bitmap bitmap;
    private final float speed;
    private float scroll;

    private Rect srcRect = new Rect();
    private RectF dstRect = new RectF();
    public HorizontalScrollBackground(int resId, float speed){
        this.speed = speed * GameView.MULTIPLIER;
        bitmap = GameBitmap.load(resId);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        srcRect.set(0, 0, w, h);
        float l = 0;
        float t = 0;
        float r = GameView.view.getWidth();
        float b = r * h / w;
        dstRect.set(l, t, r, b);
    }
    @Override
    public void update() {
        MainGame mainGame = MainGame.get();
        float amount =  speed * mainGame.frameTime;
        scroll += amount;
    }

    @Override
    public void draw(Canvas canvas) {
        int vw = GameView.view.getWidth();
        int vh = GameView.view.getHeight();
        int iw = bitmap.getWidth();
        int ih = bitmap.getHeight();
        int dw = vh * iw / ih;

        int curr = (int)scroll % dw;
        if(curr > 0){
            curr -= dw;
        }

        while(curr < vw){
            dstRect.set(curr, 0, curr + dw, vh);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            curr += dw;
        }
    }
}