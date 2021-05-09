package com.mygdx.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class CanvasBackground extends SurfaceView implements SurfaceHolder.Callback {
    public int xPos;
    public int yPos;

    public int xVel;
    public int yVel;

    public int width;
    public int height;

    public int circleRadius;
    public Paint circlePaint;

    UpdateThread updateThread;

    public CanvasBackground(Context context) {
        super(context);
        getHolder().addCallback(this);

        circleRadius = 10;
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);

        xVel = 2;
        yVel = 2;
    }
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.WHITE);

        canvas.drawCircle(xPos, yPos, circleRadius, circlePaint);
    }
    public void updatePhysics() {
        xPos += xVel;
        yPos += yVel;
        if (yPos - circleRadius < 0 || yPos + circleRadius > height) {
            //В случае ударов о верх или низ холста
            if (yPos - circleRadius < 0) {
                //Удар о верхнюю грань
                yPos = circleRadius;
            }else{
                //Удар о нижнюю грань
                yPos = height - circleRadius;
            }
            //Меняем направление шарика
            yVel *= -1;
        }
        if (xPos - circleRadius < 0 || xPos + circleRadius > width) {
            //В случае столкновений с правой или левой стенками
            if (xPos - circleRadius < 0) {
                //В случае столкновений с левой стенкой
                xPos = circleRadius;
            } else {
                //В случае столкновений с правой стенкой
                xPos = width - circleRadius;
            }
            //Меняем x направление на обратное
            xVel *= -1;
        }
    }

//    public void stars(){
//
//    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Rect surfaceFrame = holder.getSurfaceFrame();
        width = surfaceFrame.width();
        height = surfaceFrame.height();

        xPos = width / 2;
        yPos = circleRadius;

        updateThread = new UpdateThread(this);
        updateThread.setRunning(true);
        updateThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        boolean retry = true;

        updateThread.setRunning(false);
        while (retry) {
            try {
                updateThread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }
}
class UpdateThread extends Thread {
    private long time;
    private final int fps = 20;
    private boolean toRun = false;
    private CanvasBackground movementView;
    private SurfaceHolder surfaceHolder;

    public UpdateThread(CanvasBackground rMovementView) {
        movementView = rMovementView;
        surfaceHolder = movementView.getHolder();
    }

    public void setRunning(boolean run) {
        toRun = run;
    }

    @Override
    public void run() {
        Canvas c;
        while (toRun) {

            long cTime = System.currentTimeMillis();

            if ((cTime - time) <= (1000 / fps)) {

                c = null;
                try {
                    c = surfaceHolder.lockCanvas(null);
                    movementView.updatePhysics();
                    movementView.draw(c); //onDraw
                } finally {

                    if (c != null) {
                        surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
            time = cTime;
        }
    }
}
