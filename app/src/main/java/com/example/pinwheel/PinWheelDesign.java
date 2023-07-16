package com.example.pinwheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class PinWheelDesign extends View{
	
	Paint paintBlue, paintStroke, paintRed, paintGreen, paintYellow, paintCyan, paintMagenda;
	int left, top, right, bottom;
	float startAngle1, startAngle2, startAngle3, startAngle4, startAngle5, startAngle6, startAngle7, startAngle8, sweepAngle;
	boolean rotating = true;
	float velocity, rotate = 0;;
	
	public PinWheelDesign(Context context, AttributeSet attrs) {
		super(context, attrs);
		paintBlue = new Paint();
		paintRed = new Paint();
		paintGreen= new Paint();
		paintYellow = new Paint();
		paintStroke = new Paint();
		paintCyan = new Paint();
		paintMagenda = new Paint();
		
		paintBlue.setColor(Color.BLUE);
		paintBlue.setStyle(Style.FILL_AND_STROKE);
		
		paintRed.setColor(Color.RED);
		paintRed.setStyle(Style.FILL_AND_STROKE);
		
		paintYellow.setColor(Color.YELLOW);
		paintYellow.setStyle(Style.FILL_AND_STROKE);
		
		paintGreen.setColor(Color.GREEN);
		paintGreen.setStyle(Style.FILL_AND_STROKE);
		
		paintCyan.setColor(Color.CYAN);
		paintCyan.setStyle(Style.FILL_AND_STROKE);
		
		paintMagenda.setColor(Color.MAGENTA);
		paintMagenda.setStyle(Style.FILL_AND_STROKE);
		
		paintStroke.setColor(Color.BLACK);
		paintStroke.setStyle(Style.STROKE);
		
		startAngle1 = 0;
		startAngle2 = 60;
		startAngle3 = 120;
		startAngle4 = 180;
		startAngle5 = 240;
		startAngle6 = 300;
		sweepAngle = 30;
	}
	
	public PinWheelDesign(Context context) {
		super(context);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec); 
		int heightSize =  MeasureSpec.getSize(heightMeasureSpec);
		
		left = widthSize/2 - widthSize/4;
		top = heightSize/2 - heightSize/4;
		right = widthSize/2 + widthSize/4;
		bottom = heightSize/2 + heightSize/4;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		canvas.drawRect(left, top, right, bottom, paintStroke);
		
		canvas.drawArc(left, top, right, bottom, startAngle1, sweepAngle, true, paintYellow);
		canvas.drawArc(left, top, right, bottom, startAngle2, sweepAngle, true, paintBlue);
		canvas.drawArc(left, top, right, bottom, startAngle3, sweepAngle, true, paintRed);
		canvas.drawArc(left, top, right, bottom, startAngle4, sweepAngle, true, paintGreen);
		canvas.drawArc(left, top, right, bottom, startAngle5, sweepAngle, true, paintCyan);
		canvas.drawArc(left, top, right, bottom, startAngle6, sweepAngle, true, paintMagenda);
		
		startAngle1 += 30;
		startAngle2 += 30;
		startAngle3 += 30;
		startAngle4 += 30;
		startAngle5 += 30;
		startAngle6 += 30;
		
		if(startAngle1 ==360)
			startAngle1 = 0;
		
		if(startAngle2 ==360)
			startAngle2 = 0;
		
		if(startAngle3 ==360)
			startAngle3 = 0;
		
		if(startAngle4 ==360)
			startAngle4 = 0;
		
		if(startAngle5 ==360)
			startAngle5 = 0;
		
		if(startAngle6 ==360)
			startAngle6 = 0;
		
		System.out.println(startAngle1+" "+startAngle2+" "+startAngle3+" "+startAngle4+" "+startAngle5+" "+startAngle6+" ");
		
		if(rotate <= velocity)
		{
			rotate++;
			System.out.println(rotate);
			invalidate();
		}
		else
		{
			rotate = 0;
		}
		
	}

	public void newView(float velocityX) {
		
		velocity = velocityX;
		
		System.out.println(velocityX+" VelocityX in PinWheelDesign");
		invalidate();
	}
	
}
