package image.basic.com.basicloader.global;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.TypedValue;
import android.widget.TextView;

import image.basic.com.basicloader.helper.RoundedBackgroundSpan;

/**
 * Created by Ngoc Hoang on 15/03/2017.
 */

public class RoundedSpanUtils {
    public static void setTags(TextView mTextView, String[] tags, Context context, int backgroundColor, int textColor, int textSize) {
        if (tags == null) {
            return;
        }
        /** Tricking the text view for getting a bigger line height */
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 2);

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();

        String between = " ";
        int tagStart = 0;

        for (String tag : tags) {
            /** Append tag and space after */
            stringBuilder.append(tag);
            stringBuilder.append(between);

            /** Set span for tag */
            RoundedBackgroundSpan tagSpan = new RoundedBackgroundSpan(context, backgroundColor, textColor, textSize);
            stringBuilder.setSpan(tagSpan, tagStart, tagStart + tag.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            /** Update to next tag start */
            tagStart += tag.length() + between.length();
        }
        mTextView.setText(stringBuilder);
    }
}
