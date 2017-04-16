package image.basic.com.basicloader.decoration;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import image.basic.com.basicloader.R;

/**
 * Created by Ngoc Hoang on 15/04/2017.
 */

public class DecorationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_decoration, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        String title = "abc123def456";
        SpannableString ss = new SpannableString(title + " ");

        Drawable d = ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_drop_down_black_24px);
        DrawableCompat.setTint(d, ContextCompat.getColor(getContext(), R.color.colorPrimary));
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        ss.setSpan(span, title.length(), title.length() + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(ss);
    }
}
