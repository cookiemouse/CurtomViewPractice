package cn.cookiemouse.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by cookiemouse on 2017/10/30.
 */

public class CakeView extends View {

    private static final String TAG = "CakeView";

    private Paint mPaint;
    private int mWidth, mHeight;

    private RectF mRectFCircle;

    public CakeView(Context context) {
        this(context, null);
    }

    public CakeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        Log.i(TAG, "onMeasure: mWidth-->" + mWidth + ", mHeight-->" + mHeight);

        if (mWidth > mHeight) {
            mRectFCircle = new RectF(mHeight / 6, mHeight / 6, mHeight * 5 / 6, mHeight * 5 / 6);
        } else {
            mRectFCircle = new RectF(mWidth / 6, mWidth / 6, mWidth * 5 / 6, mWidth * 5 / 6);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(0xff666666);

        drawArc(canvas, 0xffff0000, 0, 70);
        drawArc(canvas, 0xff00ff00, 72, 90);
        drawArc(canvas, 0xffffffff, 164, 46);

        mPaint.setColor(0xff0000ff);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawArc(mRectFCircle, 216, 90, true, mPaint);
    }

    private void drawArc(Canvas canvas, int color, float starAngle, float sweepAngle) {
        mPaint.setColor(color);
        canvas.drawArc(mRectFCircle, starAngle, sweepAngle, true, mPaint);
    }
}
