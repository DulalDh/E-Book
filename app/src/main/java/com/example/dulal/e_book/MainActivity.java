package com.example.dulal.e_book;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="MainActivity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle =new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mContext= MainActivity.this;

        titleArrayList = new ArrayList<String>();

        titleArrayList.add(Constants.sc0);
        titleArrayList.add(Constants.sc1);
        titleArrayList.add(Constants.sc2);
        titleArrayList.add(Constants.sc3);
        titleArrayList.add(Constants.sc4);
        titleArrayList.add(Constants.sc5);
        titleArrayList.add(Constants.sc6);
        titleArrayList.add(Constants.sc7);
        titleArrayList.add(Constants.sc8);
        titleArrayList.add(Constants.sc9);
        titleArrayList.add(Constants.sc10);
        titleArrayList.add(Constants.sc11);
        titleArrayList.add(Constants.sc12);
        titleArrayList.add(Constants.sc13);
        titleArrayList.add(Constants.sc14);
        titleArrayList.add(Constants.sc15);
        titleArrayList.add(Constants.sc16);
        titleArrayList.add(Constants.sc17);
        titleArrayList.add(Constants.sc18);
        titleArrayList.add(Constants.sc19);
        titleArrayList.add(Constants.sc20);

        mRecyclerView =(RecyclerView) findViewById(R.id.chapters_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        TitleAdapter adapter=new TitleAdapter(mContext, titleArrayList, new CustonClickLissenar() {

            @Override
            public void onItemClick(View v, int position) {

                Intent intent=new Intent(mContext,DescriptionActivity.class);
                intent.putExtra("title",titleArrayList.get(position));
                startActivity(intent);

                Toast.makeText(mContext, ""+titleArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.chapters)
        {
            startActivity(new Intent(this, MainActivity.class));
        }
        else if (id==R.id.about)
        {
            startActivity(new Intent(this, AboutActivity.class));
        }
        else if (id==R.id.exit)
        {
            moveTaskToBack(true);
            android.os.Process.killProcess( android.os.Process.myPid());
            System.exit(1);
        }

        return false;
    }
}
