package com.example.dulal.e_book;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button button1;
    Button button2;
    public int i=0;

    public static final String[] sc={"অধ্যায়-0","অধ্যায়-1","অধ্যায়-2","অধ্যায়-3","অধ্যায়-4","অধ্যায়-5","অধ্যায়-6","অধ্যায়-7",
                            "অধ্যায়-8","অধ্যায়-9","অধ্যায়-10","অধ্যায়-11","অধ্যায়-12","অধ্যায়-13","অধ্যায়-14","অধ্যায়-15",
                            "অধ্যায়-16","অধ্যায়-17","অধ্যায়-18","অধ্যায়-19","অধ্যায়-20"};

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private static final String TAG="DescriptionActivity";
    private Bundle extras;
    private Context mContext;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        button1=(Button)findViewById(R.id.button_pre);
        button2=(Button)findViewById(R.id.button_next);

        mContext = DescriptionActivity.this;

        webView = (WebView) findViewById(R.id.simpleWebview);
        extras =getIntent().getExtras();
        if(!extras.equals(null))
        {
            String data = extras.getString("title");

            for (int a=0;a<sc.length;a++)
            {
                if(sc[a].equals(data)){
                    i=a;
                    break;
                }
            }

            String url="file:///android_asset/"+data+".html";
            webView.loadUrl(url);

            WebSettings webSettings=webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i>0)
                i--;
                else
                    Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT).show();

                    String url = "file:///android_asset/" + sc[i] + ".html";
                    webView.loadUrl(url);

                WebSettings webSettings=webView.getSettings();
                webSettings.setBuiltInZoomControls(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setJavaScriptEnabled(true);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i<sc.length-1)
                 i++;
                else
                    Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT).show();

                    String url = "file:///android_asset/" + sc[i] + ".html";
                    webView.loadUrl(url);


                WebSettings webSettings=webView.getSettings();
                webSettings.setBuiltInZoomControls(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setJavaScriptEnabled(true);


            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_description);
        mToggle =new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

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
