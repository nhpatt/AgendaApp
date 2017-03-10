package com.nhpatt.agendaapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView favoriteImage = (ImageView) findViewById(R.id.favorite_image);
    favoriteImage.setColorFilter(getResources().getColor(R.color.colorPrimary));
  }
}
