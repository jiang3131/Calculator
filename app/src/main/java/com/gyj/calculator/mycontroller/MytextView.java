package com.gyj.calculator.mycontroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MytextView extends AppCompatTextView {
    Paint paint = new Paint();

    public MytextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        canvas.drawLine(0, 0, this.getWidth(), 0, paint);//上
        canvas.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1, paint);//下
        canvas.drawLine(0, 0, 0, this.getHeight() , paint);//左
        canvas.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight(), paint);//右


    }
}
