package com.example.pinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gDetector;
    PinWheelDesign myView;
    int x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.pin_wheel_view);
        gDetector = new GestureDetector(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //System.out.println("onFling");

        x1 = (int)e1.getX();
        y1 = (int)e1.getY();

        x2 = (int)e2.getX();
        y2 = (int)e2.getY();

        System.out.println("X "+x1+"; Y "+y1);
        System.out.println("X "+x2+"; Y "+y2);

        if(velocityX < 0)
            velocityX = -1 * velocityX;

        myView.newView(velocityX/200);

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //System.out.println("onTouch");
        int x = (int)event.getX();
        int y = (int)event.getY();

        //System.out.println("X "+x+"; Y "+y);
        return gDetector.onTouchEvent(event);

    }
}