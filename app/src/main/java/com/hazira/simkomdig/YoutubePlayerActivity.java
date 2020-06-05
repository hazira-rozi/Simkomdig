package com.hazira.simkomdig;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class YoutubePlayerActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
//    YouTubePlayer.OnFullscreenListener onFullscreenListener;

    TextView tv;
//    ExtendedFloatingActionButton fabPlay;
//    ExtendedFloatingActionButton backToLesson;



    // add the Toolbar
//    Toolbar toolbarvid= (Toolbar) findViewById(R.id.toolbarytPlayer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

//        Button bPlay = (Button) findViewById(R.id.buttonPlayYT);
        Intent intents = getIntent();
        String vidLink = intents.getExtras().getString("videoURI", "fsdsd");
        String vidTitle = intents.getExtras().getString("videoTitle", "something wrong");
//        Toolbar toolbar = findViewById(R.id.toolbarytPlayer);
////        setSupportActionBar(toolbar);
//        tv = (TextView) findViewById(R.id.video_play_text);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.playerYT);

//        tv.setText(vidTitle);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(vidLink); //"K68X3RvME2k"
//                youTubePlayer.cueVideo(vidLink,5000);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(PlayerConfig.API_KEY, onInitializedListener);

    }




}