package edu.hanu.a1_2001040069;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    MediaPlayer currentSound;
    Button hiraganaMode, katakanaMode;
    TextView hiraganaTitle, katakanaTitle;
    ScrollView hiraganaTable, katakanaTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        hiraganaTitle = findViewById(R.id.hiraganaTitle);
        katakanaTitle = findViewById(R.id.katakanaTitle);
        hiraganaTable = findViewById(R.id.hiraganaTable);
        katakanaTable = findViewById(R.id.katakanaTable);
        hiraganaTitle.setAlpha(1);
        katakanaTitle.setAlpha(0);
        hiraganaTable.setVisibility(View.VISIBLE);
        katakanaTable.setVisibility(View.GONE);

        hiraganaMode = findViewById(R.id.hiraganaMode);
        hiraganaMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiraganaTitle.animate().alpha(1).setDuration(2000);
                katakanaTitle.animate().alpha(0).setDuration(2000);
                hiraganaTable.animate().alpha(1).setDuration(2000);
                hiraganaTable.setVisibility(View.VISIBLE);
                katakanaTable.animate().alpha(0).setDuration(2000);
                katakanaTable.setVisibility(View.GONE);
                hiraganaMode.setBackgroundColor(Color.rgb(25,147,204));
                katakanaMode.setBackgroundColor(Color.WHITE);
            }
        });

        katakanaMode = findViewById(R.id.katakanaMode);
        katakanaMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                katakanaTitle.animate().alpha(1).setDuration(2000);
                hiraganaTitle.animate().alpha(0).setDuration(2000);
                katakanaTable.animate().alpha(1).setDuration(2000);
                katakanaTable.setVisibility(View.VISIBLE);
                hiraganaTable.animate().alpha(0).setDuration(2000);
                hiraganaTable.setVisibility(View.GONE);
                katakanaMode.setBackgroundColor(Color.rgb(25,147,204));
                hiraganaMode.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void playAudio(View view) {
        String resourceName = view.getResources().getResourceName(view.getId());

        String audioPath = "android.resource://" + getPackageName() + "/raw/" + resourceName.substring(35);
        Uri audioUri = Uri.parse(audioPath);
        if (currentSound != null) {
            currentSound.stop();
            currentSound.release();
            currentSound = MediaPlayer.create(this, audioUri);
            currentSound.start();
        } else {
            currentSound = MediaPlayer.create(this, audioUri);
            currentSound.start();
        }
    }
}