package image.basic.com.basicloader.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.style.ReplacementSpan;

import image.basic.com.basicloader.R;

/**
 * Created by Ngoc Hoang on 14/03/2017.
 */

public class RoundedBackgroundSpan extends ReplacementSpan {

    private static final int CORNER_RADIUS = 16;
    private static int PADDING_X = 0;
    private static int PADDING_Y = 0;
    private int mBackgroundColor;
    private int mTextColor;
    private int mTextSize;
    private Context mContext;

    /**
     * @param backgroundColor color value, not res id
     * @param textSize        in pixels
     */
    public RoundedBackgroundSpan(Context context, int backgroundColor, int textColor, int textSize) {
        mContext = context;
        mBackgroundColor = backgroundColor;
        mTextColor = textColor;
        mTextSize = textSize;

        PADDING_X = mContext.getResources().getDimensionPixelSize(R.dimen.dimen_8dp);
        PADDING_Y = mContext.getResources().getDimensionPixelSize(R.dimen.dimen_2dp);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end,
                     float x, int top, int y, int bottom, @NonNull Paint paint) {
        paint = new Paint(paint);

        paint.setTextSize(mTextSize);

        /** Draw the rounded background */
        if (top == 0)
            top = PADDING_Y + PADDING_Y - PADDING_Y / 2;
        paint.setColor(mBackgroundColor);
        int textHeightWrapping = mContext.getResources().getDimensionPixelSize(R.dimen.dimen_4dp);
        float tagBottom = top + textHeightWrapping + PADDING_Y + mTextSize + PADDING_Y + textHeightWrapping;
        float tagRight = x + getTagWidth(text, start, end, paint);
        RectF rect = new RectF(x, top, tagRight, tagBottom);
        canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);

        /** Draw the text */
        paint.setColor(mTextColor);
        canvas.drawText(text, start, end, x + PADDING_X, tagBottom - PADDING_Y - textHeightWrapping - PADDING_Y, paint);
    }

    private int getTagWidth(CharSequence text, int start, int end, Paint paint) {
        return Math.round(PADDING_X + paint.measureText(text.subSequence(start, end).toString()) + PADDING_X);
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        paint = new Paint(paint);
        paint.setTextSize(mTextSize);
        return getTagWidth(text, start, end, paint);
    }
}
