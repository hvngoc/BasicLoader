package image.basic.com.basicloader.decoration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import image.basic.com.basicloader.R;

/**
 * Created by Ngoc Hoang on 15/04/2017.
 */

public class DecorationActivity extends AppCompatActivity {
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar();

        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, new DecorationFragment());
        mFragmentTransaction.commit();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DecorationActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
