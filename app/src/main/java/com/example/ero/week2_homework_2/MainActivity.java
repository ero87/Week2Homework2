package com.example.ero.week2_homework_2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private static ArrayList<Model> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        item = new ArrayList<>();
        final Model model1 = new Model("R O N A L D O", "https://images.wallpaperscraft.ru/image/ronaldo_ronaldo_zubastik_fenomen_real_mardid_real_madrid_sbornaya_braziliya_brazil_futbolist_zvezda_legenda_futbol_93672_2560x1600.jpg");

        final Model model2 = new Model("M E S S i", "https://www.telegraph.co.uk/content/dam/football/2017/04/24/e42a5cb8-71e6-4210-bffe-4981f5d48ebf_trans_NvBQzQNjv4BqvzJnqpVGpnfyf5cbbtTpCepYZ4gU4cy2Y6_VNWzOQhI.jpeg?imwidth=450");

        item.add(model1);
        item.add(model2);
        item.add(model1);
        item.add(model2);
        item.add(model1);
        item.add(model2);

        final MyAdapter adapter = new MyAdapter(item, this);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.add(model1);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(item.size() - 1);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
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
