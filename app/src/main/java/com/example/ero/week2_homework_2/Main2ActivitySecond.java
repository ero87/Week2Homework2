package com.example.ero.week2_homework_2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2ActivitySecond extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private static ArrayList<Model2Second> itemComm;
    private Model2Second model2Second;
    private CoordinatorLayout secondLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView sendtext = findViewById(R.id.ttttttt);

        final String str = getIntent().getStringExtra("e");
        sendtext.setText(str);
        final String url2 = getIntent().getStringExtra("q");

        itemComm = new ArrayList<>();
        model2Second = new Model2Second(str, url2, "bro");
        itemComm.add(model2Second);
        ImageView image2 = findViewById(R.id.image2);
        Picasso.get().load(model2Second.getImageUrl2()).into(image2);


        final EditText editText = findViewById(R.id.editText2);
        final MyAdapter2Second myAdapter2Second = new MyAdapter2Second(itemComm, this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = editText.getText().toString();
                model2Second = new Model2Second("Ero", "udss", s);
                itemComm.add(model2Second);
                myAdapter2Second.notifyDataSetChanged();

                editText.setText(null);
                secondLayout = findViewById(R.id.second2);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                assert inputMethodManager != null;
                inputMethodManager.hideSoftInputFromWindow(secondLayout.getWindowToken(), 0);


            }
        });
        recyclerView = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter2Second);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
