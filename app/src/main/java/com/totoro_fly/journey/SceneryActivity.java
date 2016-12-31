package com.totoro_fly.journey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SceneryActivity extends AppCompatActivity {

    @Bind(R.id.scenery_imageview_scenery_activity)
    ImageView sceneryImageviewSceneryActivity;
    @Bind(R.id.scenery_titel_textview_scenery_activity)
    TextView sceneryTitelTextviewSceneryActivity;
    @Bind(R.id.scenery_content_textview_scenery_activity)
    TextView sceneryContentTextviewSceneryActivity;
    @Bind(R.id.scenery_activity)
    LinearLayout sceneryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);
        ButterKnife.bind(this);
        Scenery scenery = getIntent().getParcelableExtra("scenery");
        int imageView = scenery.getmImage();
        sceneryImageviewSceneryActivity.setImageResource(imageView);
        String titel=scenery.getmTitel();
        sceneryTitelTextviewSceneryActivity.setText(titel);
        String content="\u3000\u3000"+scenery.getmContent();
        sceneryContentTextviewSceneryActivity.setText(content);
    }
}
