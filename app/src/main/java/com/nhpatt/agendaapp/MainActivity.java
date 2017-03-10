package com.nhpatt.agendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FAVORITE_STATE = "FAVORITE_STATE";
    private boolean favorite;
    private ImageView favoriteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favoriteImage = (ImageView) findViewById(R.id.favorite_image);
        favoriteImage.setColorFilter(getResources().getColor(R.color.colorPrimary));
        favoriteImage.setOnClickListener(this);

        findViewById(R.id.row).setOnClickListener(this);

        Log.d("TAG", "Hi!");

        List<String> strings = new ArrayList<>();
        strings.add("uno");
        strings.add("dos");

        RecyclerView listView = (RecyclerView) findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(new TalkAdapter(strings));
    }

    @Override
    protected void onResume() {
        super.onResume();

        fillHeartIfSelected();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.row) {
            startActivity(new Intent(this, DetailTalkActivity.class));
        } else {
            favorite = !favorite;
            fillHeartIfSelected();

            if (favorite) {
                Toast.makeText(this, "Favorite!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(FAVORITE_STATE, favorite);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        favorite = savedInstanceState.getBoolean(FAVORITE_STATE);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void fillHeartIfSelected() {
        int id = favorite ? R.drawable.favorite : R.drawable.favorite_border;
        favoriteImage.setImageDrawable(ContextCompat.getDrawable(this, id));
    }

}
