package com.example.mypaintaula;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

public class SimplePaint extends View {
    List<Paint> mPaintList;
    List<Path> mPathList;
    Paint currentPaint;
    Path currentPath;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        currentPaint = new Paint();
        currentPath = new Path();
        //configurando paint
        currentPaint.setColor(Color.RED);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(20);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(currentPath, currentPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly, lx;
        lx = event.getX();
        ly = event.getY();

        switch (event.getAction()){
            case ( MotionEvent.ACTION_DOWN):
                currentPath.moveTo(lx, ly);
                currentPath.lineTo(lx, ly);
                break;
            case (MotionEvent.ACTION_MOVE):
                currentPath.lineTo(lx, ly);
                break;
            case ( MotionEvent.ACTION_UP):
                currentPath.lineTo(lx, ly);
                break;

            default:
                break;

        }

        invalidate();

        return true;
    }

    public void setColor(Color color) {

        currentPaint.setColor(color.toArgb());
    }

}
