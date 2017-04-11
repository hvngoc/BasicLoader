package image.basic.com.basicloader.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import image.basic.com.basicloader.R;
import image.basic.com.basicloader.global.RoundedSpanUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.text);

        String[] s = new String[]{"hefsfdllo", "helffflo", "hello", "hello", "324f23"
                , "hel4234sdfsadflo", "324sdfsadf", "he333llo", "hello", "sdfdf", "hell12312o",
                "ff", "234sdf3", "helsdafasffflo", "hefsfdllo"
                , "helffflo", "hello", "hello", "324f23"
                , "hel4234sdfsadflo", "324sdfsadf", "he333llo", "hello", "sdfdf", "hell12312o",
                "ff", "234sdf3", "helsdafasffflo"};

        RoundedSpanUtils.setTags(text, s, this,
                Color.RED, Color.WHITE, getResources().getDimensionPixelSize(R.dimen.text_12sp));


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TranslucentActivity.class));
            }
        });
    }
}
