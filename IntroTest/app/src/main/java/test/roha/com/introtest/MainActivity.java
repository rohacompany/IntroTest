package test.roha.com.introtest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.logging.Logger;

public class MainActivity extends Activity {
    CustomVideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (CustomVideoView) findViewById(R.id.video_view);

        showIntroVideo();
    }

    ProgressDialog progressDialog;
    int position;
    public void showIntroVideo(){


        //initialize the VideoView

        // create a progress bar while the video file is loading
        progressDialog = new ProgressDialog(MainActivity.this);
        // set a title for the progress bar
        progressDialog.setTitle("테스트중");
        // set a message for the progress bar
        progressDialog.setMessage("Loading...");
        //set the progress bar not cancelable on users' touch
        progressDialog.setCancelable(false);
        // show the progress bar
        progressDialog.show();

        try {
            //set the media controller in the VideoView
//            videoView.setMediaController(mediaControls);


            //set the uri of the video to be played
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro));

        } catch (Exception e) {
            e.printStackTrace();
        }

        videoView.requestFocus();
        //we also set an setOnPreparedListener in order to know when the video file is ready for playback
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                // close the progress bar and play the video
                progressDialog.dismiss();
                //if we have a position on savedInstanceState, the video playback should start from here
                mediaPlayer.setLooping(true);
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                } else {
                    //if we come from a resumed activity, video playback will be paused
                    videoView.pause();
                }
            }
        });
    }
}
