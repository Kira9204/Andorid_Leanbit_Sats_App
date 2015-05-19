package se.leanbit.sats.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import se.leanbit.sats.R;

/**
 * Created by gina on 2015-05-13.
 */
public class CustomCircleDraw extends View
{
    private boolean mDrawCircleFill = true;
    private Paint mPaintFill;
    private Paint mPaintEmpty;
    private Paint mPaintDivider;
    private Paint mPaintRectangle;
    private Paint mPaintText;
    private Paint mPaintWeekDates;
    private int mWidth;
    private int mHeight;
    private int mNumber;
    private String mWeekdates;
    private float mTopBarHeight;
    private float mBottomBarHeight;
    private int mMaxAntalPass;
    private final Rect textBounds = new Rect(); //don't new this up in a draw method

    public CustomCircleDraw(Context context, AttributeSet attrs)
    {
        super(context);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomCircleDraw,
                0, 0);
        init();
    }


    private void init()
    {
        mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintEmpty = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintDivider = new Paint((Paint.ANTI_ALIAS_FLAG));
        mPaintText =new Paint((Paint.ANTI_ALIAS_FLAG));
        mPaintRectangle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintWeekDates = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(Color.WHITE);
        mPaintFill.setColor(getResources().getColor(R.color.circle_orange));
        mPaintEmpty.setColor(getResources().getColor(R.color.circle_orange));
        mPaintEmpty.setStyle(Paint.Style.STROKE);
        mPaintEmpty.setStrokeWidth(getResources().getDimension(R.dimen.circle_width));
        mPaintDivider.setColor(Color.GRAY);
        mPaintDivider.setStrokeWidth(getResources().getDimension(R.dimen.stroke_width) / 2);
        mPaintText.setTextSize(getResources().getDimension(R.dimen.size_of_text));
        mPaintWeekDates.setTextSize(getResources().getDimension(R.dimen.size_of_text));
        mPaintRectangle.setColor(Color.WHITE);
        mPaintRectangle.setStyle(Paint.Style.FILL);
        mNumber = 0;
        mMaxAntalPass = 5;
        mTopBarHeight = getResources().getDimension(R.dimen.height_of_top_rectangle);
        mBottomBarHeight = getResources().getDimension(R.dimen.height_of_bottom_rectangle);

    }

    public void drawCircleFill(boolean drawCircleFill)
    {
        mDrawCircleFill = drawCircleFill;
        invalidate();
        requestLayout();
    }

    public boolean isDrawCircleFill(){
        return mDrawCircleFill;
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(0,0,mWidth,mTopBarHeight,mPaintRectangle);

        canvas.drawRect(0,mHeight-mBottomBarHeight,mWidth,mHeight,mPaintRectangle);
        canvas.drawLine(0,mHeight-mBottomBarHeight, mWidth,mHeight-mBottomBarHeight,mPaintDivider);
        drawLines(canvas);

        if(mDrawCircleFill){
            mPaintText.setColor(Color.BLACK);
            canvas.drawCircle(mWidth/2, mHeight/2, (getResources().getDimension(R.dimen.circle_size)),mPaintEmpty);
            drawTextCentred(canvas,mPaintText, ""+mNumber,mWidth/2, mHeight/2);
        }else{
            canvas.drawCircle(mWidth/2, mHeight/2, getResources().getDimension(R.dimen.circle_size),mPaintFill);
            drawTextCentred(canvas,mPaintText, ""+mNumber,mWidth/2, mHeight/2);
        }

        drawTextCentred(canvas, mPaintWeekDates,mWeekdates,mWidth/2, mHeight- (getResources().getDimension(R.dimen.height_of_bottom_rectangle))/2);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.d("onSizeChanged", "sizeChanged...............x");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    public void drawTextCentred(Canvas canvas, Paint mPaintText, String text, float cx, float cy){
        mPaintText.getTextBounds(text, 0, text.length(), textBounds);
        canvas.drawText(text, cx - textBounds.exactCenterX(), cy - textBounds.exactCenterY(), mPaintText);
    }
    public void drawLines(Canvas canvas){

        float totalHeight = mHeight- (mBottomBarHeight + mTopBarHeight);
        float segmentHeight = totalHeight/(mMaxAntalPass+1);
        if(mMaxAntalPass<7){
            for(int i=0;i<mMaxAntalPass+1;i++){
                canvas.drawLine(0,(segmentHeight*(i)) + mTopBarHeight, mWidth, (segmentHeight*(i))+mTopBarHeight, mPaintDivider);
            }
        } else {
            for(int i=0;i<7;i++){
                canvas.drawLine(0,(segmentHeight*(i)), mWidth, (segmentHeight*(i)), mPaintDivider);
            }
        }

    }
    public void setWeekDates(String weekdates){
        mWeekdates = weekdates;
        invalidate();
        requestLayout();
    }

    public void setMaxAntalPass(int maxAntalPass){
        this.mMaxAntalPass = maxAntalPass;
        invalidate();
        requestLayout();
    }

}
