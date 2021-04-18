package kr.ac.kpu.s2015184027.termproject.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public class TitleView extends View {
    private static final String TAG = TitleView.class.getSimpleName();

    public TitleView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(0xff0044ff);
        Rect rect = new Rect(10, 20, 300, 400);
        Log.d(TAG, "drawing " + rect);
        canvas.drawRect(rect, paint);
    }
}