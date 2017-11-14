package com.dev.rohmts.materialdesigntabs.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.dev.rohmts.materialdesigntabs.Fragments.OneFragment;
import com.dev.rohmts.materialdesigntabs.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] array = new String[] {"Fixed tabs",
                "Tabs with icons and text", "Tabs with icons only", "Scrollable tabs"};
        List<String> list = new ArrayList<String>(Arrays.asList(array));

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) {
                    startActivity(new Intent(MainActivity.this, FixedTabsActivity.class));
                } else if (i==1) {
                    startActivity(new Intent(MainActivity.this, IconAndTextActivity.class));
                } else if (i==2) {
                    startActivity(new Intent(MainActivity.this, IconOnlyActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Comming soon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
