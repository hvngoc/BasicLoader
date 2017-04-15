package image.basic.com.basicloader.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import image.basic.com.basicloader.R;

public class TranslucentActivity extends AppCompatActivity {
    View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
        mView = findViewById(R.id.bottom);
        enableFullScreen(true);

        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableFullScreen(false);
                showBottom();
            }
        });

        findViewById(R.id.pager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableFullScreen(true);
                hideBottom();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        enableFullScreen(false);
    }

    protected void enableFullScreen(boolean enabled) {
        int newVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        if (enabled) {
            newVisibility |= View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
        }
        getWindow().getDecorView().setSystemUiVisibility(newVisibility);
    }

    private void hideBottom() {
        mView.animate().translationY(mView.getHeight());
    }

    private void showBottom() {
        mView.animate().translationY(0);
    }
}
