package com.totoro_fly.journey;

import android.media.AudioManager;
import android.media.MediaPlayer;
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
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_GAIN)
                mediaPlayer.start();
            else if (i == AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);
        ButterKnife.bind(this);
        Scenery scenery = getIntent().getParcelableExtra("scenery");
        releaseMediaPlayer();
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer = MediaPlayer.create(this, scenery.getmMusic());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    releaseMediaPlayer();
                }
            });
        }
        int imageView = scenery.getmImage();
        sceneryImageviewSceneryActivity.setImageResource(imageView);
        String titel = scenery.getmTitel();
        sceneryTitelTextviewSceneryActivity.setText(titel);
        String content = "\u3000\u3000" + scenery.getmContent();
        sceneryContentTextviewSceneryActivity.setText(content);
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }
}
