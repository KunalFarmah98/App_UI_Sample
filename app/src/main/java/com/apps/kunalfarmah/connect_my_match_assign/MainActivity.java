package com.apps.kunalfarmah.connect_my_match_assign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public ArrayList<Integer> imglist = new ArrayList<>() ;
    public ArrayList<String> percentage = new ArrayList<>();
    public ArrayList<String> titlelist = new ArrayList<>();

    public ArrayList<Study> slist = new ArrayList<>();


    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.subjects);

        // rightnow hardcoding values

        imglist.add(R.drawable.mat);
        imglist.add(R.drawable.physics);
        imglist.add(R.drawable.chem);
        imglist.add(R.drawable.maths);
        //imglist.add(R.drawable.comp);

        titlelist.add("Mental Ability");
        titlelist.add("Physics");
        titlelist.add("Chemistry");
        titlelist.add("Mathematics");
        //titlelist.add("Computer Science");

        percentage.add("0%");
        percentage.add("0%");
        percentage.add("0.71%");
        percentage.add("0%");
        //percentage.add("1.5%");

        for(int i=0; i<imglist.size(); i++){
            slist.add(new Study(imglist.get(i),titlelist.get(i),percentage.get(i)));
//            slist.get(i).setHeader(titlelist.get(i));
//            slist.get(i).setImgID(imglist.get(i));
//            slist.get(i).setPerc(percentage.get(i));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        StudyAdapter mAdapter = new StudyAdapter(this,slist);
        mAdapter.notifyDataSetChanged();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_icons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Help) {
            Toast.makeText(this,"Help",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ContactUS) {
            Toast.makeText(this,"Contact: 9654211634",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    
                  //  mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_tests:
                   // mTextMessage.setText("tests");
                    return true;
                case R.id.navigation_analysis:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_doubts:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
                  // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
}
